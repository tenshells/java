package Streams;

import java.util.List;

import p.p;

public class prints {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);

        list.stream().forEach((val)->System.out.print(val+" "));
        p.printl("");

        list.stream().forEach((val)->{
            if(val%2==0)
                p.print(val+" ");
        });
        p.printl("");

        list.stream().map((val)->val*val).forEach((val)->p.print(val+" "));
        p.printl("");

        list.stream().map((val)->val+" ").forEach(System.out::print);
        p.printl("");

        list.stream().filter((val)->val%2==0).map((val)->val*val).map((val)->val+" ").forEach(p::print);
        p.printl("");

        list.stream().filter((val)->val%2==0).map((val)->(val*val)+" ").forEach(p::print);
    }
}
