package com.toyproject.memoryMirror.domain.model.album;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@RequiredArgsConstructor
public class Album {

    private final Long id;
    private final Long userId;
    private final String title;
    private final String description;
    private final LocalDate createdAt;

}
