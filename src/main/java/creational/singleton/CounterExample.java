package creational.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterExample {
    static int THREAD_NUMBER = 100;
    static int INCREMENT_NUMBER = 1000;

    static ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBER);

    static Runnable task = () -> {
        for (int j = 0; j < INCREMENT_NUMBER; j++) {
            SingletonCounter.getInstance().increment();
        }
    };



    public static void main(String[] args) throws InterruptedException {
        System.out.println("> Initializing Threads...");
        for (int i = 0; i < THREAD_NUMBER; i++) {
            executor.submit(task);
        }

        System.out.println("> Shutting down executor...");
        executor.shutdown();

        System.out.println("Final counter is " + SingletonCounter.getInstance().getCounter());
        System.out.println("Should be " + (THREAD_NUMBER * INCREMENT_NUMBER));
    }

    static class SingletonCounter {
        private static final SingletonCounter instance = new SingletonCounter();
        private final AtomicInteger counter;

        private SingletonCounter() {
            counter = new AtomicInteger(0);
            System.out.println("Singleton Created");
        }

        public static SingletonCounter getInstance() {
            return instance;
        }

        public int getCounter() {
            return counter.get();
        }

        public void increment() {
            counter.incrementAndGet();
        }

    }

}
