package multithreading.ThreadPool;
import java.util.concurrent.Callable;

public class ThreadPoolTester implements Callable<Integer>{
    @Override
    public Integer call () throws Exception{
        return 1;
    }
}
