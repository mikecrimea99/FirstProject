package Package.other;

public class MultiThread implements Runnable {

    public static void main(String[] args) {
//        MultiThread thread = new MultiThread();
//        thread
        Thread thread = new Thread(new MultiThread());
//        Thread thread2 = new Thread(new AnotherThread());



        thread.start();
//        thread2.start();
        System.out.println("vot etot thread is " + thread.getState());


    }

    @Override
    public void run() {
        for (int i = 5; i >0; i--){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        int random = (int) (Math.random()*30);
        System.out.println("Your cockisze is " + random + "cm");
        Thread.yield();
//        System.out.println("privet");

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Thread.currentThread().interrupt();
//        Thread.currentThread().setName("Olezhek");
//        System.out.println("name of this thread is " +Thread.currentThread().getName());
//        System.out.println("perviy potok " + Thread.currentThread().getState());
//        System.out.println(Thread.currentThread().isInterrupted());

    }

}
class AnotherThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10; i++){

            System.out.println("another thread " + i);
        }
//        System.out.println("poka");
//        Thread.currentThread().setName("Serega");
//        System.out.println("name of this thread is " +Thread.currentThread().getName());
//        System.out.println("vtoroi potok " + Thread.currentThread().getState());
//        System.out.println(Thread.currentThread().isInterrupted());

    }
}