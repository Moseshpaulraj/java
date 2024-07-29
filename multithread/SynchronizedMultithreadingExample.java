public class SynchronizedMultithreadingExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(() -> sharedResource.increment(), "Thread-1");
        Thread thread2 = new Thread(() -> sharedResource.increment(), "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + sharedResource.counter);
    }
}
class SharedResource {
    public int counter = 0;

    public synchronized void increment() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + (++counter));
		System.out.println(i);
            try {
                Thread.sleep(100); // Simulating some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


