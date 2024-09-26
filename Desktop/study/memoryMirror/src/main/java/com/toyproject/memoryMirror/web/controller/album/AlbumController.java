package com.toyproject.memoryMirror.web.controller.album;

import com.toyproject.memoryMirror.domain.model.album.Album;
import com.toyproject.memoryMirror.domain.service.album.AlbumService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AlbumController {

    private final AlbumService albumService;

    //1. 로그인 성공후 앨범 조회
    @GetMapping("/albums")
    public ResponseEntity<Object> albums(HttpSession session) {
        //로그인이 된 후 해당 아이디로 앨범 리스트 조회
        String userid = session.getId();
        log.info("아이디 : {}", userid);

        //아이디로 앨범 가져오기 : 있으면 리스트 출력, 없으면 공백값 보내기
        List<Album> albumList = albumService.getSavedAlbums(userid);

        return ResponseEntity.status(HttpStatus.OK)
                .body(albumList);
    }
}
