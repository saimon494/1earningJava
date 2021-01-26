package com.udemy.tim;

import java.util.Scanner;

public class isSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // first number 9
        boolean isSeq = true;
        int count = 1;

        while (n != 0) {

            int m = scanner.nextInt(); // second number 8
            count++;
            if (m == 0) {
                break;
            }

            while (n < m) {

                n = m;                  // 45
                m = scanner.nextInt();  // 3

                if ((n > m) && (m != 0)) { //
                    isSeq = false;
                    count++;
                    continue;
                }

                if (m == 0) {
                    break;
                }
            }

            while ((m != 0) && (count > 2)) {
                m = scanner.nextInt();
            }

            if (m == 0) {
                break;
            }

            while (n > m) {             // 9 > 8

                n = m;                  // 8
                m = scanner.nextInt();  // 45

                if ((n < m) && (m != 0)) {
                    isSeq = false;
                    continue;
                }

                if (m == 0) {
                    break;
                }
            }

            while (m != 0) {
                m = scanner.nextInt();
            }

            if (m == 0) {
                break;
            }
        }
        System.out.println(isSeq);
    }
}
