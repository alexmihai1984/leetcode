package rocks.alexmihai.medium.deletebstnode;

/**
 * Find the node and it's parent. If it's not found, leave the tree untouched.
 * When found `node`:
 * - Parent's link to `node` updated to link to `node`.right (if present)
 * - Newly placed node's left becomes the parent's left
 * - The old left of the newly placed node must be linked to some leaf, search for the right spot
 * - If `node`.right not present, link parent to `node`.left
 */
public class Solution {
    private enum Direction { LEFT, RIGHT }
    private record SearchResult(TreeNode node, TreeNode parent, Direction direction) {}

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        SearchResult res = search(root, null, null, key);

        if (res == null) return root;

        if (res.parent == null) {
            if (root.right == null && root.left == null) return null;

            if (root.right != null) {
                var childLeft = root.right.left;
                var rootLeft = root.left;
                root = root.right;
                root.left = rootLeft;

                placeNode(childLeft, root);
            } else {
                root = root.left;
            }

            return root;
        }

        if (res.direction == Direction.LEFT) {
            if (res.node.right != null) {
                var childLeft = res.node.right.left;
                res.node.right.left = res.node.left;
                res.parent.left = res.node.right;

                placeNode(childLeft, res.node);
            } else {
                res.parent.left = res.node.left;
            }
        } else {
            if (res.node.right != null) {
                var childLeft = res.node.right.left;
                res.node.right.left = res.node.left;
                res.parent.right = res.node.right;

                placeNode(childLeft, res.node);
            } else {
                res.parent.right = res.node.left;
            }
        }

        return root;
    }

    private SearchResult search(TreeNode node, TreeNode parent, Direction direction, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.val) {
            return search(node.left, node, Direction.LEFT, key);
        } else if (key > node.val) {
            return search(node.right, node, Direction.RIGHT, key);
        } else {
            return new SearchResult(node, parent, direction);
        }
    }

    private void placeNode(TreeNode node, TreeNode root) {
        if (node == null) return;

        if (node.val < root.val) {
            if (root.left == null) {
                root.left = node;
            } else {
                placeNode(node, root.left);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                placeNode(node, root.right);
            }
        }
    }
}
