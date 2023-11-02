package multithreading.StoreRunner;

class Producer implements Runnable{
    Store store;
    int prono;
     
    Producer(Store store, int pro){
        this.store=store;
        this.prono=pro;
    }

    @Override
    public void run(){
        while(true){
                synchronized(store){            
                    if(store.curNoItems<store.maxItems){
                        store.addItem();
                        System.out.println("Producer "+prono+" has made an item. Current: "+store.curNoItems);
                    }
                }
            }
    }
}
