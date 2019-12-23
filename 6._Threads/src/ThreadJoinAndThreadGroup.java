public class ThreadJoinAndThreadGroup {

    public static void main(String[] args) {

        // Instantiates ThreadExtendsThreads objects
        ThreadExtendsThread threadOne = new ThreadExtendsThread();
        ThreadExtendsThread threadTwo = new ThreadExtendsThread();

        // Starting thread
        threadOne.start();

        // threadOne never stops and therefore threadTwo never starts
        try {
            threadTwo.join(); // starts once the running Thread stops.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


/* TODO: Skal dette slettes?

        //instantiating new ThreadGroup
        ThreadGroup threadGroup = new ThreadGroup("Thread Group One: ");

        // Grouping threads
        ThreadExtendsThread t1 = new ThreadExtendsThread(threadGroup, "t1");
        ThreadExtendsThread t2 = new ThreadExtendsThread(threadGroup, "t2");
        t1.start();
        t2.start();

        // TODO: Do ThreadGroup stuff here

 */

    }
}