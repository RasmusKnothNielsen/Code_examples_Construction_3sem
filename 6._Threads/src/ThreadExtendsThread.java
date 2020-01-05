public class ThreadExtendsThread extends Thread {

    // Empty constructor
    public ThreadExtendsThread() {

    }
    // TODO: Is this necessary? Delete everything with ThreadGroups?
    // Constructor containing a ThreadGroup and a String for the threads name as parameter
    public ThreadExtendsThread(ThreadGroup threadGroup, String threadName) {
        super(threadGroup, threadName);
    }

    // create run() method so that the extended Thread class knows it's a Thread
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
