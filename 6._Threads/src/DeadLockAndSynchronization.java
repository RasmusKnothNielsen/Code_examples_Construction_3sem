package src;

public class DeadLockAndSynchronization {

    public static void main(String[] args) {

        // Declaring locks to demonstrate synchronized
        String lockOne = "I'm a lock";
        String lockTwo = "I'm a lock too";

        // Anonymous class
        Thread threadOne = new Thread() {
            public void run() {
                // Synchronized is used to only let one thread access the resource.
                synchronized (lockOne) {
                    System.out.println("Thread 1 is using lock one");

                    try {
                        // sleep() is called to make sure the example works - lockTwo will then be in use
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // lockTwo is already in use and the thread cannot access this lock until lockTwo is released
                    // lockTwo is never released due to the deadlock occuring
                    synchronized (lockTwo) {
                        System.out.println("Thread 1 is using lock two");
                    }
                }
            }
        };

        Thread threadTwo = new Thread() {
            public void run() {
                synchronized (lockTwo) {
                    System.out.println("Thread 2 is using lock two");

                    // lockOne is already in use and the thread cannot access this lock until lockOne is released.
                    // lockOne is never released due to the deadlock occuring
                    synchronized (lockOne) {
                        System.out.println("Thread 2 is using lock one");
                    }
                }
            }
        };

        threadOne.start();
        threadTwo.start();
    }
}
