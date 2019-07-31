package top.cfish.jvm.research.JVM_02;

/**
 * @author: isisiwish
 * @date: 2019/6/10
 * @time: 14:35
 */
public class JVM_02_StackTest
{
    public void record(double score)
    {
    }
    
    public double getAverage()
    {
        return 0;
    }
    
    public static void main(String[] args)
    {
        JVM_02_StackTest calculator = new JVM_02_StackTest();
        
        int score1 = 1;
        int score2 = 2;
        
        calculator.record(score1);
        calculator.record(score2);
        
        double avg = calculator.getAverage();
    }
}
