package org.example.oa.ct;

public class Main {
    public static void main(String[] args) {
        /* number of cities */
        int n = 7;
        int m = 7;
        int[] A = new int[] {1, 3, 5, 3, 6, 2, 2};
        int[][] roads = new int[][] {
                {1, 2}, {2, 3}, {1, 7}, {2, 4}, {3, 4}, {4, 5}, {4, 6}
        };


        System.out.println("min cost to build hospitals : " + BuildHospitals.minCost(n, m, A, roads));
        System.out.println("min cost to build hospitals 2 : " + BuildHospitals.minCost(2, 1, new int[] {3, 5}, new int[][] { {1, 2} }));

    }
}
