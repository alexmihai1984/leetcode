package rocks.alexmihai.medium.arrayduplicates;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testFindDuplicatesEmpty() {
        var res = solution.findDuplicates(new int[]{});

        assertEquals(0, res.size());
    }

    @Test
    void testFindDuplicatesSingleElement() {
        var res = solution.findDuplicates(new int[]{1});

        assertEquals(0, res.size());
    }

    @Test
    void testFindDuplicatesFewNonRepeating() {
        var res = solution.findDuplicates(new int[]{1, 2, 3, 4, 5});

        assertEquals(0, res.size());
    }

    @Test
    void testFindDuplicatesFewRepeating() {
        var res = solution.findDuplicates(new int[]{1, 1, 2});

        assertEquals(List.of(1), res);
    }

    @Test
    void testFindDuplicatesManyRepeating() {
        var res = solution.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});

        assertEquals(List.of(3, 2), res);
    }

    @Test
    void testFindDuplicatesMoreRepeating() {
        var res = solution.findDuplicates(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7});

        assertEquals(List.of(10, 1), res);
    }
}