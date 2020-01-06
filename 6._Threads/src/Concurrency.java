/*
Concurrency - more than one thread runs at a time.
*/

public class Concurrency extends Thread {


    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Concurrency concurrency1 = new Concurrency();
        Concurrency concurrency2 = new Concurrency();
        Concurrency concurrency3 = new Concurrency();

        // Priority can be set in case ressources are limited.
        //concurrency1.setPriority(MIN_PRIORITY);
        //concurrency2.setPriority(MIN_PRIORITY);
        //concurrency3.setPriority(MAX_PRIORITY);

        // Set name of the threads
        concurrency1.setName("Thread One");
        concurrency2.setName("Thread Two");
        concurrency3.setName("Thread Three");

        // Start the threads
        concurrency1.start();
        concurrency2.start();

        // join() concurrency2 and 1 - concurrency3 waits for the other threads to finish before starting.
        concurrency1.join();
        concurrency2.join();
        //concurrency3.join();

        concurrency3.start();

    }
}
