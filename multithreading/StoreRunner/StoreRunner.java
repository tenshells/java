package multithreading.StoreRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class StoreRunner{
    public static void main(String[] args) {
        Store s = new Store(5);

        ExecutorService es = Executors.newCachedThreadPool();
        
        for(int i=0;i<3;i++){
            Producer p = new Producer(s, i+1);
            es.execute(p);
        }

        for(int i=0;i<100;i++){
            Consumer c = new Consumer(s, i+1);
            es.execute(c);
        }

        // for(int i=0;i<10000;i++){

        // }
        es.shutdown();
    }
}