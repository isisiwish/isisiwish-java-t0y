package top.cfish.leetcode.linkedlist.about;


/**
 * @author: isisiwish
 * @date: 2018/8/31
 * @time: 11:11
 */
public class LinkedListUtil
{
    public static ListNode buildLinkedList(int[] arr)
    {
        return buildHeadLinkedList(arr).next;
    }
    
    public static ListNode buildHeadLinkedList(int[] arr)
    {
        if (arr == null || arr.length == 0)
        {
            throw new IllegalArgumentException("array can not be empty");
        }
        
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = null;
        
        ListNode p = dummyNode;
        
        for (int val : arr)
        {
            p.next = new ListNode(val, null);
            p = p.next;
        }
        
        return dummyNode;
    }
}
