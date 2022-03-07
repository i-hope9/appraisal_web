package com.kukyang.appraisal_web.dto.bases;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseTimeDto {

    protected LocalDateTime createdAt;

    protected LocalDateTime modifiedAt;
}
