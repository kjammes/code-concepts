package org.example.EY.V1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NearestZero {
    public static void nearestZero(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] res = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                res[r][c] = dfs(matrix, r, c);
            }
        }
        for (int[] row: res) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("============================");
        bfs(matrix, res);
    }

    private static int dfs(int[][] matrix, int r, int c) {
        int rows = matrix.length, cols = matrix[0].length;

        int val = matrix[r][c];
        if (val == 0)
            return 0;

        int[][] dirs = new int[][] {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        int res = Integer.MAX_VALUE;
        matrix[r][c] = -1;
        for (int[] dir: dirs) {
            int x = r + dir[0], y = c + dir[1];
            if (outOfBounds(rows, cols, x, y) || matrix[x][y] == -1)
                continue;
            res = Math.min(res, 1 + dfs(matrix, x, y));
        }
        matrix[r][c] = val;

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private static void bfs(int[][] matrix, int[][] res) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 1)
                    continue;
                visited[r][c] = true;
                q.offer(new int[] {r, c});
            }
        }

        int[][] dirs = new int[][] {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        while (!q.isEmpty()) {
            int r = q.peek()[0], c = q.poll()[1];
            for (int[] dir: dirs) {
                int x = r + dir[0], y = c + dir[1];
                if (outOfBounds(rows, cols, x, y) || visited[x][y])
                    continue;
                q.offer(new int[] {x, y});
                visited[x][y] = true;
                res[x][y] = 1 + res[r][c];
            }
        }

        for (int[] row: res) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static boolean outOfBounds(int rows, int cols, int row, int col) {
        return row >= rows || col >= cols || row < 0 || col < 0;
    }
}
