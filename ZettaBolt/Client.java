import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import helperClasses.*;


public class Client {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // pl("Choose Region : ");
        // p("1) AFRICA 2)AMERICA 3)ASIA 4)EUROPE 5)MIDDLE EAST | Your Choice: ");
        // int rKey = s.nextInt();
        // while(!(rKey>0 && rKey<6)){
        //     pl("Enter correct region key : ");
        //     rKey = s.nextInt();
        // }
        // p("Enter start order date (should be in format of yyyy-mm-dd) : ");
        // String orderStart = s.next();
        // p("Enter end order date   (should be in format of yyyy-mm-dd) : ");
        // String orderEnd = s.next();
        // p("Enter no. of threads : ");
        // int threadCount = s.nextInt();
        
        String fileName = "C:\\codes\\cpp\\ZBolt\\tpch-dbgen\\data";
        
        ArrayList<Integer> regionID = new ArrayList<>();
        List<region> regions = new ArrayList<>();
        // Parsers pp = new Parsers();
        Parsers.parseRegionData(fileName+"\\region.tbl","ASIA",regionID);
        p("Correct region ID is "+regionID);

        List<nation> nations = new ArrayList<>();
        Set<Integer> nationKeys = new HashSet<>();
        Map<Integer, String> nationNames = new HashMap<>();
        Parsers.parseNationData(fileName+"\\nation.tbl", nationKeys, nationNames, regionID.get(0));

        
        List<supplier> suppliers = new ArrayList<>();
        Map<Integer, Set<Integer>> suppKeys = new HashMap<>();
        Parsers.parseSupplierData(fileName+"\\supplier.tbl", nationKeys, suppKeys);

        Map<Integer, Set<Integer>> custKeys = new HashMap<>();
        Parsers.parseCustomerData(fileName+"\\customer.tbl", nationKeys, custKeys);

        
        Map<Integer, Set<Integer>> orderKeys = new HashMap<>();
        Parsers.parseOrderData(fileName+"\\orders.tbl", "1994-01-01", "1995-01-01", custKeys, orderKeys);

        
        List<Double> revenues = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            revenues.add(0.0);
        }
        Parsers.parseLineItemData(fileName+"\\lineitem.tbl", suppKeys, orderKeys, revenues);

        List<Pair> nationRevenues = new ArrayList<>();
        for (int i: nationKeys){
            Pair p = new Pair(nationNames.get(i),revenues.get(i));
            nationRevenues.add(p);
        }

        Collections.sort(nationRevenues);
        
        for(Pair p : nationRevenues){
            String formatted = String.format("%-10s: %.4f", p.s, p.d);
            pl(formatted);
        }
        
        s.close();
    }

    private static void pl(String string) {
        System.out.println(string);
    }

    private static void p(String string) {
        System.out.print(string);
    }

}


class Pair implements Comparable<Pair>{

    Pair(String s, double d){
        this.s=s;
        this.d=d;
    }

    String s;
    double d;

    @Override
    public int compareTo(Pair o) {
        return this.d<o.d?1:-1;
    }
}