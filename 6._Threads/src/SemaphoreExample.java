import java.util.concurrent.Semaphore;

public class SemaphoreExample extends Thread {

    Semaphore sem;
    String threadName;

    public SemaphoreExample(Semaphore sem, String threadName) {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        // run Thread "One"
        if (this.getName().equals("One")) {
            System.out.println("Starting " + threadName);
            try {
                // First, get a permit.
                System.out.println(threadName + " is waiting for a permit.");

                // acquiring the lock
                sem.acquire();

                System.out.println(threadName + " gets a permit.");

                // Now, accessing the shared resource.
                // other waiting threads will wait, until this thread release the lock
                for (int i = 0; i < 5; i++) {
                    SharedCount.count++;
                    System.out.println(threadName + ": " + SharedCount.count);

                    // Now, allowing a context switch if possible for thread Two to execute
                    Thread.sleep(100);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }

            // Release the permit.
            System.out.println(threadName + " releases the permit.");
            sem.release();
        }

        // run thread "Two"
        if (this.getName().equals("Two")) {
            System.out.println("Starting " + threadName);
            try {
                // First, get a permit.
                System.out.println(threadName + " is waiting for a permit.");

                // acquiring the lock
                sem.acquire();

                System.out.println(threadName + " gets a permit.");

                // Now, accessing the shared resource.
                // other waiting threads will wait, until this
                // thread release the lock
                for (int i = 0; i < 5; i++) {
                    SharedCount.count--;
                    System.out.println(threadName + ": " + SharedCount.count);

                    // Now, allowing a context switch if possible for thread One to execute
                    Thread.sleep(100);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            // Release the permit.
            System.out.println(threadName + " releases the permit.");
            sem.release();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        // Instantiating a Semaphore and setting the number of permits to 1
        Semaphore sem = new Semaphore(1); // If permits is 2, 2 threads would be able access the ressource.

        // Instantiating two SemaphoreExample objects
        SemaphoreExample semaphoreExample1 = new SemaphoreExample(sem, "One");
        SemaphoreExample semaphoreExample2 = new SemaphoreExample(sem, "Two");

        // Starting threads
        semaphoreExample1.start();
        semaphoreExample2.start();

    }
}