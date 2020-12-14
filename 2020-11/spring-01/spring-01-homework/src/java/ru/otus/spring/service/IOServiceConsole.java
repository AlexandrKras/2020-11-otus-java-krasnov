package ru.otus.spring.service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOServiceConsole implements IOService {
    private final PrintStream out;
    private final Scanner in;

    public IOServiceConsole(PrintStream out, InputStream in) {
        this.out = out;
        this.in = new Scanner(in);
    }

    @Override
    public void print(String message) {
        out.println(message);
    }

    @Override
    public String read() {
        out.println("Ответ:");
        return in.nextLine();
    }
}