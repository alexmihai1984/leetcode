package rocks.alexmihai.medium.listtobst;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        int count = 0;
        var current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        int[] values = new int[count];

        current = head;
        int idx = 0;
        while (current != null) {
            values[idx++] = current.val;
            current = current.next;
        }

        return buildSubtree(values, 0, values.length - 1);
    }

    private TreeNode buildSubtree(int[] values, int startIdx, int endIdx) {
        var root = new TreeNode();
        if (endIdx - startIdx == 0) {
            root.val = values[startIdx];

            return root;
        }

        int midIdx = startIdx + (endIdx - startIdx) / 2;
        root.val = values[midIdx];

        if (midIdx - startIdx > 0) {
            root.left = buildSubtree(values, startIdx, midIdx - 1);
        }

        if (endIdx - midIdx > 0) {
            root.right = buildSubtree(values, midIdx + 1, endIdx);
        }

        return root;
    }
}
