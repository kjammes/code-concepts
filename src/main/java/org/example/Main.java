package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var parallelFib = new ParallelFib();
        var nums = new int[] {45, 12, 33};
//        parallelFib.printFibInParallel(nums);
//        parallelFib.printFibUsingExecutor(nums);
        parallelFib.printFibInVirtualThread(nums);
//        parallelFib.printFibInCompletableFutures(nums);
//        parallelFib.printFibInVirtualThreadRaw(nums);
    }
}