package rocks.alexmihai.medium.uniquebst;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {

        var res = new ArrayList<TreeNode>();
        for (int i = 1; i <= n; i++) {
            res.addAll(generateAllTrees(new TreeNode(i), 1, n));
        }

        return res;
    }

    private List<TreeNode> generateAllTrees(TreeNode root, int childrenRangeStart, int childrenRangeEnd) {
        var leftSubtrees = buildSubtrees(childrenRangeStart, root.val - 1);
        var rightSubtrees = buildSubtrees(root.val + 1, childrenRangeEnd);

        var res = new ArrayList<TreeNode>();
        if (leftSubtrees.isEmpty() && rightSubtrees.isEmpty()) {
            res.add(root);
            return res;
        }

        if (leftSubtrees.isEmpty()) {
            for (var rightSubtree : rightSubtrees) {
                var rootClone = cloneNode(root);
                rootClone.right = rightSubtree;

                res.add(rootClone);
            }
        }

        if (rightSubtrees.isEmpty()) {
            for (var leftSubtree : leftSubtrees) {
                var rootClone = cloneNode(root);
                rootClone.left = leftSubtree;

                res.add(rootClone);
            }
        }

        for (var leftSubtree : leftSubtrees) {
            for (var rightSubtree : rightSubtrees) {
                var rootClone = cloneNode(root);
                rootClone.left = leftSubtree;
                rootClone.right = rightSubtree;

                res.add(rootClone);
            }
        }

        return res;
    }

    private List<TreeNode> buildSubtrees(int start, int end) {
        if (start > end) {
            return List.of();
        }

        var subtrees = new ArrayList<TreeNode>();
        for (int i = start; i <= end; i++) {
            subtrees.addAll(generateAllTrees(new TreeNode(i), start, end));
        }

        return subtrees;
    }

    private TreeNode cloneNode(TreeNode node) {
        return new TreeNode(node.val, node.left, node.right);
    }
}
