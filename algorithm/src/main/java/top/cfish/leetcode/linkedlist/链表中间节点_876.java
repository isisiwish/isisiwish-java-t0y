package top.cfish.leetcode.linkedlist;


import top.cfish.leetcode.linkedlist.about.LinkedListUtil;
import top.cfish.leetcode.linkedlist.about.ListNode;

/**
 * @author: isisiwish
 * @date: 2018/8/31
 * @time: 15:47
 * No.876
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/description/
 * tips: 其实不需要头结点，使用头结点，无法通过LeetCode测试用例
 */
public class 链表中间节点_876
{
    public ListNode middleNode(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args)
    {
        ListNode head = LinkedListUtil.buildLinkedList(new int[]{10, 20, 30, 40, 50});
        
        链表中间节点_876 o = new 链表中间节点_876();
        ListNode middleNode = o.middleNode(head);
        
        System.out.println(middleNode.val);
    }
}
