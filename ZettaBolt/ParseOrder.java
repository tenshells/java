import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

import helperClasses.order;

public class ParseOrder implements Runnable{
    String filename;
    List<order> entityList;
    String oStartDate;
    String oEndDate;
    Map<Integer, Set<Integer>> custKeys;
    Map<Integer, Set<Integer>> orderKeys;
    Semaphore flow;

    ParseOrder(String filename, String oStartDate, String oEndDate,
    Map<Integer, Set<Integer>> custKeys, Map<Integer, Set<Integer>> orderKeys,Semaphore flow){
        this.custKeys=custKeys;
        this.filename=filename;
        this.oEndDate=oEndDate;
        this.oStartDate=oStartDate;
        this.orderKeys=orderKeys;
        this.flow=flow;
    }

    @Override
    public void run() {
        Parsers.parseOrderData(filename, oStartDate, oEndDate, custKeys, orderKeys);
        flow.release();
    }
}
