package com.udemy.tim;

public class BarkingDog {
    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
        if (isBarking && hourOfDay >= 0 && hourOfDay < 8 || hourOfDay > 22 && hourOfDay <= 23) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean barking = shouldWakeUp(true, 23);
        System.out.println(barking);
    }
}
