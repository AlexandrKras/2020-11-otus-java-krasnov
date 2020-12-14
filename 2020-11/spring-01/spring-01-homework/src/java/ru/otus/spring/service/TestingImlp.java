package ru.otus.spring.service;

import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domain.Question;

public class TestingImlp implements Testing {
    private final IOService service;
    private final QuestionService questionService;
    private final QuestionDao dao;

    public TestingImlp(IOService service, QuestionDao dao, QuestionService questionService) {
        this.service = service;
        this.dao = dao;
        this.questionService = questionService;
    }

    @Override
    public void start() {
        for (int i = 1; i < 6; i++) {
            Question question = questionService.findById(i);
            service.print(String.format("Вопрос:\n%s", question.getQuestion()));
            String answer = service.read();
            service.print(question.getAnswer().equalsIgnoreCase(answer.trim())
                    ? "Верно"
                    : String.format("Правильный ответ\n%s", question.getAnswer()));
            service.print("\n");
        }
    }
}