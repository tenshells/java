package multithreading;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<ArrayList<Integer>>{
    ArrayList<Integer> A;

    Sorter(ArrayList<Integer> x){
        this.A = x;
    }

    public ArrayList<Integer> call() throws Exception{
        int s = A.size();

        System.out.println("Handling "+A+" in "+Thread.currentThread().getName());

        if(s<=1){
            // System.out.println("Handled "+A+" in "+Thread.currentThread().getName());
            return A;
        }
        
        int mid = s/2;
        
        ArrayList<Integer> left = new ArrayList<Integer>(A.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<Integer>(A.subList(mid, s));

        Sorter leftSorter = new Sorter(left);
        Sorter righSorter = new Sorter(right);

        ExecutorService esL = Executors.newCachedThreadPool();
        ExecutorService esR = Executors.newCachedThreadPool();

        Future<ArrayList<Integer>> PreLSort = esL.submit(leftSorter);
        Future<ArrayList<Integer>> PreRSort = esR.submit(righSorter);
        ArrayList<Integer> ans = new ArrayList<>();
        
        ArrayList<Integer> sortedL = PreLSort.get();
        ArrayList<Integer> sortedR = PreRSort.get();

        esL.shutdown();
        esR.shutdown();

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
        return ans;
    }
}