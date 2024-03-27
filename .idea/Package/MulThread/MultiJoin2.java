package Package.MulThread;

public class MultiJoin2 {
    public static void main(String[] args) {
        System.out.println("Main work");
        Thread thread = new Thread(new Worker());
        System.out.println("my thread - " + thread.getState());
        System.out.println("main - " + Thread.currentThread().getState());

        thread.start();
        System.out.println("my thread - " + thread.getState());
        System.out.println("main - " + Thread.currentThread().getState());

        try {
            thread.join(4400);
            System.out.println("my thread - " + thread.getState());
            System.out.println("main - " + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}

class Worker implements Runnable{

    @Override
    public void run() {
        System.out.println("work begins");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("work ends");
    }
}
