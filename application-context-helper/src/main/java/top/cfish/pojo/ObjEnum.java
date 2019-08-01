package top.cfish.pojo;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * author: isisiwish
 * date: 2018/4/16 0016
 * time: 11:08
 */
@Getter
public enum ObjEnum
{
    OBJA(10, "对象A", lowerCaseFirstLetter(ObjA.class.getSimpleName())), OBJB(20, "对象B", lowerCaseFirstLetter(ObjB.class.getSimpleName()));
    
    private Integer pid;
    private String desc;
    private String objBean;
    
    ObjEnum(Integer pid, String desc, String objBean)
    {
        this.pid = pid;
        this.desc = desc;
        this.objBean = objBean;
    }
    
    public static Map<Integer, String> getObjBeanMap()
    {
        Map<Integer, String> objBeanServiceMap = new HashMap<>();
        for (ObjEnum p : ObjEnum.values())
        {
            objBeanServiceMap.put(p.getPid(), p.getObjBean());
        }
        return objBeanServiceMap;
    }
    
    private static String lowerCaseFirstLetter(String source)
    {
        String first = source.substring(0, 1).toLowerCase();
        String others = source.substring(1, source.length());
        return first + others;
    }
}
