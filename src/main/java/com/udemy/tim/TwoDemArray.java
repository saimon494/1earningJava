package com.udemy.tim;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int count = 0; ///// счетчик проверки всех чисел массива
        int elem = 0; ////// все числа массива
        int n = scanner.nextInt();
        if (n == 10) {
            System.out.println();

        }
        int[][] array = new int[n][n];
        int[][] temp = new int[n][n]; ////// массив для транспонирования
/////////////// считываем массив /////////////////////////////////
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scanner.nextInt();
            }

        }
//////////////////////////////////////////////////////////////////////
        /////// транспонируем массив ///////////////////
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = array[j][i];
            }
        }
/////////////////////////////////////////////////////////
///////////// вывод массива array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(array[i][j] + "\t");

            }
            System.out.println();
        }
        System.out.println();
//////////////////
////////////// вывод массива temp
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(temp[i][j] + "\t");

            }

            System.out.println();
        }
///////////////////////
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                elem ++; ///// считаем количество элементов в многомерном массиве
                if (array[i][j] == temp[i][j]) {/////проверка на идентичность элементов массива
                    count ++;///// считаем только равные элементы двух массивов
                }

                // System.out.println();

            }
        }

        if (count == elem) {///// сравниваем количество элементов массива с условием выше
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        System.out.println(count);
        System.out.println(elem);
    }
}
// 3
// 0 1 2
// 1 2 3
// 2 3 4