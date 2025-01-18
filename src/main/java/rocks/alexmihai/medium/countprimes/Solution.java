package rocks.alexmihai.medium.countprimes;

/**
 * Sieve of Eratosthenes.
 * - Mark all numbers as primes.
 * - Iterate over primes starting from the first (2). Can stop the iteration at sqrt(n) because all non-primes above
 *   that were marked by previous iterations (one factor is less than sqrt(n)).
 * - For each prime i, leave itself mark as prime, but mark all numbers starting from i * i with step of size i as
 *   non-prime. Can start at i * i because all numbers of form (i * x) where x < i were marked when the iteration was
 *   previously at x.
 */
public class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;

        var nonPrimes = new boolean[n];
        nonPrimes[0] = true;
        nonPrimes[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (nonPrimes[i]) continue;

            for (int j = i * i; j < n; j += i) {
                nonPrimes[j] = true;
            }
        }

        var res = 0;
        for (int i = 2; i < n; i++) {
            if (!nonPrimes[i]) res++;
        }

        return res;
    }
}
