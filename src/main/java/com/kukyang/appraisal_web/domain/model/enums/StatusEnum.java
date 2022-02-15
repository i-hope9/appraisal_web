package com.kukyang.appraisal_web.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    ENABLE ("사용"),
    DISABLE ("미사용"),
    DELETED ("삭제");

    private String name;

}
