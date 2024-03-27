package Package.MulThread;

public class Multi extends Thread {
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Multi multi1 = new Multi();
        multi1.getName();
        multi1.getPriority();
        multi1.start();
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
//        MyThread1 myThread1 = new MyThread1();
//        MyThread2 myThread2 = new MyThread2();
//        myThread1.start();
//        myThread2.start();

    }

}


//class MyThread1 extends Thread{
//    public void run(){
//        for (int i =1; i<=1000; i++){
//            System.out.println(i);
//        }
//    }
//}
//class MyThread2 extends Thread{
//    public void run(){
//        for (int i =1; i<=1000; i++){
//            System.out.println(i);
//        }
//    }
//}