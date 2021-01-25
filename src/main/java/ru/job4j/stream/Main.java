package ru.job4j.stream;

import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        Dataset.of(Arrays.asList("шла", "саша", "по", "шоссе"))
                .filter(s -> s.length() > 2)
                .map(s -> s + ", length=" + s.length())
                .forEach(System.out::println);
    }
}
