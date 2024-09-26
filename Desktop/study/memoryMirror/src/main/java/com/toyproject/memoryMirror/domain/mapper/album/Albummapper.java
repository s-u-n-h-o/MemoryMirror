package com.toyproject.memoryMirror.domain.mapper.album;

import com.toyproject.memoryMirror.domain.model.album.Album;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface Albummapper {
    List<Album> getSavedAlbums(String userid);
}
