package com.toyproject.memoryMirror.domain.service.album;

import com.toyproject.memoryMirror.domain.mapper.album.Albummapper;
import com.toyproject.memoryMirror.domain.model.album.Album;
import com.toyproject.memoryMirror.domain.utils.S3Utils;
import jakarta.validation.constraints.AssertTrue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AlbumServiceTest {

    @Mock
    private Albummapper albummapper;

    @InjectMocks
    private AlbumService albumService;

    @InjectMocks
    private S3Utils s3Utils;

    private MockHttpSession httpSession;

    private MockMvc mockMvc;

    @BeforeEach
    @DisplayName("세션정보 셋팅")
    void sessionSetUp() {
        httpSession = new MockHttpSession();
        httpSession.setAttribute("userSequenceId", 1L);
        //AlbumService는 Spring 컨테이너가 관리하는 빈, HttpSession 생성자 주입을 받는데
        //테스트 코드에서는 MockHttpSession을 생성하고 값을 넣어도 Spring컨테이너가 관리하는 httpSession과는 별개 객체이기때문에 자꾸
        //null을 반환했던것
        //따라서 생성자에 MockHttpSession을 직접주입
        albumService = new AlbumService(albummapper, httpSession, s3Utils);
    }

    @Test
    @DisplayName("로그인한 회원아이디로 저장된 앨범정보 조회 성공시")
    void givenUserSavedAlbum_whenGetSavedAlbums_thenReturnAlbumList() {
        //given
        Mockito.when(albummapper.getSavedAlbums(1L)).thenReturn(createAlbum());

        //when
        List<Album> albumList = albumService.getSavedAlbums();

        //then
        Assertions.assertThat(albumList).hasSize(2);
    }

    @Test
    @DisplayName("로그인한 회원아이디로 저장된 앨범정보 조회 실패시 Empty객체 반환")
    void givenUserNoSavedAlbum_whenGetSavedAlbums_thenReturnEmptyList() {
        //given
        Mockito.when(albummapper.getSavedAlbums(1L)).thenReturn(new ArrayList<>());

        //when
        List<Album> albumList = albumService.getSavedAlbums();

        //then
        Assertions.assertThat(albumList).hasSize(0);
    }

    private List<Album> createAlbum() {
        List<Album> albumList = new ArrayList<>();
        Album album = Album.builder()
                .id(1L)
                .title("test1")
                .description("테스트입니다")
                .createdAt(LocalDate.parse("2024-09-26"))
                .build();
        Album album2 = Album.builder()
                .id(1L)
                .title("test2")
                .description("테스트2입니다")
                .createdAt(LocalDate.parse("2025-01-01"))
                .build();
        albumList.add(album);
        albumList.add(album2);

        return albumList;
    }
}