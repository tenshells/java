import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

import helperClasses.supplier;

public class ParseSupp implements Runnable{
    String filename;
    Set<Integer> nationKeys;
    Map<Integer, Set<Integer>> suppKeys;
    Semaphore flow;

    ParseSupp(String filename, Set<Integer> nationKeys,
    Map<Integer, Set<Integer>> suppKeys,Semaphore s){
        this.filename=filename;
        this.nationKeys=nationKeys;
        this.suppKeys=suppKeys;
        this.flow=s;
    }

    @Override
    public void run() {
        Parsers.parseSupplierData(filename, nationKeys, suppKeys);
        flow.release();
    }
}
