package com.udemy.tim;

import java.util.Scanner;

public class No2x2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;// счетчик проверки всех чисел массива

        System.out.println("Input 4 elements in row - W, B, R, G or Y :");
        String[][] array = new String[4][4];
        // ввод массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextLine();
            }
        }
        // вывод массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                System.out.print(array[i][j] + " ");

            }
            System.out.println();
        }
        // проверка на равенство соседних 4-х элементов
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j].equals(array[i][j + 1]) &&
                        array[i + 1][j].equals(array[i + 1][j + 1]) &&
                                array[i][j].equals(array[i + 1][j + 1])) {
                        count++;
                }
            }
        }
        if (count >= 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }
}

// WWWW
// BBBB
// WWWW
// YYYY
// ---> YES
// BBBB // YYGG
// BWWB // YYGG
// BWWB // GGGG
// BBBB // YYYY
// ---> NO