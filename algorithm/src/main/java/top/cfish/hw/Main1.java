package top.cfish.hw;

import java.util.Scanner;

/**
 * @author: isisiwish
 * @date: 2019/12/7 0007
 * @time: 21:03
 */
public class Main1
{
    // 本题为考试单行多行输入输出规范示例，无需提交，不计分。
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt())
        {
            // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
    
    // 本题为考试多行输入输出规范示例，无需提交，不计分。
        public static void main1(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int ans = 0, x;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    x = sc.nextInt();
                    ans += x;
                }
            }
            System.out.println(ans);
        }
}
