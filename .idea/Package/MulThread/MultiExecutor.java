package Package.MulThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MultiExecutor {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        for(int i =0; i<10 ; i++){
//            scheduledExecutorService.execute(new RunThread());
//        }
        scheduledExecutorService.schedule(new RunThread(),3, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();
        scheduledExecutorService.scheduleAtFixedRate(new RunThread(), 3,1,TimeUnit.SECONDS);
    }
}
class RunThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "work");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "end work");
    }
}