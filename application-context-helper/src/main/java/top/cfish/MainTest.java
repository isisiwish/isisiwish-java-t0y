package top.cfish;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.cfish.pojo.IObj;
import top.cfish.service.ApplicationContextHelper;

/**
 * author: isisiwish
 * date: 2018/4/16 0016
 * time: 11:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring.xml"})
public class MainTest
{
    @Autowired
    private ApplicationContextHelper contextHelper;
    
    @Test
    public void applicationContextHelperTest()
    {
        IObj obj = contextHelper.getServiceByPid(10);
        obj.printMsg("hello world");
    }
}
