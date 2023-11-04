package multithreading;

import java.util.concurrent.*;

public class ThreadPool { 
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newCachedThreadPool();
        ThreadPoolTester t = new ThreadPoolTester();

        // Future<Integer> f = es.submit(t);
        Future<Integer> f = es.submit(t);
        int x  = f.get();   
        
        System.out.println(x);
        es.shutdown();
    }
}
