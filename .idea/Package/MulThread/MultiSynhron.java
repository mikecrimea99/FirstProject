package Package.MulThread;

public class MultiSynhron {
    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        Thread thread3 = new Thread(myThread);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter1 {
    static int count = 0;
}

class MyThread2 implements Runnable {

    private void doWork1(){
        System.out.println("doWork1");
    }

    public void doWork() {
        doWork1();
        synchronized (this) {
            Counter1.count++;
            System.out.println(Counter1.count);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork();
        }

    }
}