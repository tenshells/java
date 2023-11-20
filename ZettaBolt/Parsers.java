import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import helperClasses.*;


public class Parsers {
    public static void parseRegionData(String filename, String regionName, ArrayList<Integer> regionID) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            System.out.println("Region File opened successfully.");
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                // if (line == null) {
                //     System.out.println("Breaking from NULL line at " + i);
                //     break;
                // }
                region currentItem = new region();
                String[] tokens = line.split("\\|");
                currentItem.r_regionKey = Integer.parseInt(tokens[0]);
                currentItem.r_name = tokens[1];
                i++;
                if (currentItem.r_name.equals(regionName)) {
                    regionID.add(currentItem.r_regionKey);
                    break;
                }
            }
            System.out.println(" got 1/" + i + " items");
            i = 0;
            // for (region item : entityList) {
            //     System.out.println(item.r_name + " " + item.r_regionKey);
            //     i++;
            //     if (i == 5)
            //         break;
            // }
        } catch (IOException e) {
            System.out.println("Unable to open file, check location");
        }
    }


    public static void parseNationData(String filename, Set<Integer> nationKeys,
            Map<Integer, String> nationNames, int regionKey) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            System.out.println("Nations File opened successfully.");
            String line;
            int i = 0, j = 0;
            while ((line = br.readLine()) != null) {
                // if (line == null) {
                //     System.out.println("Breaking from NULL line at " + i);
                //     break;
                // }
                nation currentItem = new nation();
                String[] tokens = line.split("\\|");
                currentItem.n_nationKey = Integer.parseInt(tokens[0]);
                currentItem.n_name = tokens[1];
                currentItem.n_regionKey = Integer.parseInt(tokens[2]);
                if (currentItem.n_regionKey == regionKey) {
                    nationNames.put(currentItem.n_nationKey, currentItem.n_name);
                    nationKeys.add(currentItem.n_nationKey);
                    j++;
                }
                i++;
            }
            System.out.println(" got " + j + "/" + i + " items");
            i = 0;
            // for (nation item : entityList) {
            //     System.out.println(item.n_nationKey + " " + item.n_name);
            //     i++;
            //     if (i == 5)
            //         break;
            // }
        } catch (IOException e) {
            System.out.println("Unable to open file, check location");
        }
    }

    public static void parseSupplierData(String filename, Set<Integer> nationKeys,
            Map<Integer, Set<Integer>> suppKeys) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            System.out.println("Supplier File opened successfully.");
            String line;
            int i = 0, j = 0;
            while ((line = br.readLine()) != null) {
                // if (line == null) {
                //     System.out.println("Breaking from NULL line at " + i);
                //     break;
                // }
                i++;
                supplier currentItem = new supplier();
                String[] tokens = line.split("\\|");
                currentItem.s_suppKey = Integer.parseInt(tokens[0]);
                currentItem.s_nationKey = Integer.parseInt(tokens[3]);
                if (nationKeys.contains(currentItem.s_nationKey)) {
                    suppKeys.computeIfAbsent(currentItem.s_nationKey, k -> new HashSet<>())
                            .add(currentItem.s_suppKey);
                    j++;
                }
            }
            System.out.println(" got " + j + "/" + i + " items");
            for (Map.Entry<Integer, Set<Integer>> mapItem : suppKeys.entrySet()) {
                System.out.println(mapItem.getKey() + " has " + mapItem.getValue().size() + " SK items");
            }
            i = 0;
        } catch (IOException e) {
            System.out.println("Unable to open file, check location");
        }
    }

    public static void parseCustomerData(String filename, Set<Integer> nationKeys,
            Map<Integer, Set<Integer>> custKeys) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            System.out.println("Customers File opened successfully.");
            String line;
            int i = 0, j = 0,l=0;
            while ((line = br.readLine()) != null) {
                // if (line == null)
                //     break;
                customer currentItem = new customer();
                String[] tokens = line.split("\\|");
                currentItem.c_custKey = Integer.parseInt(tokens[0]);
                currentItem.c_name = tokens[1];
                currentItem.c_nationKey = Integer.parseInt(tokens[3]);
                if (nationKeys.contains(currentItem.c_nationKey)) {

                    if(l<5){
                        System.out.print("Adding a "+currentItem.c_custKey+" to my nation "+currentItem.c_nationKey+'\n');
                        l++;
                    }

                    custKeys.computeIfAbsent(currentItem.c_nationKey, k -> new HashSet<>())
                            .add(currentItem.c_custKey);
                    j++;
                }
                i++;
            }
            System.out.println(" got " + j + "/" + i + " items.");
            i = 0;
            for (Map.Entry<Integer, Set<Integer>> mapItem : custKeys.entrySet()) {
                System.out.println(mapItem.getKey() + " has " + mapItem.getValue().size() + " CK items");
            }
        } catch (IOException e) {
            System.out.println("Unable to open file, check location");
        }
    }

    public static void parseOrderData(String filename, String oStartDate, String oEndDate,
            Map<Integer, Set<Integer>> custKeys, Map<Integer, Set<Integer>> orderKeys) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            System.out.print("Orders File opened successfully,");
            for (Map.Entry<Integer, Set<Integer>> mapItem : custKeys.entrySet()) {
                System.out.println(mapItem.getKey() + " has " + mapItem.getValue().size() + "ck items");
            }
            String line;
            int i = 0, j = 0, k = 0,l=0;
            while ((line = br.readLine()) != null) {
                // if (line == null)
                //     break;
                i++;
                if (i % 750000 == 0)
                    System.out.print(".");
                order currentItem = new order();
                String[] tokens = line.split("\\|");
                currentItem.o_orderKey = Integer.parseInt(tokens[0]);
                currentItem.o_custKey = Integer.parseInt(tokens[1]);
                int check = -1;
                for (Map.Entry<Integer, Set<Integer>> mapItem : custKeys.entrySet()) {
                    Set<Integer> set = mapItem.getValue();
                    if (set.contains(currentItem.o_custKey)) {
                        check = mapItem.getKey();
                        break;
                    }
                }
                if (check == -1) {
                    continue;
                }
                currentItem.o_totalPrice = Float.parseFloat(tokens[3]);
                currentItem.o_orderDate = tokens[4];
                if (currentItem.o_orderDate.compareTo(oStartDate) >= 0
                        && currentItem.o_orderDate.compareTo(oEndDate) < 0) {
                    if(l<10){
                        System.out.println("Adding this order with date "+currentItem.o_orderDate+" to nation "+check);
                        l++;
                    }
                        
                    orderKeys.computeIfAbsent(check, kz -> new HashSet<>()).add(currentItem.o_orderKey);
                    j++;
                }
            }
            System.out.println(" got " + j + "/" + i + " items after Childrens day");
            for (Map.Entry<Integer, Set<Integer>> mapItem : orderKeys.entrySet()) {
                System.out.println(mapItem.getKey() + " has " + mapItem.getValue().size() + " OK items");
            }
        } catch (IOException e) {
            System.out.println("Unable to open file, check location");
        }
    }

    public static void parseLineItemData(String filename,
            Map<Integer, Set<Integer>> suppKeys, Map<Integer, Set<Integer>> orderKeys, List<Double> revenues) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            System.out.println("Line Items File opened successfully.");
            for (Map.Entry<Integer, Set<Integer>> mapItem : orderKeys.entrySet()) {
                System.out.println(mapItem.getKey() + " has " + mapItem.getValue().size() + " ok items");
            }
            for (Map.Entry<Integer, Set<Integer>> mapItem : suppKeys.entrySet()) {
                System.out.println(mapItem.getKey() + " has " + mapItem.getValue().size() + " sk items");
            }
            String line;
            int i = 0, j = 0, k = 0, l = 0;
            while ((line = br.readLine()) != null) {
                // if (line == null) {
                //     System.out.println("Breaking from NULL line at " + i);
                //     break;
                // }
                i++;
                if (i % 750000 == 0)
                    System.out.print(".");
                lineItem currentItem = new lineItem();
                String[] tokens = line.split("\\|");
                currentItem.l_orderKey = Integer.parseInt(tokens[0]);
                int check = -1;
                for (Map.Entry<Integer, Set<Integer>> mapItem : orderKeys.entrySet()) {
                    Set<Integer> set = mapItem.getValue();
                    if (set.contains(currentItem.l_orderKey)) {
                        check = mapItem.getKey();
                        break;
                    }
                }
                if (check == -1) {
                    continue;
                }
                currentItem.l_partKey = Integer.parseInt(tokens[1]);
                currentItem.l_suppKey = Integer.parseInt(tokens[2]);
                int check2 = -1;
                for (Map.Entry<Integer, Set<Integer>> mapItem : suppKeys.entrySet()) {
                    Set<Integer> set = mapItem.getValue();
                    if (set.contains(currentItem.l_suppKey)) {
                        check2 = mapItem.getKey();
                        break;
                    }
                }
                if (check2 == -1) {
                    continue;
                }
                currentItem.l_lineNumber = Integer.parseInt(tokens[3]);
                currentItem.l_quantity = Integer.parseInt(tokens[4]);
                currentItem.l_exPrice = Double.parseDouble(tokens[5]);
                currentItem.l_discount = Double.parseDouble(tokens[6]);
                if (check == check2) {
                    double lirevenue = (currentItem.l_exPrice * (1.00 - currentItem.l_discount));
                    revenues.set(check2, revenues.get(check2) + lirevenue);
                    k++;
                }
                j++;
            }
            System.out.println(" got " + j + "/" + i + " items and " + k + " matching ones");
        } catch (IOException e) {
            System.out.println("Unable to open file, check location");
        }
    }

    public static void main(String[] args) {
        List<region> regions = new ArrayList<>();
        ArrayList<Integer> regionID = new ArrayList<>();
        parseRegionData("filename", "regionName", regionID);

        List<nation> nations = new ArrayList<>();
        Set<Integer> nationKeys = new HashSet<>();
        Map<Integer, String> nationNames = new HashMap<>();
        parseNationData("filename", nationKeys, nationNames, regionID.get(0));

        Map<Integer, Set<Integer>> suppKeys = new HashMap<>();
        parseSupplierData("filename",  nationKeys, suppKeys);

        List<customer> customers = new ArrayList<>();
        Map<Integer, Set<Integer>> custKeys = new HashMap<>();
        parseCustomerData("filename",  nationKeys, custKeys);

        Map<Integer, Set<Integer>> orderKeys = new HashMap<>();
        parseOrderData("filename", "oStartDate", "oEndDate", custKeys, orderKeys);

        List<Double> revenues = new ArrayList<>();
        for (int i = 0; i < nationKeys.size(); i++) {
            revenues.add(0.0);
        }
        parseLineItemData("filename", suppKeys, orderKeys, revenues);
    }
}