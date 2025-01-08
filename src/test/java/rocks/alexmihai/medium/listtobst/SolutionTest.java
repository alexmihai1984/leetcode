package rocks.alexmihai.medium.listtobst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testSortedListToBSTEmpty() {
        var root = solution.sortedListToBST(null);

        assertNull(root);
    }

    @Test
    void testSortedListToBST5Elements() {
        var first = new ListNode(
                -10,
                new ListNode(
                        -3,
                        new ListNode(
                                0,
                                new ListNode(
                                        5,
                                        new ListNode(9)
                                )
                        )
                )
        );
        var root = solution.sortedListToBST(first);

        assertEquals(0, root.val);
        assertEquals(-10, root.left.val);
        assertEquals(-3, root.left.right.val);
        assertEquals(5, root.right.val);
        assertEquals(9, root.right.right.val);
    }
}