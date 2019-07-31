package top.cfish.algorithm.linkedlist;

import top.cfish.algorithm.inface.IList;

/**
 * @author: isisiwish
 * @date: 2018/8/29
 * @time: 14:37
 * todo sort
 * 含头结点单链表，含size记录表长
 */
public class LinkedList<T> implements IList<T>
{
    private class Node
    {
        public T e;
        public Node next;
        
        public Node(T e, Node next)
        {
            this.e = e;
            this.next = next;
        }
        
        public Node(T e)
        {
            this(e, null);
        }
        
        public Node()
        {
            this(null, null);
        }
        
        @Override
        public String toString()
        {
            return e.toString();
        }
    }
    
    private Node head;
    private int size;
    
    public LinkedList()
    {
        head = new Node();
        size = 0;
    }
    
    public LinkedList(T[] arr)
    {
        head = new Node();
        for (int i = arr.length - 1; i >= 0; i--)
        {
            addFirst(arr[i]);
        }
    }
    
    private Node getNode(int index)
    {
        if (index < -1 || index >= size)
        {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        else if (index == -1)
        {
            return head;
        }
        
        Node p = head.next;
        for (int i = 0; i < index; i++)
        {
            p = p.next;
        }
        return p;
    }
    
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    @Override
    public int getSize()
    {
        return size;
    }
    
    public void addFirst(T e)
    {
        add(0, e);
    }
    
    public void addLast(T e)
    {
        add(size, e);
    }
    
    @Override
    public void add(int index, T e)
    {
        addCheck(index);
        nullCheck(e);
        
        Node prev = head;
        for (int i = 0; i < index; i++)
        {
            prev = prev.next;
        }
        
        prev.next = new Node(e, prev.next);
        size++;
    }
    
    @Override
    public void addAll(int index, T[] arr)
    {
        Node p = getNode(index - 1);
        for (T item : arr)
        {
            Node node = new Node(item, p.next);
            p.next = node;
        }
    }
    
    @Override
    public T get(int index)
    {
        getCheck(index);
        
        Node p = head.next;
        for (int i = 0; i < index; i++)
        {
            p = p.next;
        }
        return p.e;
    }
    
    public T getFirst()
    {
        return get(0);
    }
    
    public T getLast()
    {
        return get(size - 1);
    }
    
    @Override
    public void set(int index, T e)
    {
        getCheck(index);
        
        if (null == e)
        {
            throw new NullPointerException();
        }
        
        Node p = head.next;
        for (int i = 0; i < index; i++)
        {
            p = p.next;
        }
        p.e = e;
    }
    
    @Override
    public int indexOf(T e)
    {
        nullCheck(e);
        
        int index = 0;
        Node p = head.next;
        
        while (p != null)
        {
            if (e.equals(p.e))
            {
                return index;
            }
            index++;
            p = p.next;
        }
        return -1;
    }
    
    @Override
    public boolean contains(T e)
    {
        return indexOf(e) != -1;
    }
    
    @Override
    public void clear()
    {
        if (!isEmpty())
        {
            removeFirst();
        }
    }
    
    public void reverse()
    {
        if (isEmpty() || getSize() == 1)
        {
            return;
        }
        
        Node p = head.next;
        Node q = p;
        Node s = head;
        
        while (p != null)
        {
            q = p.next;
            p.next = s;
            s.e = p.e;
            s = p;
            p = q;
        }
        head.next = null;
        head = s;
    }
    
    /**
     * 删除链表第一个元素e
     * O(n) + O(n)
     */
    public boolean removeElement2N(T e)
    {
        int index = indexOf(e);
        if (index == -1)
        {
            return false;
        }
        
        remove(index);
        return true;
    }
    
    /**
     * 删除链表第一个元素e
     * O(n)
     */
    public boolean removeElement(T e)
    {
        nullCheck(e);
        
        Node p = head.next;
        Node s = head;
        
        while (p != null)
        {
            if (p.e.equals(e))
            {
                break;
            }
            s = p;
            p = p.next;
        }
        if (p != null)
        {
            s.next = p.next;
            p.next = null;
            size--;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public void remove(T e)
    {
        removeElement(e);
    }
    
    /**
     * 递归从node删除所有元素e
     */
    private Node removeElementRecursive(Node node, T e)
    {
        if (node == null)
        {
            return null;
        }
        
        node.next = removeElementRecursive(node.next, e);
        if (node == head)
        {
            return node.next;
        }
        else
        {
            return node.e.equals(e) ? node.next : node;
        }
    }
    
    /**
     * 删除链表所有元素e
     */
    public void removeAllElement(T e)
    {
        removeElementRecursive(head, e);
    }
    
    @Override
    public void removeAll(T[] arr)
    {
        for (T e : arr)
        {
            removeAllElement(e);
        }
    }
    
    public T removeFirst()
    {
        return remove(0);
    }
    
    public T removeLast()
    {
        return remove(size - 1);
    }
    
    /**
     * 根据index索引删除链表元素
     */
    public T remove(int index)
    {
        getCheck(index);
        
        Node prev = head;
        for (int i = 0; i < index; i++)
        {
            prev = prev.next;
        }
        Node rsNode = prev.next;
        prev.next = prev.next.next;
        size--;
        rsNode.next = null;
        return rsNode.e;
    }
    
    public LinkedList removeRange(int start, int end)
    {
        subArrayRangeCheck(start, end);
        LinkedList newLinkedList = new LinkedList();
        
        Node p = getNode(start - 1);
        Node s = getNode(end);
        
        newLinkedList.head.next = p.next;
        p.next = s.next;
        s.next = null;
        
        return newLinkedList;
    }
    
    private void nullCheck(T e)
    {
        if (null == e)
        {
            throw new NullPointerException();
        }
    }
    
    private void getCheck(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    
    private void addCheck(int index)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    
    private void subArrayRangeCheck(int start, int end)
    {
        if (start < 0 || start > end || end >= size)
        {
            throw new IndexOutOfBoundsException("IndexOutOfBounds Error : size=" + size + "[start, end]=[" + start + ", " + end + "]");
        }
    }
    
    private String outOfBoundsMsg(int index)
    {
        return "IndexOutOfBounds Error : index=" + index + ", size=" + size;
    }
    
    @Override
    public boolean equals(Object o)
    {
        // 头结点相同，相等
        if (this == o)
        {
            return true;
        }
        // 类型不同，不相等
        if (!(o instanceof LinkedList))
        {
            return false;
        }
        // 头结点next相同，相等
        LinkedList<?> that = (LinkedList<?>)o;
        if (that.head.next == this.head.next)
        {
            return true;
        }
        // 链表长度不同，不相等
        if (size != that.getSize())
        {
            return false;
        }
        // 结点数据不相同，不相等
        Node p = this.head.next;
        Node s = (Node)that.head.next;
        while (p != null && s != null)
        {
            if (!p.e.equals(s.e))
            {
                return false;
            }
            p = p.next;
            s = s.next;
        }
        return true;
    }
    
    @Override
    public T[] subList(int start, int end)
    {
        subArrayRangeCheck(start, end);
        int len = end - start + 1;
        
        Node p = getNode(start);
        T[] subArr = (T[])(new Object[len]);
        for (int i = 0; i < len; i++)
        {
            subArr[i] = p.e;
            p = p.next;
        }
        
        return subArr;
    }
    
    @Override
    public T[] toArray()
    {
        return subList(0, size - 1);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node p = head.next;
        
        while (p != null)
        {
            sb.append(p.e);
            sb.append("->");
            p = p.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
