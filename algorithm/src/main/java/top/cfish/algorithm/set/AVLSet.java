package top.cfish.algorithm.set;

import top.cfish.algorithm.inface.ISet;
import top.cfish.algorithm.tree.bstree.AVLTree;

/**
 * @author: isisiwish
 * @date: 2018/9/10
 * @time: 15:16
 */
public class AVLSet<E extends Comparable<E>> implements ISet<E>
{
    private AVLTree<E, Object> avl;
    
    public AVLSet()
    {
        avl = new AVLTree<>();
    }
    
    @Override
    public int getSize()
    {
        return avl.getSize();
    }
    
    @Override
    public boolean isEmpty()
    {
        return avl.isEmpty();
    }
    
    @Override
    public void add(E e)
    {
        avl.add(e, null);
    }
    
    @Override
    public boolean contains(E e)
    {
        return avl.contains(e);
    }
    
    @Override
    public void remove(E e)
    {
        avl.remove(e);
    }
}
