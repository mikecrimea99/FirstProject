package Package.other;

/*
  1-й тред печатает только нечетные числа от 1 до n
  2-й тред печатает только четные числа от 2 до n+1
  синхронизировать треды (любым способом) чтобы они напечатали числа по порядку:
  1
  2
  3...
  n можно взять небольшое
*/


import java.util.concurrent.Semaphore;

class TwoThreadsOddEven {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphores = new Semaphore(1);
        Thread thread1 = new Thread(new Work1(semaphores));
        Thread thread2 = new Thread(new Work2(semaphores));


//        Thread thread1 = new Thread() {
//            private final int[] numbers = new int[]{1, 3, 5, 7, 9, 11};
//
//            @Override
//            public void run() {
//                for (int i : numbers) {
//                    System.out.println(i);
//                }
//            }
//        };
//
//        Thread thread2 = new Thread() {
//            private final int[] numbers = new int[]{2, 4, 6, 8, 10, 12};
//
//            @Override
//            public void run() {
//                for (int i : numbers) {
//                    System.out.println(i);
//                }
//            }
//        };
        thread1.start();
        thread2.start();
    }
}
class Work1 implements Runnable{
    Semaphore semaphore;

    public Work1(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    private final int[] numbers = new int[]{1, 3, 5, 7, 9, 11};

    @Override
    public void run() {
        for (int i : numbers) {
            System.out.println(i);
        }
    }
}
class Work2 implements Runnable{
    Semaphore semaphore;

    public Work2(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    private final int[] numbers = new int[]{2, 4, 6, 8, 10, 12};

    @Override
    public void run() {
        for (int i : numbers) {

            System.out.println(i);

        }
    }
}
