package com.habitmon.domain.habitmon.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Age {
    EGG("egg"),
    BABY("baby"),
    TEEN("teen"),
    ADULT("adult");

    private final String value;
}
