package com.hulk.labsapp.entity;

public enum Labs {
    PATTERN_STRATEGY("Pattern Strategy"),
    ANNOTATIONS("Annotations"),
    THIRD_LAB("Third lab"),
    TRANSLATOR("Translator"),
    STREAM_API("Stream API"),
    SUPERVISOR("Supervisor");

    private final String lab;

    Labs(String lab) {
        this.lab = lab;
    }
}
