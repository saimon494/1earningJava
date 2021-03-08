package ru.job4j.collection;

// Даны две строки. Нужно проверить, что вторая строка получилась методом перестановок символов в первой строке.

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FreezeStr {

//    private static final Map<Integer, String> stringMap = new HashMap<>();

//    private static Map<Integer, String> strToMap(String s) {
//        Map<Integer, String> stringMap = new HashMap<>();
//        String[] elements = s.split("");
//        for (int i = 0; i < elements.length; i++) {
//            stringMap.put(i, elements[i]);
//        }
//        return stringMap;
//    }

    public static boolean eq(String left, String right) {

//        List<String> setLeft = new ArrayList<>(strToMap(left).values());
//        List<String> setRight = new ArrayList<>(strToMap(right).values());
//        Map<String, Long> frequencyMap =
//                setLeft.stream().collect(Collectors.groupingBy(Function.identity(),
//                        Collectors.counting()));
//
//        for (Map.Entry<String, Long> entry : frequencyMap.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//        return setLeft.containsAll(setRight);

//        List<String> listLeft = Arrays.asList(left.split(""));
//        List<String> listRight = Arrays.asList(right.split(""));
//        System.out.println(listLeft);
//        System.out.println(listRight);
//        System.out.println(strToMap(left));
//        int setLength = Math.max(listLeft.size(), listRight.size());
//        for (int i = 0; i < setLength; i++) {
//            if (right.contains(listLeft.get(i))) {
//                String newEl = stringMap.putIfAbsent(i, listRight.get(i));
//                System.out.println(newEl);
//            }
//        }
//        System.out.println(stringMap.toString());
//        boolean rsl = true;
//        Map<Integer, String> leftMap = new HashMap<>(strToMap(left));
//        Map<Integer, String> rightMap = new HashMap<>(strToMap(right));
//        boolean rsl = false;
        List<String> listLeft = Arrays.asList(left.split(""));
        List<String> listRight = Arrays.asList(right.split(""));
        Map<String, Long> frequencyLeftMap =
                listLeft.stream().collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        for (Map.Entry<String, Long> entry : frequencyLeftMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        Map<String, Long> frequencyRightMap =
                listRight.stream().collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        for (Map.Entry<String, Long> entry : frequencyRightMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return frequencyRightMap.equals(frequencyLeftMap);
    }

    public static void main(String[] args) {
        String left = "heloo";
        String right = "hello";
//        System.out.println(strToMap(left));
//        System.out.println(strToMap(right));
        System.out.println(eq(left, right));
    }
}
