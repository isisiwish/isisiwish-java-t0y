package top.cfish.leetcode.linkedlist.about;

/**
 * @author: isisiwish
 * @date: 2018/8/31
 * @time: 11:05
 */
public class ListNode
{
    public int val;
    public ListNode next;
    
    
    public ListNode(int x)
    {
        val = x;
    }
    
    public ListNode(int x, ListNode next)
    {
        this.val = x;
        this.next = next;
    }
    
    public ListNode()
    {
        this(-1, null);
    }
    
    // 以当前节点为头结点的链表信息字符串
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        
        while (cur != null)
        {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
