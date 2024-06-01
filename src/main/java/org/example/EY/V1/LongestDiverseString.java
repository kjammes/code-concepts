package org.example.EY.V1;

import java.util.PriorityQueue;

public class LongestDiverseString {
    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        var pq = new PriorityQueue<Pair>((p1, p2) -> Integer.compare(p2.count, p1.count));

        if (a > 0) pq.offer(new Pair('a', a));
        if (b > 0) pq.offer(new Pair('b', b));
        if (c > 0) pq.offer(new Pair('c', c));

        while (!pq.isEmpty()) {
            Pair first = pq.poll();

            // Check if we can use this character
            if (isValid(res, first.ch)) {
                res.append(first.ch);
                first.decrementCount();
            } else {
                if (pq.isEmpty()) break;

                Pair second = pq.poll();
                res.append(second.ch);
                second.decrementCount();

                if (second.count > 0) pq.offer(second);

                pq.offer(first);
                continue;
            }

            if (first.count > 0) pq.offer(first);
        }

        return res.toString();
    }

    private static boolean isValid(StringBuilder sb, char ch) {
        int len = sb.length();
        if (len < 2) return true;
        return !(sb.charAt(len - 1) == ch && sb.charAt(len - 2) == ch);
    }

    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        void decrementCount() {
            this.count -= 1;
        }

        @Override
        public String toString() {
            return "ch " + this.ch + " count " + this.count;
        }
    }
}
