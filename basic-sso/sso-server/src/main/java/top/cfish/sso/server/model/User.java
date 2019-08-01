package top.cfish.sso.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: isisiwish
 * @date: 2019/03/28
 * @time: 20:03
 */
@Getter
@Setter
@ToString
public class User
{
    private Integer id;
    
    private String username;
    
    private String password;
}
