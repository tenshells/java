package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoSync {

    static class Value {
        int value;
        Value(int v){
            this.value=v;
        }
    }

    static class Adder implements Callable<Void>{
        Value value;
        Adder(Value v){
            this.value=v;
        }

        public Void call() throws Exception{
            for(int i=1;i<=10000;i++){
                value.value = value.value + i;
            }
            return null;
        }
    }

    static class Subtractor implements Callable<Void>{
        Value value;
        Subtractor(Value v){
            this.value=v;
        }

        public Void call() throws Exception{
            for(int i=1;i<=10000;i++){
                value.value=value.value-i;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Value v = new Value(0);

        ExecutorService es = Executors.newCachedThreadPool();

        Adder a = new Adder(v);
        Subtractor s = new Subtractor(v);

        Future<Void> fa = es.submit(a);
        Future<Void> fs = es.submit(s);
        
        try{
            fa.get();
            fs.get();
        }
        catch(Exception e){
            System.out.println(" got an "+ e);
        }
        finally{
            es.shutdown();
        }      
        System.out.println("Value after raw threading = "+v.value);
    }
    
}
