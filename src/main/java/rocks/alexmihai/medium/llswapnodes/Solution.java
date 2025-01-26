package rocks.alexmihai.medium.llswapnodes;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        var current = head;
        ListNode prev = null;
        head = head.next;
        while (current != null && current.next != null) {
            var next = current.next;

            current.next = next.next;
            next.next = current;

            if (prev != null) {
                prev.next = next;
            }

            prev = current;
            current = current.next;
        }

        return head;
    }
}
