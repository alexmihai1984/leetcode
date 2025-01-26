package rocks.alexmihai.medium.llswapnodes;

/**
 * Start at 'head'. Update 'head' to 'head.next' to return the correct reference.
 * Considering each pair 'current' and 'current.next', update their 'next' references:
 * - 'current.next' will reference 'current.next.next'
 * - 'current.next.next' will reference 'current.next'
 * Keep a reference of the tail node of the pair 'prev' so that after updating the next pair you can link 'prev'
 * to the head of the new pair.
 */
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
