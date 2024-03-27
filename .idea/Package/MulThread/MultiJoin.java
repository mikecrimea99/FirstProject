package Package.MulThread;

public class MultiJoin {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for(int i = 1; i <= 10; i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 1; i <= 10; i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main");

    }
}
