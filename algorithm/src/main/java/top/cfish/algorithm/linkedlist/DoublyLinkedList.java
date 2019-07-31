package top.cfish.algorithm.linkedlist;

/**
 * @author: isisiwish
 * @date: 2018/8/30
 * @time: 13:56
 * 双向链表
 * 包含头尾节点
 */
public class DoublyLinkedList<T>
{
    private class Node
    {
        T item;
        Node prev;
        Node next;
        
        public Node(T element, Node prev, Node next)
        {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
        
        public Node(T element)
        {
            this(element, null, null);
        }
        
        public Node()
        {
            this(null, null, null);
        }
    }
    
    // 头尾结点
    private Node head;
    private Node tail;
    private int size;
    
    public DoublyLinkedList()
    {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    private void addCheck(int index)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    
    private void getCheck(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    
    private void nullCheck(T e)
    {
        if (null == e)
        {
            throw new NullPointerException();
        }
    }
    
    private String outOfBoundsMsg(int index)
    {
        return "IndexOutOfBounds Error : index=" + index + ", size=" + size;
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
        
        if (index < (size >> 1))
        {
            Node p = head.next;
            for (int i = 0; i < index; i++)
            {
                p = p.next;
            }
            return p;
        }
        else
        {
            Node p = tail.prev;
            for (int i = size - 1; i > index; i--)
            {
                p = p.prev;
            }
            return p;
        }
    }
    
    public void addFirst(T e)
    {
        add(0, e);
    }
    
    public void addLast(T e)
    {
        add(size, e);
    }
    
    public void add(int index, T e)
    {
        addCheck(index);
        nullCheck(e);
        
        Node prev = getNode(index - 1);
        Node newNode = new Node(e, prev, prev.next);
        prev.next.prev = newNode;
        prev.next = newNode;
        size++;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("YuDoubleLinkedList: ");
        Node p = head.next;
        
        while (p != tail)
        {
            sb.append(p.item);
            sb.append("->");
            p = p.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
    
    public T getHead()
    {
        return get(0);
    }
    
    public T getTail()
    {
        return get(getSize() - 1);
    }
    
    public T get(int index)
    {
        getCheck(index);
        return getNode(index).item;
    }
    
    public T set(int index, T e)
    {
        getCheck(index);
        nullCheck(e);
        
        Node rsNode = getNode(index);
        T rs = rsNode.item;
        
        rsNode.item = e;
        return rs;
    }
    
    public T removeFirst()
    {
        return remove(0);
    }
    
    public T removeLast()
    {
        return remove(size - 1);
    }
    
    public T remove(int index)
    {
        getCheck(index);
        
        Node delNode = getNode(index);
        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
        size--;
        delNode.prev = null;
        delNode.next = null;
        return delNode.item;
    }
    
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
    
    public boolean removeElement(T e)
    {
        nullCheck(e);
        Node p = head.next;
        
        while (p != tail)
        {
            if (e.equals(p.item))
            {
                break;
            }
            p = p.next;
        }
        if (p != null)
        {
            p.prev.next = p.next;
            p.next.prev = p.prev;
            p.next = null;
            p.prev = null;
            p.item = null;
            size--;
            return true;
        }
        return false;
    }
    
    public boolean contains(T e)
    {
        return indexOf(e) != -1;
    }
    
    public int indexOf(T e)
    {
        nullCheck(e);
        
        int index = 0;
        Node curr = head.next;
        
        while (curr != tail)
        {
            if (e.equals(curr.item))
            {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }
    
    public int lastIndexOf(T e)
    {
        nullCheck(e);
        
        int index = size - 1;
        Node curr = tail.prev;
        
        while (curr != head)
        {
            if (e.equals(curr.item))
            {
                return index;
            }
            curr = curr.prev;
            index--;
        }
        return -1;
    }
    
    public void clear()
    {
        while (!isEmpty())
        {
            removeFirst();
        }
    }
    
    public T[] toArray()
    {
        T[] result = (T[])(new Object[size]);
        int i = 0;
        Node curr = head.next;
        while (curr != tail)
        {
            result[i] = curr.item;
            curr = curr.next;
            i++;
        }
        return result;
    }
}
