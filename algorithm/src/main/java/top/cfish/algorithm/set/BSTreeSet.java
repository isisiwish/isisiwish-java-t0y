package top.cfish.algorithm.set;

import top.cfish.algorithm.inface.ISet;
import top.cfish.algorithm.tree.bstree.BSTree;

/**
 * @author: isisiwish
 * @date: 2018/9/4
 * @time: 14:53
 */
public class BSTreeSet<T extends Comparable<T>> implements ISet<T>
{
    private BSTree<T> bst;
    
    public BSTreeSet()
    {
        bst = new BSTree<>();
    }
    
    @Override
    public int getSize()
    {
        return bst.getSize();
    }
    
    @Override
    public boolean isEmpty()
    {
        return bst.isEmpty();
    }
    
    @Override
    public void add(T e)
    {
        bst.add(e);
    }
    
    @Override
    public void remove(T e)
    {
        bst.remove(e);
    }
    
    @Override
    public boolean contains(T e)
    {
        return bst.contains(e);
    }
}
