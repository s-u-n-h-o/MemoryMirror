package com.toyproject.memoryMirror.domain.model.album;

import lombok.*;


import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Album {

    private Long id;
    private Long userId;
    private String title;
    private String description;
    private LocalDate createdAt;

    public Album() {

    }
}

