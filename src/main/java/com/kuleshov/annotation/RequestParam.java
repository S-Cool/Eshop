package com.kuleshov.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(value = RetentionPolicy.RUNTIME)

public @interface RequestParam {
    String name();
}