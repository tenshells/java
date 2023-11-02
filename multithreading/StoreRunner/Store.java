package multithreading.StoreRunner;

class Store {
    int curNoItems;
    int maxItems;

    Store(int maxItems){
        this.maxItems = maxItems;
        this.curNoItems=0;
    }

    void addItem(){
        this.curNoItems = this.curNoItems+1;
    }

    void takeItem(){
        this.curNoItems = this.curNoItems-1;
    }
}