import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import helperClasses.customer;
import helperClasses.lineItem;
import helperClasses.nation;
import helperClasses.region;
import helperClasses.supplier;

public class MulitClient {
    public static void main(String[] args) {
        int nothreads = 1;
        String fileName = "C:\\codes\\cpp\\ZBolt\\tpch-dbgen\\data";
        String orderEnd = "1994-01-01";
        String orderStart = "1995-01-01";
        Parsers pp = new Parsers();
        ExecutorService es = Executors.newFixedThreadPool(nothreads);     
        
        Semaphore flow = new Semaphore(1);

        ArrayList<Integer> regionID = new ArrayList<>();
        String regionName="ASIA";
        try {
            flow.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ParseReg parseReg = new ParseReg(fileName+"//region.tbl",regionName,regionID,flow);
        es.execute(parseReg);
        Set<Integer> nationKeys = new HashSet<>();
        Map<Integer, String> nationNames = new HashMap<>();
        try {
            flow.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ParseNation parseNation = new ParseNation(fileName+"//nation.tbl",nationKeys,nationNames,regionID.get(0),flow);
        es.execute(parseNation);

        Map<Integer, Set<Integer>> custKeys = new HashMap<>();
        try {
            flow.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ParseCust parseCust = new ParseCust(fileName+"//customer.tbl",nationKeys,custKeys,flow);
        es.execute(parseCust);

        Map<Integer, Set<Integer>> suppKeys = new HashMap<>();
        try {
            flow.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ParseSupp parseSupp = new ParseSupp(fileName+"//supplier.tbl",nationKeys,suppKeys,flow);
        es.execute(parseSupp);

        try {
            flow.acquire(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Map<Integer, Set<Integer>> orderKeys = new HashMap<>();
        ParseOrder parseOrder = new ParseOrder(fileName+"//orders.tbl",orderStart,orderEnd,custKeys,orderKeys,flow);
        es.execute(parseOrder);
        
        try {
            flow.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<Double> revenues = new ArrayList<>();
        for (int i = 0; i < 25; i++) {  revenues.add(0.0);  }
        ParseLineItem parseLineItem = new ParseLineItem(fileName+"//lineitem.tbl",suppKeys,orderKeys,revenues,flow);
        es.execute(parseLineItem);

        try {
            flow.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        es.shutdown();

        List<Pair> nationRevenues = new ArrayList<>();
        for (int i: nationKeys){
            Pair p = new Pair(nationNames.get(i),revenues.get(i));
            nationRevenues.add(p);
        }
        
        for(Pair p : nationRevenues){
            String formatted = String.format("%-10s: %.4f", p.s, p.d);
            pl(formatted);
        }
    }

    private static void pl(String formatted) {
        System.out.println(formatted);
    }
}
