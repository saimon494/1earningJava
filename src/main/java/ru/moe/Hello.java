package ru.moe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'typeCounter' function below.
     *
     * The function accepts STRING sentence as parameter.
     */

    public static void typeCounter(String sentence) {
        int s = 0;
        int i = 0;
        int d = 0;
        List<String> tokens = Arrays.asList(sentence.split("\\s+"));

        for (String token : tokens) {
            if (token.matches(".*[A-Za-z].*")) {
                s++;
            }
            if (token.matches("[0-9]+")) {
                d++;
            }
            if (token.matches("\\.")) {
                d++;
            }
        }
        System.out.printf("string %d\n", s);
        System.out.printf("integer %d\n", i);
        System.out.printf("double %d\n", d);
    }

}

public class Hello {

    private static String getIdFile(String data) {
        int start = data.lastIndexOf("_");
        start = (start == -1 || start + 1 > data.length()) ? 1 : start + 1;
        int end = data.length();
//        if (data.contains(".pdf")) {
//            end -= 4;
//        }
        return data.substring(start, end-4);
    }

    public static void main(String[] args) throws IOException {

//        String str = "2022-11-24 15:23:26.630";
//        String regex = "\\.[^.]*$";
//        Pattern pattern = Pattern.compile(regex);
////        Matcher matcher = pattern.matcher(testStr);
//        String s1 =  str.replaceAll("\\..*", "");
//        String s2 =  str.replaceAll("\\.[^.]*$", "");
//        System.out.println(s1);
//        System.out.println(s2);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String dateCreate = "2022-11-24 17:46:33.63";
//        LocalDateTime maxDate = LocalDateTime.parse(dateCreate.replaceAll("\\..*", ""), formatter);
//        System.out.println(maxDate);
        String file = "1_2012468";
        String sign = "1_2012468_";

        System.out.println(sign.toLowerCase().contains(file.toLowerCase()));
        System.out.println(sign.equalsIgnoreCase(file)
                || sign.toLowerCase().contains(file));


//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        String sentence = bufferedReader.readLine();
//
//        Result.typeCounter(sentence);
//
//        bufferedReader.close();
    }
}
