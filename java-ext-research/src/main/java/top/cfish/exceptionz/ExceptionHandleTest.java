package top.cfish.exceptionz;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/7/14 0014
 * @time: 20:12
 */

@Slf4j
public class ExceptionHandleTest
{
    public static int doWork()
    {
        try
        {
            // 抛出异常，终止之后的代码逻辑，进入catch
            int i = 10 / 0;
            log.info("i = {}", i);
            return 1;
        }
        catch (ArithmeticException e)
        {
            // 捕获Exception，会进入finally执行，执行完成后，继续进行catch后的return，但如果finally包含return，则会提前退出
            log.info("arithmeticException", e);
            return 2;
        }
        finally
        {
            log.info("finally");
            // finally中不写return
            return 3;
        }
    }
    
    public static void main(String[] args)
    {
        int rs = doWork();
        log.info("result = {}", rs);
    }
}

/*
\java-ext-research\target\classes\top\cfish\exceptionz>javap -c ExceptionHandleTest.class
Compiled from "ExceptionHandleTest.java"
public class top.cfish.exceptionz.ExceptionHandleTest {
  public top.cfish.exceptionz.ExceptionHandleTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static int doWork();
    Code:
       0: bipush        10
       2: iconst_0
       3: idiv
       4: istore_0
       5: getstatic     #2                  // Field log:Lorg/slf4j/Logger;
       8: ldc           #3                  // String i = {}
      10: iload_0
      11: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      14: invokeinterface #5,  3            // InterfaceMethod org/slf4j/Logger.info:(Ljava/lang/String;Ljava/lang/Object;)V
      19: iconst_1
      20: istore_1
      21: getstatic     #2                  // Field log:Lorg/slf4j/Logger;
      24: ldc           #6                  // String finally
      26: invokeinterface #7,  2            // InterfaceMethod org/slf4j/Logger.info:(Ljava/lang/String;)V
      31: iconst_3
      32: ireturn
      33: astore_0
      34: getstatic     #2                  // Field log:Lorg/slf4j/Logger;
      37: ldc           #9                  // String arithmeticException
      39: aload_0
      40: invokeinterface #10,  3           // InterfaceMethod org/slf4j/Logger.info:(Ljava/lang/String;Ljava/lang/Throwable;)V
      45: iconst_2
      46: istore_1
      47: getstatic     #2                  // Field log:Lorg/slf4j/Logger;
      50: ldc           #6                  // String finally
      52: invokeinterface #7,  2            // InterfaceMethod org/slf4j/Logger.info:(Ljava/lang/String;)V
      57: iconst_3
      58: ireturn
      59: astore_2
      60: getstatic     #2                  // Field log:Lorg/slf4j/Logger;
      63: ldc           #6                  // String finally
      65: invokeinterface #7,  2            // InterfaceMethod org/slf4j/Logger.info:(Ljava/lang/String;)V
      70: iconst_3
      71: ireturn
    Exception table:
       from    to  target type
           0    21    33   Class java/lang/ArithmeticException
           0    21    59   any
          33    47    59   any

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #11                 // Method doWork:()I
       3: istore_1
       4: getstatic     #2                  // Field log:Lorg/slf4j/Logger;
       7: ldc           #12                 // String result = {}
       9: iload_1
      10: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      13: invokeinterface #5,  3            // InterfaceMethod org/slf4j/Logger.info:(Ljava/lang/String;Ljava/lang/Object;)V
      18: return

  static {};
    Code:
       0: ldc           #13                 // class top/cfish/exceptionz/ExceptionHandleTest
       2: invokestatic  #14                 // Method org/slf4j/LoggerFactory.getLogger:(Ljava/lang/Class;)Lorg/slf4j/Logger;
       5: putstatic     #2                  // Field log:Lorg/slf4j/Logger;
       8: return
}

 */
