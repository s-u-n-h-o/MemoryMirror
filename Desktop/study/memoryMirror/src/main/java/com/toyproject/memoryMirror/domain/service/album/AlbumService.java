package com.toyproject.memoryMirror.domain.service.album;

import com.toyproject.memoryMirror.domain.mapper.album.Albummapper;
import com.toyproject.memoryMirror.domain.model.album.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AlbumService {

    private final Albummapper albummapper;

    public List<Album> getSavedAlbums(String userid) {
        List<Album> albumList = albummapper.getSavedAlbums(userid);

        return albumList;
    }
}
