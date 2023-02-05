package com.mjc.school.service.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class BaseDto {
    protected Long id;
    protected LocalDateTime createDate;
    protected LocalDateTime lastUpdateDate;
}
