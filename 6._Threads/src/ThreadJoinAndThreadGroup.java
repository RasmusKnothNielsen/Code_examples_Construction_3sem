public class ThreadJoinAndThreadGroup {

    public static void main(String[] args) {

        // Instantiates ThreadExtendsThreads objects
        ThreadExtendsThread threadOne = new ThreadExtendsThread();
        ThreadExtendsThread threadTwo = new ThreadExtendsThread();

        // Starting thread
        threadOne.start();

        // threadOne never stops and therefore threadTwo never starts
        try { // TODO: Maybe demonstrate that the join starts after the previous thread
            threadTwo.join(); // starts once the running Thread stops.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // |||||||| Thread Groups ||||||||

        //instantiating new ThreadGroup
        ThreadGroup threadGroup = new ThreadGroup("Thread Group One: ");

        // Grouping threads
        ThreadExtendsThread t1 = new ThreadExtendsThread(threadGroup, "t1");
        ThreadExtendsThread t2 = new ThreadExtendsThread(threadGroup, "t2");
        t1.start();
        t2.start();

        // stop all threads in threadGroup and destroy the threadGroup
        System.out.println("Is threadGroup destroyed? " + threadGroup.isDestroyed());
        threadGroup.destroy();
        System.out.println("Destroying threadGroup");
        System.out.println("Is threadGroup destroyed? " + threadGroup.isDestroyed());

    }
}