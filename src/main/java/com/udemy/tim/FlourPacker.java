package com.udemy.tim;

public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {

        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int sum = bigCount * 5 + smallCount;

        if (bigCount * 5 - goal == 1) {
            sum = (bigCount - 1) * 5 + smallCount;
        }

        if (sum >= goal) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPack(5,3,24));
    }
}
// 4, 18, 19 - true
// 2, 1, 5 - true
// 0, 5, 6 - false
// 5, 3, 24 - false
