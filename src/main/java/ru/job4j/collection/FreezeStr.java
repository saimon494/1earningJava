package ru.job4j.collection;

// Даны две строки. Нужно проверить, что вторая строка получилась методом перестановок символов в первой строке.

import java.util.*;

public class FreezeStr {

    private static Map<Integer, String> listToMap(List<String> list) {
        Map<Integer, String> stringMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            stringMap.put(i, list.get(i));
        }
        return stringMap;
    }

    public static Map<String, Integer> eqCountValue(String s) {
        String[] list = s.split("");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String el : list) {
            Integer count = frequencyMap.get(el);
            if (count == null) {
                count = 0;
            }
            frequencyMap.put(el, count + 1);
        }
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        return frequencyMap;
    }

    public static boolean eq(String left, String right) {
        List<String> leftList = Arrays.asList(left.split(""));
        List<String> rightList = Arrays.asList(right.split(""));
        Collections.sort(leftList);
        Collections.sort(rightList);
        Map<Integer, String> leftMap = new HashMap<>(listToMap(leftList));
        Map<Integer, String> rightMap = new HashMap<>(listToMap(rightList));
        return leftMap.equals(rightMap);
    }

    public static boolean eq2(String left, String right) {
        Map<String, Integer> leftMap = eqCountValue(left);
        Map<String, Integer> rightMap = eqCountValue(right);
        return leftMap.equals(rightMap);
    }

    public static void main(String[] args) {
        String left = "Hello";
        String right = "Hlloe";
        System.out.println(eq(left, right));
        System.out.println(eq2(left, right));
    }
}