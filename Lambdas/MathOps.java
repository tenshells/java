package Lambdas;

import p.p;

public class MathOps {
    public static void main(String[] args) {
        MathOperation sum = (a,b) -> a;
        p.printl("Sum of 24 and 5 is "+sum.operate(24,5));

        MathOperation mul = (a,b) -> a*b;
        p.printl("Mul of 24 and 5 is "+mul.operate(24, 5));
        
        MathOperation mod = MathOps::modder;
        p.printl("Mod of 24 and 5 is "+mod.operate(24, 5));
    }


    public interface MathOperation {
        int operate(int a, int b);
    }

    static int modder (int a, int b){
        return a%b;
    }
}
