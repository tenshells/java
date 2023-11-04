package Lambdas;

import p.p;

public class MathOps {
    public static void main(String[] args) {
        MathOperation sum = (a,b) -> a+b;
        p.printl("Sum of 4 and 5 is "+sum.operate(4,5));

        MathOperation mul = (a,b) -> a*b;
        p.printl("Mul of 4 and 5 is "+mul.operate(4, 5));
        
    }


    public interface MathOperation {
        int operate(int a, int b);
    }
}
