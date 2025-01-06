package rocks.alexmihai.medium.pow;

/**
 * Compute recursively `x^(n/2) * x^(n/2)`, and `* x` if n was odd.
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;

        if (n < 0) {
            x = 1/x;
            n = -n;
        }

        return pow(x, n);
    }

    private double pow(double base, int exp) {
        if (exp == 0) return 1;

        var half = pow(base, exp / 2);
        var res = half * half;
        if (exp % 2 == 0) {
            return res;
        } else {
            return res * base;
        }
    }
}
