public class ThreadExtendsThread extends Thread {

    public ThreadExtendsThread() {}
    public ThreadExtendsThread(ThreadGroup threadGroup, String threadName) {}

    // create run() method so that the extended Thread class knows it's a Thread
    public void run() {
        while (true) {
            // print the time
            System.out.println("| " + java.time.LocalTime.now() + " |");

            // sleeps the thread for 1 second
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
