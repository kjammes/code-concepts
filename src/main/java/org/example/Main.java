package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var parallelFib = new ParallelFib();
        parallelFib.printFibInParallel(new int[] {45, 12, 33});
        parallelFib.printFibUsingExecutor(new int[] {45, 12, 33});
        parallelFib.printFibInVirtualThread(new int[] {45, 12, 33});
        parallelFib.printFibInCompletableFutures(new int[] {45, 12, 33});
    }
}