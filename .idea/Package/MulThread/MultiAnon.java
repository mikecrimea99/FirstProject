package Package.MulThread;

public class MultiAnon {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run");
            }
        }).start();

        new Thread(()-> System.out.println("Run2")).start();
    }
}
