package Package.MulThread;

public class MultiInterrupt {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main start");
        InterThread thread = new InterThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();

        thread.join();
        System.out.println("Main end");

    }
}

class InterThread extends Thread {
    double sqrt = 0;

    public void run() {
        for (int i = 1; i <= 1_000_000_000; i++) {
            if(isInterrupted()){
                System.out.println("Potok zu ende");
                return;
            }
            sqrt += Math.sqrt(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Son hotyat prervat");
                return;
            }
        }
        System.out.println(sqrt);
    }

}