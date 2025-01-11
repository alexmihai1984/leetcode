package rocks.alexmihai.medium.recoverbst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testRecoverTreeRootAndMid() {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        3,
                        null,
                        new TreeNode(2)
                ),
                null
        );

        solution.recoverTree(root);

        assertEquals(3, root.val);
        assertEquals(1, root.left.val);
    }

    @Test
    void testRecoverTreeRootAndLeaf() {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(1),
                new TreeNode(
                        4,
                        new TreeNode(2),
                        null
                )
        );

        solution.recoverTree(root);

        assertEquals(2, root.val);
        assertEquals(3, root.right.left.val);
    }

    @Test
    void testRecoverTreeMids() {
        TreeNode root = new TreeNode(
                5,
                new TreeNode(
                        2,
                        null,
                        new TreeNode(
                                6,
                                null,
                                new TreeNode(4)
                        )
                ),
                new TreeNode(9,
                        new TreeNode(
                                3,
                                null,
                                new TreeNode(8)
                        ),
                        null
                )
        );

        solution.recoverTree(root);

        assertEquals(3, root.left.right.val);
        assertEquals(6, root.right.left.val);
    }

    @Test
    void testRecoverTreeRootAndRightLeaf() {
        TreeNode root = new TreeNode(
                3,
                null,
                new TreeNode(
                        2,
                        null,
                        new TreeNode(1)
                )
        );

        solution.recoverTree(root);

        assertEquals(1, root.val);
        assertEquals(3, root.right.right.val);
    }
}