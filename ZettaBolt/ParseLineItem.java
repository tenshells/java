import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class ParseLineItem implements Runnable{
    String filename;
    Map<Integer, Set<Integer>> suppKeys;
    Map<Integer, Set<Integer>> orderKeys;
    List<Double> revenues;
    Semaphore flow;

    ParseLineItem(String filename,
    Map<Integer, Set<Integer>> suppKeys, Map<Integer, Set<Integer>> orderKeys, List<Double> revenues,Semaphore flow){
        this.filename=filename;
        this.suppKeys=suppKeys;
        this.orderKeys=orderKeys;
        this.revenues=revenues;
        this.flow=flow;
    }

    @Override
    public void run() {
        Parsers.parseLineItemData(filename, suppKeys, orderKeys, revenues);
        flow.release();
    }
}
