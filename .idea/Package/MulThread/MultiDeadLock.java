package Package.MulThread;

public class MultiDeadLock {
    public static final Object lock1  = new Object();
    public static final Object lock2  = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Th1());
        thread1.setName("potok1");
        Thread thread2 = new Thread(new Th2());
        thread2.setName("potok2");
        thread1.start();
        thread2.start();
    }
}
class Th1 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Хочеца захватить мониторчик лок2");
        synchronized (MultiDeadLock.lock2){
            System.out.println(Thread.currentThread().getName() + ": лок 2 захватился");
            System.out.println(Thread.currentThread().getName() + ": Хочеца захватить мониторчик лок1");
            synchronized (MultiDeadLock.lock1){
                System.out.println(Thread.currentThread().getName() + ": лок 1 захватился");
            }
        }
    }
}

class Th2 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Хочеца захватить мониторчик лок1");
        synchronized (MultiDeadLock.lock1){
            System.out.println(Thread.currentThread().getName() + ": лок 1 захватился");
            System.out.println(Thread.currentThread().getName() + ": Хочеца захватить мониторчик лок2");
            synchronized (MultiDeadLock.lock2){
                System.out.println(Thread.currentThread().getName() + ": лок 2 захватился");
            }
        }
    }
}