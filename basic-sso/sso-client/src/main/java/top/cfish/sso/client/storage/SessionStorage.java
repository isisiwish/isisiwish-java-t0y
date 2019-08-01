package top.cfish.sso.client.storage;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: isisiwish
 * @date: 2019/3/26
 * @time: 17:54
 */
public enum SessionStorage
{
    INSTANCE;
    
    private Map<String, HttpSession> map = new HashMap<String, HttpSession>();
    
    public void set(String token, HttpSession session)
    {
        map.put(token, session);
    }
    
    public HttpSession get(String token)
    {
        if (map.containsKey(token))
        {
            return map.remove(token);
        }
        return null;
    }
}
