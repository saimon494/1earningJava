package org.stepik.csc.oop;

import java.util.function.DoubleUnaryOperator;

public class CalcIntegral {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double n = 1000000;
        double h = Math.abs(b - a) / n;
        double result = 0;
        for(int i = 0; i < n; i++) {
            result += f.applyAsDouble(a + h * i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
    }
}
