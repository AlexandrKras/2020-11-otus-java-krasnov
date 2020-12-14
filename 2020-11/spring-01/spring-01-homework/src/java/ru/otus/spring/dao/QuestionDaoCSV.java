package ru.otus.spring.dao;

import ru.otus.spring.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionDaoCSV implements QuestionDao {
    private final BufferedReader reader;

    public QuestionDaoCSV(String pathCVS) {
        this.reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(pathCVS)));
    }

    @Override
    public Question findById(int id) {
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(";");
                if (split.length != 3) {
                    new RuntimeException("Строка не соответствует формату");
                }

                Integer numberQuestion = Integer.parseInt(split[0]);
                if (numberQuestion == id) {
                    return new Question(numberQuestion, split[1], split[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
