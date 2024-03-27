package Package.MulThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i< 10; i++){
            executorService.execute(new RunImpl());
        }
        executorService.shutdown(); //заданий больше не будет стопэ, больше задаче не принимаем
        executorService.awaitTermination(5, TimeUnit.SECONDS); //аналог join - поток мейн будет ждать пока
                                                                     //ЭС не завершит свою работу или не пройдет указанное время
        System.out.println("Main end");
    }
}

class RunImpl implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
