package ru.job4j.stream;

import java.util.function.Consumer;

@FunctionalInterface
public interface Generator<T> {
    void generate(Consumer<T> context);
}