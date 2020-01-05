public class ThreadJoinAndThreadGroup {

    public static void main(String[] args) throws InterruptedException{

        // Instantiates ThreadExtendsThreads objects
        ThreadExtendsThread threadOne = new ThreadExtendsThread();
        ThreadExtendsThread threadTwo = new ThreadExtendsThread();
        threadOne.setName("threadOne");

        // Starting thread
        threadOne.start();
        threadOne.join(); // the next thread will not start before this thread stops

        // threadOne never stops and therefore threadTwo never starts
        threadTwo.start();


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