package multithreading.SemStoreRunner;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    int producerNo;
    Store store;
    Semaphore pSem;
    Semaphore cSem;

    Producer(Store store, int producerNo, Semaphore p, Semaphore c){
        this.producerNo=producerNo;
        this.store=store;
        this.pSem = p;
        this.cSem = c;
    }

    public void run(){
        while(true){
            
            try{
                pSem.acquire();
                store.addItem();
                System.out.println("P"+producerNo+" has produced an item, items left: "+store.curSlots.get());
                cSem.release();
            }
            catch (Exception e){
                System.out.println("Got an e ");
            }


                
        }
    }
}
