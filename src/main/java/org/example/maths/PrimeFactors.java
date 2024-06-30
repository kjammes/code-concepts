package org.example.maths;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static List<Integer> generatePrimeFactors(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0)
                primeFactors.add(i);
            while (n % i == 0) { n = n/ i; }
        }
        if (n != 1)
            primeFactors.add(n);
        return primeFactors;
    }
}
