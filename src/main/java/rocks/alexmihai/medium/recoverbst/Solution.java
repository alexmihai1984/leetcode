package rocks.alexmihai.medium.recoverbst;

import java.util.concurrent.atomic.AtomicReference;

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
