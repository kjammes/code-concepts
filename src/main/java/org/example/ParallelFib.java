package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

class ParallelFib {
    private int fib(int n, Map<Integer, Integer> cache) {
//        if (cache.containsKey(n))
//            return cache.get(n);

        if (n <= 1) return n;

        int res = fib(n - 1, cache) + fib(n - 2, cache);
        cache.put(n, res);
        return res;
    }

    void printFibInParallel(int[] nums) {
        for (int num : nums) {
            new Thread(() -> printFibAndThreadDetails(num)).start();
        }
    }

    void printFibUsingExecutor(int[] nums) {
        try (final var executor = Executors.newCachedThreadPool()) {
            for (int num : nums) {
                executor.submit(() -> printFibAndThreadDetails(num));
            }
            executor.shutdown();
        } catch (Exception e) {
            System.out.printf("Exception in executor %s \n", e.getLocalizedMessage());
        }
    }

    void printFibInVirtualThread(int[] nums) {
        for (int num : nums) {
            try {
                Thread.ofVirtual().start(() -> {
                    System.out.println("starting virtual threads");
                    printFibAndThreadDetails(num);
                }).join();
            } catch (InterruptedException e) {
                System.out.printf("Interrupted Exception in virtual threads execution %s \n", e.getLocalizedMessage());
            }
        }
    }

    void printFibInCompletableFutures(int[] nums) throws InterruptedException {
        for (int num: nums) {
            CompletableFuture.supplyAsync(() -> fib(num, new HashMap<>()))
                    .thenApply(res -> res * 2.0)
                    .thenApply(res -> String.format("%.2f", res))
                    .thenAccept(res -> System.out.printf("The fibonacci number is %s and has thread id %s \n", res, Thread.currentThread().threadId()))
                    .exceptionally(e -> {
                        System.out.println(e.getLocalizedMessage());
                        return null;
                    });
        }
        Thread.sleep(20_000);
    }

    private void printFibAndThreadDetails(int num) {
        System.out.printf("Fibonacci for num %s is %s and thread id %s and thread is %s \n", num, fib(num, new HashMap<>()), Thread.currentThread().threadId(), Thread.currentThread());
    }
}