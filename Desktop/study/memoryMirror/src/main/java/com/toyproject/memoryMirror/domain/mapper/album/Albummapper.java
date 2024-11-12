package com.toyproject.memoryMirror.domain.mapper.album;

import com.toyproject.memoryMirror.domain.model.album.Album;
import com.toyproject.memoryMirror.domain.model.album.AlbumDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface Albummapper {
    List<Album> getSavedAlbums(Long userid);

    Long createAlbum(Album album);

    //myBatis에서 메서드 파라미터를 여러개 받을때 @Param을 사용하면 각 파라미터에 이름을 붙일수있다
    void saveAlbumsDetail(@Param("albumId") Long albumId, @Param("urlList") List<String> urlList);

    List<AlbumDetail> getAlbumDetails(Long albumId);

    Album getAlbumInfo(Long albumId);

    void deleteAlbum(AlbumDetail albumDetail);

    void updateAlbum(Album album);

    List<String> getAlbumUrlList(Long albumId);

    void deleteAlbumDetailAll(Long albumId);

    void deleteAlbumAll(Long albumId);
}
