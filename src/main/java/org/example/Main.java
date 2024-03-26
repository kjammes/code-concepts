package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        callParallelFibFinders();
    }

    private static void callParallelFibFinders() {
        final var parallelFib = new ParallelFib();
        final var nums = new int[] {45, 12, 33};

        try {
            parallelFib.printFibInParallel(nums);
            parallelFib.printFibUsingExecutor(nums);
            parallelFib.printFibInVirtualThread(nums);
            parallelFib.printFibInCompletableFutures(nums);
            parallelFib.printFibInVirtualThreadRaw(nums);
        } catch (Exception e) {
            System.out.println("Exception in finding fib in parallel " + e.getLocalizedMessage());
        }
    }
}