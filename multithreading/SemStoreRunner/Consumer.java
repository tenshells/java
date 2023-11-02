package multithreading.SemStoreRunner;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    int consumerNo;
    Store store;
    Semaphore pSem;
    Semaphore cSem;

    Consumer(Store store, int consumerNo, Semaphore p, Semaphore c){
        this.consumerNo=consumerNo;
        this.store=store;
        this.pSem = p;
        this.cSem = c;
    }

    public void run(){
        while(true){
            
            try{
                cSem.acquire();            
                store.takeItem();
                System.out.println("C"+consumerNo+" has consumed an item, items left: "+store.curSlots.get());
                pSem.release();
            }
            catch (Exception e){
                System.out.println("Got an e ");
            }
                
        }
    }
}