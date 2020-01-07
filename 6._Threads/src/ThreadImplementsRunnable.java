
// Implements Runnable
public class ThreadImplementsRunnable implements Runnable {

    // Implementing the run() method
    public void run() {
        while (true) {
            // print the thread name and time
            System.out.println(Thread.currentThread().getName() + " | " + java.time.LocalTime.now() + " |");

            // sleeps the thread for 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
