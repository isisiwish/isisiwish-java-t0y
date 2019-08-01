package top.cfish.algorithm.tree.bstree;

import top.cfish.algorithm.inface.ITree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: isisiwish
 * @date: 2018/9/4
 * @time: 7:15
 */

/**
 * BinarySearchTree-二叉搜索树
 * 父亲节点大于左子树所有节点的值
 * 父亲节点小于右子树所有节点的值
 *
 * 本代码实现不包含重复元素
 */
public class BSTree<T extends Comparable<T>> implements ITree<T>
{
    private class Node
    {
        public T e;
        public Node left;
        public Node right;
        
        public Node(T e, Node left, Node right)
        {
            this.e = e;
            this.left = left;
            this.right = right;
        }
        
        public Node(T e)
        {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node root;
    private int size;
    
    @Override
    public int getSize()
    {
        return size;
    }
    
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    private void add(Node node, T e)
    {
        // 该树不包含重复元素
        if (e.equals(node.e))
        {
            return;
        }
        else if (e.compareTo(node.e) < 0 && node.left == null)
        {
            // 待插入元素小于节点元素，并且该节点没有左子树，直接插入左子树
            node.left = new Node(e);
            size++;
            return;
        }
        else if (e.compareTo(node.e) > 0 && node.right == null)
        {
            // 待插入元素大于节点元素，并且该节点没有右子树，直接插入右子树
            node.right = new Node(e);
            size++;
            return;
        }
        
        // 左右子树递归插入，相等情况已排除
        if (e.compareTo(node.e) < 0)
        {
            add(node.left, e);
        }
        else
        {
            add(node.right, e);
        }
    }
    
    public void add(T e)
    {
        // 对于空树开辟根节点
        if (root == null)
        {
            root = new Node(e);
            size++;
        }
        else
        {
            add(root, e);
        }
    }
    
    private Node addEx(Node node, T e)
    {
        // 把调用方法的空树逻辑处理融合入递归方法，并且把递归结束条件统一
        if (node == null)
        {
            size++;
            return new Node(e);
        }
        
        if (e.compareTo(node.e) < 0)
        {
            node.left = addEx(node.left, e);
        }
        else if (e.compareTo(node.e) > 0)
        {
            node.right = addEx(node.right, e);
        }
        
        return node;
    }
    
    public void addEx(T e)
    {
        root = addEx(root, e);
    }
    
    private boolean contains(Node node, T e)
    {
        if (node == null)
        {
            return false;
        }
        
        if (e.compareTo(node.e) == 0)
        {
            return true;
        }
        else if (e.compareTo(node.e) < 0)
        {
            return contains(node.left, e);
        }
        else
        {
            return contains(node.right, e);
        }
    }
    
    @Override
    public boolean contains(T e)
    {
        return contains(root, e);
    }
    
    private  int getHeight(Node root)
    {
        return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    
    @Override
    public int getHeight()
    {
        return getHeight(root);
    }
    
    private void preOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
    // 前序遍历，中左右
    public void preOrder()
    {
        preOrder(root);
    }
    
    // 前序遍历非递归 - 栈
    public void preOrderNR()
    {
        if (root == null)
        {
            return;
        }
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty())
        {
            Node curr = stack.pop();
            System.out.print(curr.e + " ");
            if (curr.right != null)
            {
                stack.push(curr.right);
            }
            if (curr.left != null)
            {
                stack.push(curr.left);
            }
        }
    }
    
    // 前序遍历非递归
    public void preOrderNR2()
    {
        if (root == null)
        {
            return;
        }
        
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        
        while (curr != null || !stack.isEmpty())
        {
            while (curr != null)
            {
                System.out.print(curr.e + " ");
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
    }
    
    // 前序遍历非递归
    public void preOrderNR3()
    {
        if (root == null)
        {
            return;
        }
        
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        
        while (curr != null || !stack.isEmpty())
        {
            if (curr != null)
            {
                System.out.print(curr.e + " ");
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                curr = stack.pop();
                curr = curr.right;
            }
        }
    }
    
    private void inOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        
        inOrder(node.left);
        System.out.print(node.e + " ");
        inOrder(node.right);
    }
    
    // 中序遍历，左中右
    public void inOrder()
    {
        inOrder(root);
    }
    
    // 中序遍历非递归
    public void inOrderNR()
    {
        if (isEmpty())
        {
            return;
        }
        
        // 左中右
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty())
        {
            while (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.e + " ");
            curr = curr.right;
        }
    }
    
    // 中序遍历非递归
    public void inOrderNR2()
    {
        if (isEmpty())
        {
            return;
        }
        
        // 左中右
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty())
        {
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                curr = stack.pop();
                System.out.print(curr.e + " ");
                curr = curr.right;
            }
        }
    }
    
    private void postOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + " ");
    }
    
    // 后序遍历，左右中
    public void postOrder()
    {
        postOrder(root);
    }
    
    // todo 后序遍历非递归
    public void postOrderNR()
    {
        if (isEmpty())
        {
            return;
        }
    }
    
    // 层序遍历
    public void levelOrder()
    {
        if (root == null)
        {
            return;
        }
        // 使用队列，保存子树结点
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty())
        {
            // 取出队头，打印元素
            Node curr = queue.remove();
            System.out.print(curr.e + " ");
            
            // 保存下一层结点
            if (curr.left != null)
            {
                queue.add(curr.left);
            }
            if (curr.right != null)
            {
                queue.add(curr.right);
            }
        }
    }
    
    // 获取最小结点
    private Node getMin(Node node)
    {
        if (node.left == null)
        {
            return node;
        }
        
        return getMin(node.left);
    }
    
    // 获取最小元素
    public T getMin()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("BSTree is empty");
        }
        Node node = getMin(root);
        return node.e;
    }
    
    // 获取最大结点
    private Node getMax(Node node)
    {
        if (node.right == null)
        {
            return node;
        }
        
        return getMax(node.right);
    }
    
    // 获取最大元素
    public T getMax()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("BSTree is empty");
        }
        Node node = getMax(root);
        return node.e;
    }
    
    private Node removeMin(Node node)
    {
        if (node.left == null)
        {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        
        node.left = removeMin(node.left);
        return node;
    }
    
    // 删除最小结点
    public T removeMin()
    {
        T min = getMin();
        root = removeMin(root);
        return min;
    }
    
    private Node removeMax(Node node)
    {
        if (node.right == null)
        {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        
        node.right = removeMin(node.right);
        return node;
    }
    
    // 删除最小结点
    public T removeMax()
    {
        T max = getMax();
        root = removeMax(root);
        return max;
    }
    
    // 删除掉以node为根的二分搜索树中值为e的节点
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, T e)
    {
        if (node == null)
        {
            return null;
        }
        
        if (e.compareTo(node.e) < 0)
        {
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) > 0)
        {
            node.right = remove(node.right, e);
            return node;
        }
        else
        {
            // 待删除节点左子树为空的情况
            if (node.left == null)
            {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            
            // 待删除节点右子树为空的情况
            if (node.right == null)
            {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            
            // 待删除节点左右子树均不为空的情况
            
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = getMin(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            
            node.left = node.right = null;
            
            return successor;
        }
    }
    
    public void remove(T e)
    {
        root = remove(root, e);
    }
    
    public static void main(String[] args)
    {
        BSTree<Integer> bst = new BSTree<>();
        int[] arr = {5, 3, 6, 8, 4, 2};
        for (int i : arr)
        {
            bst.add(i);
        }
        
        System.out.println("树深度 : " + bst.getHeight());
        
        // 5 3 6 2 4 8
        System.out.print("层序 : ");
        bst.levelOrder();
        System.out.print("\n");
        
        // 5 3 2 4 6 8
        System.out.print("前序 : ");
        bst.preOrder();
        System.out.print("\n");
        
        System.out.print("前序NR1 : ");
        bst.preOrderNR();
        System.out.print("\n");
        
        System.out.print("前序NR2 : ");
        bst.preOrderNR2();
        System.out.print("\n");
        
        System.out.print("前序NR3 : ");
        bst.preOrderNR3();
        System.out.print("\n");
        
        // 2 3 4 5 6 8
        System.out.print("中序 : ");
        bst.inOrder();
        System.out.print("\n");
        
        System.out.print("中序NR1 : ");
        bst.inOrderNR();
        System.out.print("\n");
        
        System.out.print("中序NR2 : ");
        bst.inOrderNR2();
        System.out.print("\n");
        
        // 2 4 3 8 6 5
        System.out.print("后序 : ");
        bst.postOrder();
        System.out.print("\n");
    }
}
