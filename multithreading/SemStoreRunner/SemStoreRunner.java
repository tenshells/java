package multithreading.SemStoreRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemStoreRunner {
    public static void main(String[] args) {
        
        int maxSlots = 5;

        Semaphore pSem = new Semaphore(maxSlots);
        Semaphore cSem = new Semaphore(0);

        Store s = new Store(0,5);
        ExecutorService es = Executors.newCachedThreadPool();

        for(int i=0;i<3;i++){
            Producer p = new Producer(s, i+1, pSem, cSem);
            es.execute(p);
        }

        for(int i=0;i<100;i++){
            Consumer c = new Consumer(s, i+1, pSem, cSem);
            es.execute(c);
        }

        // es.shutdownNow();
    }
}
