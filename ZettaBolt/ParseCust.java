
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class ParseCust implements Runnable{
    
    String filename;
    Set<Integer> nationKeys;
    Map<Integer, Set<Integer>> custKeys;
    Semaphore flow;

    ParseCust(String s,Set<Integer> nk, Map<Integer,Set<Integer>> ck, Semaphore flow){
        this.filename=s;
        this.nationKeys=nk;
        this.custKeys=ck;
        this.flow=flow;
    }

    @Override
    public void run() {
        Parsers.parseCustomerData(filename, nationKeys, custKeys);
        flow.release();
    }
}
