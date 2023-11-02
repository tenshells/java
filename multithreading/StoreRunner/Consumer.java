package multithreading.StoreRunner;

class Consumer implements Runnable{
    Store store;
    int conno;

    Consumer(Store store, int con){
        this.store=store;
        this.conno=con;
    }

    @Override
    public void run(){
        while(true){
            synchronized(store){
                // System.out.println("From Consumer side there is "+store.curNoItems);
                if(store.curNoItems>0){
                    store.takeItem();
                    System.out.println("Consumer "+conno+" has taken an item. Current="+store.curNoItems);
                }
            }
        }
    }
}