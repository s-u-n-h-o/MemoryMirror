package com.toyproject.memoryMirror.domain.service.album;

import com.toyproject.memoryMirror.domain.mapper.album.Albummapper;
import com.toyproject.memoryMirror.domain.model.album.Album;
import com.toyproject.memoryMirror.domain.model.album.AlbumDetail;
import com.toyproject.memoryMirror.domain.utils.S3Utils;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlbumService {

    private final Albummapper albummapper;

    private final HttpSession httpSession;

    private final S3Utils s3Utils;

    List<String> urlList;

    @Transactional
    public List<Album> getSavedAlbums() {
        Long userId = Long.parseLong(String.valueOf(httpSession.getAttribute("userSequenceId")));
        List<Album> albumList = albummapper.getSavedAlbums(userId);

        return albumList;
    }

    @Transactional
    public void createAlbum(Album album, MultipartFile[] files) throws IOException {

        //세션에 저장된 값이 Object타입으로 변환되어 string -> Long타입으로 캐스팅해준다.
        Long userId = Long.parseLong(String.valueOf(httpSession.getAttribute("userSequenceId"))); //로그인시에 세션에 저장된 유저시퀀스 조회
        Album newAlbum = Album.builder()
                .userId(userId)
                .title(album.getTitle())
                .description(album.getDescription())
                .build();

        //1. 앨범 저장
        albummapper.createAlbum(newAlbum);
        Long albumId = newAlbum.getId();

        //2. 첨부 이미지 저장
         filesUpload(files);

        //3. DB에 첨부 파일 저장
        albummapper.saveAlbumsDetail(albumId,urlList);
    }

    public List<AlbumDetail> getAlbumDetails(Long albumId) {
        List<AlbumDetail> albumDetails = albummapper.getAlbumDetails(albumId);

        return albumDetails;
    }

    public void saveSession(HttpSession session, List<AlbumDetail> albumDetails, Album albumInfo) {
        session.setAttribute("albumDetails", albumDetails);
        session.setAttribute("albumInfo", albumInfo);
    }

    public Album getAlbumInfo(Long albumId) {
        Album albumInfo = albummapper.getAlbumInfo(albumId);

        return albumInfo;
    }

    @Transactional
    public void deleteAlbum(AlbumDetail albumDetail) {
        //aws 파일 삭제
        s3Utils.filesDelete(albumDetail.getFileName());

        //DB삭제
        albummapper.deleteAlbum(albumDetail);
    }

    @Transactional
    public void updateAlbum(Album album, MultipartFile[] files) throws IOException {
        //앨범 정보 업데이트
        albummapper.updateAlbum(album);

        //첨부파일 저장
        filesUpload(files);

        //DB업데이트
        albummapper.saveAlbumsDetail(album.getId(), urlList);
    }

    @Transactional
    void filesUpload(MultipartFile[] files) throws IOException {
        if (files.length > 1) { //다중 이미지 일때
            urlList = s3Utils.filesUpload(files);
        }else {
            urlList = List.of(s3Utils.fileUpload(files[0]));
        }
    }

    @Transactional
    public void deleteAlbums(List<Long> albumsId) {
        for (Long albumId : albumsId) {
            //1. 해당 id값으로 urlList가져오기
            List<String> albumUrlList = albummapper.getAlbumUrlList(albumId);

            if(!albumUrlList.isEmpty()) {
                //aws의 사진 삭제
                s3Utils.filesDelete(albumUrlList);

                //DB앨범상세정보 삭제
                albummapper.deleteAlbumDetailAll(albumId);
            }
            //DB앨범 삭제
            albummapper.deleteAlbumAll(albumId);
        }
    }
}
