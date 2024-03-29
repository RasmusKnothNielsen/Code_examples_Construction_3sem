public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {

        // Instantiates ThreadExtendsThreads objects
        ThreadImplementsRunnable runOne = new ThreadImplementsRunnable();
        ThreadImplementsRunnable runTwo = new ThreadImplementsRunnable();

        // Instantiating Threads with the Runnable objects as arguments
        Thread threadOne = new Thread(runOne);
        Thread threadTwo = new Thread(runTwo);
        threadOne.setName("Thread One");
        threadTwo.setName("Thread Two");

        // Starting thread
        threadOne.start();
        //threadOne.join(); // the next thread will not start before this thread stops

        // threadOne never stops and therefore threadTwo never starts
        threadTwo.start();

    }
}