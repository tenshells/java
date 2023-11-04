package multithreading.MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ArrayList<Integer> toSort = new ArrayList<Integer>(List.of(5,3,7,1,8,5,8,9));
        ExecutorService easy = Executors.newCachedThreadPool();

        Sorter s = new Sorter(toSort,easy);

        // ExecutorService es = Executors.newCachedThreadPool();
        Future<ArrayList<Integer>> f = easy.submit(s);
        
        ArrayList<Integer> ans = new ArrayList<>();

        try {
            ans = f.get();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Got an exception here : ) \n\t"+e);
        } finally{
            easy.shutdown();
        }
        
        long end = System.currentTimeMillis();


        System.out.println("Sorted Array is : ");
        System.out.println("Time taken = "+(end-start)+" ms");
        for(int i: ans){
            System.out.print(i+" ");
        }

    }
}
