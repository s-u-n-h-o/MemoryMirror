package com.toyproject.memoryMirror.domain.model.album;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class AlbumDetail {

    private  Long id;
    private  String fileName;
    private int fixed;

    public AlbumDetail() {

    }
}
