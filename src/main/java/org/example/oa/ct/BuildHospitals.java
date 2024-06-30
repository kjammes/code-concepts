package org.example.oa.ct;

import java.util.ArrayList;
import java.util.List;

public class BuildHospitals {
    /**
     *
     * @param n Number of cities/nodes
     * @param m Number of roads/edges
     * @param cost The array of length N denoting the values of cities
     * @param roads A 2D array representing the roads.
     * @return min cost of building hospital reachable to every city
     */
    public static int minCost(int n, int m, int[] cost, int[][] roads) {
        List<Integer>[] graph = buildGraph(n, roads);
        boolean[] visited = new boolean[n + 1];

        int res = Integer.MAX_VALUE;
        for (int node = 1; node <= n; node++) {
            if (visited[node])
                continue;
            res = Math.min(res, dfs(graph, node, visited, cost));
        }
        return res;
    }

    /**
     * Recursively calculates the min cost required to build a hospital in given graph component
     */
    private static int dfs(List<Integer>[] graph, int node, boolean[] visited, int[] cost) {
        visited[node] = true;
        int minCost = 0;
        for (int adj: graph[node]) {
            minCost += cost[adj - 1];
        }

        for (int adj: graph[node]) {
            if (visited[adj])
                continue;
            minCost = Math.min(minCost, dfs(graph, adj, visited, cost));
        }

        return minCost;
    }

    /**
     * Builds an adjacency list representation of a graph.
     * @param n Number of nodes in the graph
     * @param edges Edge list where each edge is represented as a two-element array [u, v]
     * @return Adjacency list where graph[i] contains the list of nodes connected to node i
     */
    private static List<Integer>[] buildGraph(int n, int[][] edges) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }
}
