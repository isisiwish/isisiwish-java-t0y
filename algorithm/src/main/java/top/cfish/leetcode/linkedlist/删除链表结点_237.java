package top.cfish.leetcode.linkedlist;


import top.cfish.leetcode.linkedlist.about.LinkedListUtil;
import top.cfish.leetcode.linkedlist.about.ListNode;

/**
 * @author: isisiwish
 * @date: 2018/8/31
 * @time: 10:57
 * No.237
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/description/
 */
public class 删除链表结点_237
{
    // O(1)
    public void deleteNode(ListNode node)
    {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
    public static void main(String[] args)
    {
        ListNode head = LinkedListUtil.buildLinkedList(new int[]{10, 20, 30, 40, 50, 60});
        System.out.println(head);
        
        ListNode node = head.next.next;
        System.out.println(node.val);
        
        删除链表结点_237 o = new 删除链表结点_237();
        o.deleteNode(node);
        System.out.println(head);
    }
}
