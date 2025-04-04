package com.toyproject.memoryMirror.domain.model.dto;

import com.toyproject.memoryMirror.domain.model.album.Album;
import com.toyproject.memoryMirror.domain.model.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class UserAlbumResponseDTO {

    private final List<Album> album;
    private final User user;

}
