package Package.MulThread;

public class MultiDataRace {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        Thread thread3 = new Thread(myThread);
        thread1.start();
        thread2.start();
        thread3.start();
    }



}

class Counter {
    static int count = 0;
}

class MyThread implements Runnable{

    public synchronized void increment(){
        Counter.count++;
        System.out.print(Counter.count + " ");
    }

    @Override
    public void run() {
        for(int i = 0; i <3; i++){
            increment();
        }

    }
}