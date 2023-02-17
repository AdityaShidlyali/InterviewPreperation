// https://leetcode.com/problems/add-two-numbers/
// Time complexity: O(n) where n is total number of nodes in given lists l1 and l2
// Space complexity: O(1)

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ansListHead = new ListNode();
        ListNode curr = ansListHead;

        // keep the track of carry to add the numbers
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int digFromL1 = 0, digFromL2 = 0;

            // if l1 is not null then only get the data from l1
            if (l1 != null) {
                digFromL1 = l1.val;
            } else {
                digFromL1 = 0;
            }
            
            // if l2 is not null then only get the data from l2
            if (l2 != null) {
                digFromL2 = l2.val;
            } else {
                digFromL2 = 0;
            }
            
            // create new digit by adding the digit from l1, digit from l2 and carry
            int additionDigit = digFromL1 + digFromL2 + carry;

            // get the carry by dividing the added number by 10
            carry = additionDigit / 10;

            // get the unit digit to add to the answer list
            additionDigit = additionDigit % 10;

            // create new node and add the additionDigit and next pointer of this node should be null
            curr.next = new ListNode(additionDigit, null);
            curr = curr.next;
            
            // if l1 is not null then only move to next node of l1
            if (l1 != null) {
                l1 = l1.next;
            }
            
            // if l2 is not null then only move to next node of l2
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        
        return ansListHead.next;
    }
}