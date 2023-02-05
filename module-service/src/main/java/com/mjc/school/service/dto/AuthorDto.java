package com.mjc.school.service.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private String name;

    public AuthorDto(String name) {
        this.name = name;
        this.createDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
    }

    public AuthorDto(Long id, String name) {
        this.id = id;
        this.name = name;
        this.createDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
    }
}
