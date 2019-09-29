package top.cfish.leetcode.linkedlist;


import top.cfish.leetcode.linkedlist.about.LinkedListUtil;
import top.cfish.leetcode.linkedlist.about.ListNode;

/**
 * @author: isisiwish
 * @date: 2018/8/31
 * @time: 10:42
 * No.203
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 */
public class 删除链表中的节点_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p != null && p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElementsRecursive(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.buildLinkedList(new int[]{10, 20, 100, 30, 100, 100, 40, 100, 50, 100, 60, 100, 100, 100});
        System.out.println(head);

        删除链表中的节点_203 o = new 删除链表中的节点_203();
        o.removeElementsRecursive(head, 100);
        System.out.println(head);
    }
}
