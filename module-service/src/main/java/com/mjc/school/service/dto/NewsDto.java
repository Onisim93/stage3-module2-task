package com.mjc.school.service.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class NewsDto{
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private String title;
    private String content;
    private Long authorId;

    public NewsDto(String title, String content, Long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
    }

    public NewsDto(Long id, String title, String content, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
    }
}
