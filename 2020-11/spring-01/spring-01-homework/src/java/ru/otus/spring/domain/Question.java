package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Question {
    private final Integer id;
    private final String question;
    private final String answer;
}