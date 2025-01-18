package rocks.alexmihai.medium.countprimes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testCountPrimesZero() {
        var res = solution.countPrimes(0);

        assertEquals(0, res);
    }

    @Test
    void testCountPrimesOne() {
        var res = solution.countPrimes(1);

        assertEquals(0, res);
    }

    @Test
    void testCountPrimesTen() {
        var res = solution.countPrimes(10);

        assertEquals(4, res);
    }
}