package multithreading.SemStoreRunner;

public class Store {
    Int curSlots;
    Int maxSlots;

    Store(int c,int m){
        this.curSlots = new Int(c);
        this.maxSlots = new Int(m);
    }

    synchronized void addItem(){
        if(curSlots.get()==5)
            return;
        curSlots.addOne();
    }

    synchronized void takeItem(){
        if(curSlots.get()==0)
            return;
        curSlots.takeOne();
    }
}

class Int {
    int val;

    Int(int x){
        this.val=x;
    }

    synchronized int get(){
        return val;
    }

    synchronized void addOne(){
        this.val=this.val+1;
    }

    synchronized void takeOne(){
        this.val=this.val-1;
    }
}
