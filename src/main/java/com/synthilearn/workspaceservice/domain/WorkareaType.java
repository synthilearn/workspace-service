package com.synthilearn.workspaceservice.domain;

import lombok.Getter;

@Getter
public enum WorkareaType {
    LEARN_LANGUAGE("Изучение английского языка");

    private final String title;

    WorkareaType(String title) {
        this.title = title;
    }
}
