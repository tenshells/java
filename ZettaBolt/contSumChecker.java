import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class contSumChecker {
    public static void main(String[] args) {
        List<Integer> question = List.of(-10, 8,5);

        HashSet<Long> contSum = new HashSet<>();
        
        contSum.add((long)0);

        long sum=0;
        boolean exists = false;
        for(Integer i: question){
            sum=sum+(long)i;
            if(contSum.contains(sum)){
                System.out.println("Cont Sum of 0 exists ");
                exists = true;
                break;
            }
            else{
                contSum.add(sum);
            }
        }
        if(!exists){
            System.out.println("Cont Sum of 0 does not exist ");
        }

        System.out.print("");
    }
}
