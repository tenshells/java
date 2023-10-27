package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> toSort = new ArrayList<Integer>(List.of(5,3,7,1,8,5,8,9));

        Sorter s = new Sorter(toSort);

        ExecutorService es = Executors.newCachedThreadPool();
        Future<ArrayList<Integer>> f = es.submit(s);
        
        ArrayList<Integer> ans = new ArrayList<>();

        try {
            ans = f.get();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Got an exception here : ) \n\t"+e);
        } finally{
            es.shutdown();
        }
        System.out.println("Sorted Array is : ");

        for(int i: ans){
            System.out.print(i+" ");
        }

    }
}
