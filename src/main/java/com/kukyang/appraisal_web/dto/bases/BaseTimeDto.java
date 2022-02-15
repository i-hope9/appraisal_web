package com.kukyang.appraisal_web.dto.bases;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BaseTimeDto {

    protected LocalDateTime createdAt;

    protected LocalDateTime modifiedAt;
}
