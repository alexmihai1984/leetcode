package rocks.alexmihai.medium.recoverbst;

import java.util.concurrent.atomic.AtomicReference;

/**
 * During in-order traversal, the elements are supposed to be in order, but the rule will be broken once or twice.
 * Define `first` to be the reference to the first element out of position.
 * Define `second` to be the reference to the second element out of position.
 * Traverse the tree in-order. During traversal, always keep track of the previously visited node `prev`.
 * When `prev` > current, it means the 2 nodes are out of order. Save `prev` in `first` and the current node in
 * `second`. This covers the case when the out-of-order nodes are consecutive during traversal.
 * Continue traversing and if there's a second pair that is out of order, save the current node in `second`. It means
 * the greater element in the first pair and the smaller element in the second pair are the ones that need to be
 * swapped. Basically if you think of all the elements listed in-order, in the 2 pairs that are out of order you want
 * to put the lef-most element at the end and the right-mos element at the start.
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        AtomicReference<TreeNode> first = new AtomicReference<>();
        AtomicReference<TreeNode> second = new AtomicReference<>();
        inorder(root, new AtomicReference<>(), first, second);

        var temp = first.get().val;
        first.get().val = second.get().val;
        second.get().val = temp;
    }

    private void inorder(TreeNode node, AtomicReference<TreeNode> prev, AtomicReference<TreeNode> first, AtomicReference<TreeNode> second) {
        if (node == null) return;

        inorder(node.left, prev, first, second);

        if (prev.get() != null && prev.get().val > node.val) {
            if (first.get() == null) {
                first.set(prev.get());
                second.set(node);
            } else {
                second.set(node);
            }
        }

        prev.set(node);

        inorder(node.right, prev, first, second);
    }
}
