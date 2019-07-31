package top.cfish.exceptionz;

import java.io.FileNotFoundException;

/**
 * @author: isisiwish
 * @date: 2019/7/14 0014
 * @time: 18:14
 */
public class ErrorAndExceptionTest
{
    private void throwError()
    {
        throw new StackOverflowError();
    }
    
    private void throwRuntimeException()
    {
        throw new RuntimeException();
    }
    
    // 编译器必须checked该异常，编译期必须处理
    private void throwCheckedException() throws FileNotFoundException
    {
        throw new FileNotFoundException();
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        ErrorAndExceptionTest e = new ErrorAndExceptionTest();
       // e.throwError();
       // e.throwRuntimeException();
       // e.throwCheckedException();
    }
}
