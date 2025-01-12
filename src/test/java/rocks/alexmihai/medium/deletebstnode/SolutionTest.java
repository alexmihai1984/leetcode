package rocks.alexmihai.medium.deletebstnode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testDeleteNodeEmpty() {
        var res = solution.deleteNode(null, 0);

        assertEquals(null, res);
    }

    @Test
    void testDeleteNodeNotFound() {
        var root = new TreeNode(
                5,
                new TreeNode(
                        3,
                        new TreeNode(2),
                        new TreeNode(4)
                ),
                new TreeNode(
                        6,
                        null,
                        new TreeNode(7)
                )
        );
        var res = solution.deleteNode(root, 0);

        assertEquals(5, res.val);
        assertEquals(3, res.left.val);
        assertEquals(6, res.right.val);
        assertEquals(2, res.left.left.val);
        assertEquals(4, res.left.right.val);
        assertEquals(7, res.right.right.val);
    }

    @Test
    void testDeleteNodeFound() {
        var root = new TreeNode(
                5,
                new TreeNode(
                        3,
                        new TreeNode(2),
                        new TreeNode(4)
                ),
                new TreeNode(
                        6,
                        null,
                        new TreeNode(7)
                )
        );
        var res = solution.deleteNode(root, 3);

        assertEquals(5, res.val);
        assertEquals(4, res.left.val);
        assertEquals(6, res.right.val);
        assertEquals(2, res.left.left.val);
        assertEquals(7, res.right.right.val);
    }
}