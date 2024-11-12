package com.toyproject.memoryMirror.web.controller.album;

import com.toyproject.memoryMirror.domain.model.album.Album;
import com.toyproject.memoryMirror.domain.model.album.AlbumDetail;
import com.toyproject.memoryMirror.domain.service.album.AlbumService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AlbumController {

    private final AlbumService albumService;

    //1. 로그인 성공후 앨범 조회
    @GetMapping("/albums")
    public ResponseEntity<Object> albums() {
        //아이디로 앨범 가져오기 : 있으면 리스트 출력, 없으면 공백값 보내기
        List<Album> albumList = albumService.getSavedAlbums();

        return ResponseEntity.status(HttpStatus.OK)
                .body(albumList);
    }

    /**
     * 앨범을 생성하는 메소드
     *
     * @param album : 앨범의 제목과 설명을 담은 객체
     * @param files : 앨범에 추가할 사진 파일들의 리스트
     * @return 앨범 생성 결과 메시지
     */
    @PostMapping("/albums")
    public ResponseEntity<Object> createAlbum(@ModelAttribute Album album,
                                              @RequestParam("files") MultipartFile[] files) throws IOException {

        albumService.createAlbum(album, files);

        //저장후 앨범 조회로 돌아가기
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /***
     * 생성된 앨범의 저장된 사진 리스트를 조회하는 메서드
     * @param albumId
     * @return
     */
    @GetMapping("/albumDetail")
    public ResponseEntity<Object> albumDetails(@RequestParam("albumId") Long albumId , HttpSession session) {

        List<AlbumDetail> albumDetails = albumService.getAlbumDetails(albumId);
        Album albumInfo = albumService.getAlbumInfo(albumId);

        //해당 앨범 정보 redis에 저장 : 클라이언트에서 localstorege나 fetch사용시 post로 데이터를
        //                         담는다는게 별로 좋은게 아닌거 같아서 redis세션에 담아서 보내는데 이게 좋은 방법인지는 잘 모르겠다.
        albumService.saveSession(session, albumDetails, albumInfo);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /***
     * 앨범 사진 삭제 메서드
     * @param albumDetail
     * @return
     */
    @PatchMapping("/albums")
    public ResponseEntity<Object> albumDelete(@RequestBody AlbumDetail albumDetail) {
        //앨범삭제동
        albumService.deleteAlbum(albumDetail);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /***
     * 앨범 소개정보, 사진파일 수정 메서드
     * @param album 앨범에 관한 설명정보
     * @param files 앨범에 저장할 이미지 사진 정보
     * @return
     */
    @PutMapping("/albums")
    public ResponseEntity<Object> albumUpdate(@ModelAttribute Album album
            , @RequestParam("files") MultipartFile[] files) throws IOException {
        albumService.updateAlbum(album, files);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /***
     * 홈화면에서 선택삭제하여 앨범전체 삭제 메서드
     * @param albumsId 저장된 album의 id값들
     * @return
     */
    @DeleteMapping("/albums")
    public ResponseEntity<Object> albumsDelete(@RequestParam("deleteId") List<Long> albumsId) {

        albumService.deleteAlbums(albumsId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
