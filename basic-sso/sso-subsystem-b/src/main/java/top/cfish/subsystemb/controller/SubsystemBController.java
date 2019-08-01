package top.cfish.subsystemb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: isisiwish
 * @date: 2019/3/26
 * @time: 10:33
 */
@Controller
public class SubsystemBController
{
    @RequestMapping("/test")
    public String test(HttpServletRequest request, Model model)
    {
        return "test";
    }
    
    @RequestMapping("/success")
    public String success(HttpServletRequest request, Model model)
    {
        return "success";
    }
}
