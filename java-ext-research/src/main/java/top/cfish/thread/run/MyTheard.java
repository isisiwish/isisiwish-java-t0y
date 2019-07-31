package top.cfish.thread.run;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 9:31
 */

@Slf4j
public class MyTheard extends Thread
{
    private String firstName;
    private String lastName;
    private String fullName;
    
    public MyTheard(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = String.format("%s.%s", firstName, lastName);
    }
    
    @Override
    public void run()
    {
        log.info("thread start: " + fullName);
        for (int i = 0; i < 3; i++)
        {
            log.info(fullName + " -> i:" + i);
        }
    }
}
