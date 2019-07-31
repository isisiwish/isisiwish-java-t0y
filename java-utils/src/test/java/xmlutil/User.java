package xmlutil;

import top.cfish.utils.xmlutil.DomConvert;
import top.cfish.utils.xmlutil.DomField;
import top.cfish.utils.xmlutil.DomFieldConvert;
import top.cfish.utils.xmlutil.DomRoot;

import java.text.SimpleDateFormat;
import java.util.Date;

@DomRoot("user")
public class User
{
    public User()
    {
    }
    
    public User(String name, Integer age, Date joinDate)
    {
        this.name = name;
        this.age = age;
        this.joinDate = joinDate;
    }
    
    @DomField("userName")
    private String name;
    
    private Integer age;
    
    @DomFieldConvert(DateConvert.class)
    private Date joinDate;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Integer getAge()
    {
        return age;
    }
    
    public void setAge(Integer age)
    {
        this.age = age;
    }
    
    public Date getJoinDate()
    {
        return joinDate;
    }
    
    public void setJoinDate(Date joinDate)
    {
        this.joinDate = joinDate;
    }
    
    public static class DateConvert implements DomConvert
    {
        
        @Override
        public Date convert(Object object)
        {
            String date = (String)object;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = null;
            try
            {
                d = sdf.parse(date);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return d;
        }
    }
}
