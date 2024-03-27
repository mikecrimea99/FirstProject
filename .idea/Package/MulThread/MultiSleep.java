package Package.MulThread;

public class MultiSleep extends Thread{
    public void run(){
        for(int i = 1; i<=10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunn());
        MultiSleep multiSleep = new MultiSleep();
        thread1.start();
        multiSleep.start();

        System.out.println("End");
    }
//    public static void main(String[] args) throws InterruptedException {
//        for(int i = 5; i>0; i--){
//            System.out.println(i);
//            Thread.sleep(1000);
//        }
//        System.out.println("Go");
//    }

}

class MyRunn implements Runnable{

    @Override
    public void run() {
        for(int i = 1; i<=10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

