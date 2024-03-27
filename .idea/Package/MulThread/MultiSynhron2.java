package Package.MulThread;

public class MultiSynhron2 {

    static final Object lock = new Object();

     void mobileCall() {
         synchronized(lock){
             System.out.println("Mob call start");
             try {
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println("Mob call end");
         }

    }

     void skypeCall() {
         synchronized (lock){
             System.out.println("skype call start");
             try {
                 Thread.sleep(5000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println("skype call end");
         }

    }

     void wpCall() {
        synchronized(lock){
            System.out.println("wp call start");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wp call end");
        }

    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunImlMobile());
        Thread thread2 = new Thread(new RunImlSkype());
        Thread thread3 = new Thread(new RunImlWp());

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class RunImlMobile implements Runnable {

    @Override
    public void run() {
        new MultiSynhron2().mobileCall();
    }
}

class RunImlSkype implements Runnable {

    @Override
    public void run() {
        new MultiSynhron2().skypeCall();
    }
}

class RunImlWp implements Runnable {

    @Override
    public void run() {
        new MultiSynhron2().wpCall();
    }
}
