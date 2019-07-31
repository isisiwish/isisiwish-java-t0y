package top.cfish.leetcode.linkedlist;


import top.cfish.leetcode.linkedlist.about.LinkedListUtil;
import top.cfish.leetcode.linkedlist.about.ListNode;

/**
 * @author: isisiwish
 * @date: 2018/8/31
 * @time: 16:40
 * No.206
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 * tips: YuLinkedList#reverse()方法已实现
 */
public class 反转链表_206
{
    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        
        ListNode p = head;
        ListNode s = null;
        ListNode q = p.next;
        
        while (p != null)
        {
            q = p.next;
            p.next = s;
            s = p;
            p = q;
        }
        return s;
    }
    
    // todo
    public ListNode reverseListRecursive(ListNode head)
    {
        return null;
    }
    
    public static void main(String[] args)
    {
        ListNode head = LinkedListUtil.buildLinkedList(new int[]{10, 20, 30, 40, 50});
        System.out.println(head);
        
        反转链表_206 o = new 反转链表_206();
        head = o.reverseListRecursive(head);
        System.out.println(head);
    }
}
