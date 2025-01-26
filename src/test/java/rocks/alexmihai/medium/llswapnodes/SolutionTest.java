package rocks.alexmihai.medium.llswapnodes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testSwapPairsEmpty() {
        var res = solution.swapPairs(null);

        assertNull(res);
    }

    @Test
    void testSwapPairsJustHead() {
        var head = new ListNode(1);
        var res = solution.swapPairs(head);

        assertEquals(1, res.val);
        assertNull(res.next);
    }

    @Test
    void testSwapPairsEven() {
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        var res = solution.swapPairs(head);

        assertEquals(2, res.val);
        assertEquals(1, res.next.val);
        assertEquals(4, res.next.next.val);
        assertEquals(3, res.next.next.next.val);
        assertNull(res.next.next.next.next);
    }

    @Test
    void testSwapPairsOdd() {
        var head = new ListNode(1, new ListNode(2, new ListNode(3)));
        var res = solution.swapPairs(head);

        assertEquals(2, res.val);
        assertEquals(1, res.next.val);
        assertEquals(3, res.next.next.val);
        assertNull(res.next.next.next);
    }
}