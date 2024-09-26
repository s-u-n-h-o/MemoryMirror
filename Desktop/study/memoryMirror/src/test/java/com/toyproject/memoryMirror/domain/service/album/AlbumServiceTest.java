package com.toyproject.memoryMirror.domain.service.album;

import com.toyproject.memoryMirror.domain.mapper.album.Albummapper;
import com.toyproject.memoryMirror.domain.model.album.Album;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlbumServiceTest {

    @Mock
    private Albummapper albummapper;

    @InjectMocks
    private AlbumService albumService;

    @Test
    @DisplayName("로그인한 회원아이디로 저장된 앨범 리스트 조회")
    void getSavedAlbums() {

        String userid = "sunho";
        Album album = createAlbum();
        List<Album> albums = mock(ArrayList.class);
        albums.add(album);

        //getSaveAlbums메서드 호출시 albums반환
        when(albummapper.getSavedAlbums(userid)).thenReturn(albums);

        List<Album> albumList = albumService.getSavedAlbums(userid);

        //저장된 앨범 리스트가 있는경우
        assertThat(albumList.isEmpty()).isFalse();
    }

    private Album createAlbum() {
        return Album.builder()
                .id(1L)
                .title("test1")
                .description("테스트입니다")
                .createdAt(LocalDate.parse("2024-09-26"))
                .build();
    }
}