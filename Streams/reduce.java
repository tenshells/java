package Streams;

import java.util.List;

import p.p;

public class reduce {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);
        
        p.printl("sum is "+list.stream().reduce(0,(cur,sum)->{
            return sum+cur;
        }));

        p.printl("mul is "+list.stream().reduce(1,(cur,mul)->mul*cur));


    }
}
