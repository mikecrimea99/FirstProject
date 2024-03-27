package Package.MulThread;

public class MulriVol extends Thread{
    volatile boolean b = true;

    public void run(){
        long counter = 0;
        while (b){
            counter++;
        }
        System.out.println("Finish. Conter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        MulriVol mulriVol = new MulriVol();
        mulriVol.start();
        Thread.sleep(3000);
        System.out.println("3sec end");
        mulriVol.b = false;
        mulriVol.join();

        System.out.println("End");
    }
}
