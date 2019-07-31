package xmlutil;

import top.cfish.utils.xmlutil.XmlUtils;

import java.util.Date;

public class XmlUtilsTest
{
    public static void main(String[] args)
    {
        User user = new User("ahern88", 25, new Date());
        String xml = XmlUtils.beanToXml(user);
        System.out.println(xml);
        User u = XmlUtils.xmlToBean(xml, User.class);
        System.out.println(u.getName() + " " + u.getAge() + " " + u.getJoinDate());
    }
}
