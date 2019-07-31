package top.cfish.algorithm.inface;

/**
 * @author: isisiwish
 * @date: 2018/9/5
 * @time: 10:29
 */
public interface ICompare<T>
{
    /**
     * 通过interface实现函数指针
     *
     * @param o1 待比较对象o1
     * @param o2 待比较对象o2
     * @return 正数：o1 > o2、负数：o1 < o2、零：o1 ==o2
     */
    int cmp(T o1, T o2);
}
