package dataStructure.linkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {


    }
}
// 链表是用索引进行遍历，改变一个节点的next必然后导致整个链表结构的变化
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode r1 = res;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (t1 != null && t2 != null) {
            if (t1.val >= t2.val) {
                r1.next = t2;
                t2 = t2.next;
                t2 = t2.next;
            } else {
                r1.next = t1;
                r1 = r1.next;
                t1 = t1.next;
            }
        }
        while (t1 != null) {
            r1.next = t1;
            t1 = t1.next;
            r1 = r1.next;
        }
        while (t2 != null) {
            r1.next = t2;
            t2 = t2.next;
            r1 = r1.next;
        }
        return res.next;
    }

    // 移除链表元素
    // https://leetcode-cn.com/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode t1 = dummy;
        dummy.next = head;
        while (t1.next != null) {
            if (t1.next.val == val) {
                t1.next = t1.next.next;
                // invoke GC
                // next = null;

            } else {
                t1 = t1.next;
            }

        }
        return dummy.next;
    }

    //https://leetcode-cn.com/problems/reverse-linked-list/
    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //process current node;
            // 1 -> 2 =》1 -> prev(null)
            ListNode next = curr.next;
            curr.next = prev;
            // prev = 1
            prev = curr;
            // curr = 2
            curr = next;
        }
        return prev;
    }

    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
    // 删除链表中重复的元素
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return curr;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        Solution solution = new Solution();
        // solution.removeElements(node, 3);
        solution.reverseList(node);
    }
}

