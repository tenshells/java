import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

import helperClasses.nation;

public class ParseNation implements Runnable{
    String filename;
    Set<Integer> nationKeys;
    Map<Integer, String> nationNames;
    int regionKey;
    Semaphore flow;

    ParseNation(String fn, Set<Integer> si, Map<Integer,String> mis, int regionKey, Semaphore s){
        this.filename=fn;
        this.nationKeys=si;
        this.nationNames=mis;
        this.regionKey=regionKey;
        this.flow=s;
    }

    @Override
    public void run() {
        Parsers.parseNationData(filename, nationKeys, nationNames, regionKey);
        flow.release();
        flow.release();
    }
}
