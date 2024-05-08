// https://leetcode.com/problems/double-a-number-represented-as-a-linked-list

/**
>>Time Complexity
The time complexity of the code is O(n) where n is the number of nodes in the linked list. This complexity arises from several operations that each take linear time:

The reverse function traverses all the nodes of the linked list once to reverse it. This operation is O(n).

The next section of the code involving multiplication and building the new result linked list also takes linear time since it processes each node exactly once. Each operation inside the while loop takes constant time, and the loop runs for n iterations: O(n).

The reverse function is called again to reverse the modified list back to the original order. This is another O(n) operation.

Since these operations are sequential, the overall time complexity is the sum of individual complexities: O(n) + O(n) + O(n) which simplifies to O(n).

>>Space Complexity:
For space complexity, we exclude the space taken by the input and output from consideration, as is standard in complexity analysis.

The reverse function uses a constant amount of extra space (a few pointers) that does not depend on the size of the list, so it is O(1).

In the main part of the function, apart from the input and the result, we use a constant amount of variables (dummy, cur, mul, carry, next, x). Hence, the space complexity remains O(1).

The reference answer confirms the analysis of both time complexity O(n) and the space complexity O(1) for the given code.
*/
class Solution {
    public ListNode doubleIt(ListNode head) {
        // First reverse the linked list in order to traverse the linked list from
        // LSB(Least Significant Bit) to MSB(Most Significant Bit)
        head = reverseLL(head);
        ListNode curr = head;
        ListNode prev = curr;
        int multiplier = 2;
        int carry = 0;

        while (curr != null) {
            int product = curr.val * multiplier + carry;
            carry = product / 10;
            curr.val = product % 10;
            prev = curr;
            curr = curr.next;
        }

        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        return reverseLL(head);
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
