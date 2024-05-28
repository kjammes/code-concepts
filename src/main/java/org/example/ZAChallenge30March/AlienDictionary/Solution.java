package org.example.ZAChallenge30March.AlienDictionary;

import java.util.*;
class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        Map<Character, List<Character>> graph = buildGraph(dict);
        for (String str: dict) {
            for (char ch: str.toCharArray())
                if (!graph.containsKey(ch))
                    graph.put(ch, new ArrayList<>());
        }

        // {a=[b, d], b=[], c=[a], d=[b]}

        Stack<Character> stk = new Stack<>();
        boolean[] visited = new boolean[K];
        for (char node: graph.keySet()) {
            if (!visited[node - 'a'])
                dfs(graph, stk, visited, node);
        }

        StringBuilder res = new StringBuilder();
        while (!stk.isEmpty()) {
            res.append(stk.pop());
        }

        return res.toString();
    }

    private void dfs(Map<Character, List<Character>> graph, Stack<Character> stk, boolean[] visited, Character cur) {
        visited[cur - 'a'] = true;

        for (Character ng: graph.get(cur)) {
            if (visited[ng - 'a'])
                continue;
            dfs(graph, stk, visited, ng);
        }

        stk.push(cur);
    }

    private Map<Character, List<Character>> buildGraph(String[] dict) {
        int len = dict.length;

        Map<Character, List<Character>> graph = new HashMap<>();
        for (int i = 0; i < len - 1; i++) {
            String word1 = dict[i], word2 = dict[i + 1];
            int idx = 0;

            int minLen = Math.min(word1.length(), word2.length());
            while (idx < minLen) {
                char c1 = word1.charAt(idx), c2 = word2.charAt(idx);
                if (c1 != c2) {
                    List<Character> adjList = graph.getOrDefault(c1, new ArrayList<>());
                    adjList.add(c2);
                    graph.put(c1, adjList);
                    break;
                }
                idx++;
            }
        }

        return graph;
    }
}
