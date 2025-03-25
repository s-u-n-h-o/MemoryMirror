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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @BeforeEach
    @DisplayName("세션정보 셋팅")
    void sessionSetUp() {
        httpSession = new MockHttpSession();
        httpSession.setAttribute("userSequenceId", 1L);
        //AlbumService는 Spring 컨테이너가 관리하는 빈, HttpSession 생성자 주입을 받는데
        //테스트 코드에서는 MockHttpSession을 생성하고 값을 넣어도 Spring컨테이너가 관리하는 httpSession과는 별개 객체이기때문에 자꾸
        //null을 반환했던것
        //따라서 생성자에 MockHttpSession을 직접주입
        //albumService = new AlbumService(albummapper, httpSession, s3Utils);
    }

    @BeforeEach
    @DisplayName("앨범파일 생성")
    void multipartFileSetUp() {

    }

    @Test
    @DisplayName("로그인한 회원아이디로 저장된 앨범정보 조회 성공시")
    void givenUserSavedAlbum_whenGetSavedAlbums_thenReturnAlbumList() {
        //given
        Mockito.when(albummapper.getSavedAlbums(1L)).thenReturn(createAlbums());

        //when
//        List<Album> albumList = albumService.getSavedAlbums();

        //then
//        Assertions.assertThat(albumList).hasSize(2);
    }

    @Test
    @DisplayName("로그인한 회원아이디로 저장된 앨범정보 조회 실패시 Empty객체 반환")
    void givenUserNoSavedAlbum_whenGetSavedAlbums_thenReturnEmptyList() {
        //given
        Mockito.when(albummapper.getSavedAlbums(1L)).thenReturn(new ArrayList<>());

        //when
//        List<Album> albumList = albumService.getSavedAlbums();

        //then
//        Assertions.assertThat(albumList).hasSize(0);
    }

    @Test
    @DisplayName("앨범생성 성공했을 경우")
    void createAlbum_WithValidAlbumAndFiles_ShouldCreateAlbumSuccessfully() throws IOException {
        //given
        MockMultipartFile file = new MockMultipartFile("files", "test1.jpg", "image/jpeg", "image-content-1".getBytes());
        MultipartFile[] files = {file};

        albumService.createAlbum(createAlbum(), files);

        //then

    }

    @Test
    @DisplayName("앨범생성시 파일이 없는경우 -> 파일업이 저장가능")
    void createAlbum_WithNoFiles_ShouldCreateAlbumWithoutFiles() {

    }

    @Test
    @DisplayName("앨범생성시 앨범정보가 없는경우")
    void createAlbum_WithFileUploadFailure_ShouldThrowException() {

    }

    @Test
    @DisplayName("앨범아이디로 저장된 상세정보 조회 성공")
    void givenAlbumId_whenGetAlbumDetails_thenReturnAlbumDetailList() {

    }

    @Test
    @DisplayName("앨범아이디로 저장된 상세정보 조회 실패")
    void givenNoAlbumId_whenGetAlbumDetails_thenReturnEmptyAlbumDetailList() {

    }

    @Test
    @DisplayName("잘못된 앨범아이디로 상세정보 조회시 실패")
    void givenInvalidAlbumId_whenGetAlbumDetails_thenReturnFailure() {

    }

    private List<Album> createAlbums() {
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

    private Album createAlbum() {
        Album album = Album.builder()
                .id(1L)
                .title("test1")
                .description("테스트입니다")
                .createdAt(LocalDate.parse("2024-09-26"))
                .build();
        return album;
    }
}