package rocks.alexmihai.medium.networkdelaytime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testNetworkDelayTime4NodesSinglePaths() {
        int n = 4;
        int[][] times = new int[][] {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int k = 2;

        var res = solution.networkDelayTime(times, n, k);
        assertEquals(2, res);
    }

    @Test
    void testNetworkDelayTime2NodesSinglePath() {
        int n = 2;
        int[][] times = new int[][] {
                {1, 2, 1}
        };
        int k = 1;

        var res = solution.networkDelayTime(times, n, k);
        assertEquals(1, res);
    }

    @Test
    void testNetworkDelayTime2NodesNoPath() {
        int n = 2;
        int[][] times = new int[][] {
                {1, 2, 1}
        };
        int k = 2;

        var res = solution.networkDelayTime(times, n, k);
        assertEquals(-1, res);
    }

    @Test
    void testNetworkDelayTime3NodesMultiplePaths() {
        int n = 3;
        int[][] times = new int[][] {
                {1, 2, 1},
                {2, 3, 7},
                {1, 3, 4},
                {2, 1, 2}
        };
        int k = 2;

        var res = solution.networkDelayTime(times, n, k);
        assertEquals(6, res);
    }
}