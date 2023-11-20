import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ParseReg implements Runnable{
    String filename;
    String regionName;
    ArrayList<Integer> regionID;
    Semaphore flow;

    ParseReg(String filename, String regionName, ArrayList<Integer> regionID,Semaphore flow){
        this.filename=filename;
        this.regionName=regionName;
        this.regionID=regionID;
        this.flow=flow;
    }

    @Override
    public void run() {
        Parsers.parseRegionData(filename, regionName, regionID);
        flow.release();
   }
}
