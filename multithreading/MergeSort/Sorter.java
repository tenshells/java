package multithreading.MergeSort;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<ArrayList<Integer>>{
    ArrayList<Integer> A;
    ExecutorService es;

    Sorter(ArrayList<Integer> x, ExecutorService easy){
        this.A = x;
        this.es = easy;
    }

    public ArrayList<Integer> call() throws Exception{
        int s = A.size();
        if(s<=1){
            return A;
        }
        
        int mid = s/2;
        
        ArrayList<Integer> left = new ArrayList<Integer>(A.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<Integer>(A.subList(mid, s));

        Sorter leftSorter = new Sorter(left,es);
        Sorter righSorter = new Sorter(right,es);

        // ExecutorService esL = Executors.newCachedThreadPool();
        // ExecutorService esR = Executors.newCachedThreadPool();

        Future<ArrayList<Integer>> PreLSort = es.submit(leftSorter);
        Future<ArrayList<Integer>> PreRSort = es.submit(righSorter);
        ArrayList<Integer> ans = new ArrayList<>();
        
        ArrayList<Integer> sortedL = PreLSort.get();
        ArrayList<Integer> sortedR = PreRSort.get();

        // esL.shutdown();
        // esR.shutdown();

        int ll = 0, rr = 0;
        while(ll<sortedL.size() && rr<sortedR.size()){
            if(sortedL.get(ll)<=sortedR.get(rr)){
                ans.add(sortedL.get(ll));
                ll++;
            }
            else{
                ans.add(sortedR.get(rr));
                rr++;
            }
        }

        while(ll<sortedL.size()){
            ans.add(sortedL.get(ll));
            ll++;
        }

        while(rr<sortedR.size()){
            ans.add(sortedR.get(rr));
            rr++;
        }

        System.out.println("Handled "+ans+" in "+Thread.currentThread().getName());
        es.shutdown();
        return ans;
    }
}