package Lambdas;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import p.p;

public class OneLiners {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> c = () -> {
            p.printl("I am a disco dancer running on "+Thread.currentThread().getName()+Thread.currentThread().getId());
            return "im done";
        };
        
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> fs = es.submit(c);

        p.print(fs.get()+" on "+Thread.currentThread().getName()+Thread.currentThread().getId());
    }
}
