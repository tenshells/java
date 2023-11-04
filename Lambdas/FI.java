package Lambdas;

public class FI {
    public static void main(String[] args) {
        Runnable r = () ->{
            System.out.println("I am running inside a thread named "+Thread.currentThread().getName()+Thread.currentThread().getId());
        };

        Thread t = new Thread(r);
        
        Thread t2 = new Thread(r);

        t.start();
        t2.run();
    }
}
