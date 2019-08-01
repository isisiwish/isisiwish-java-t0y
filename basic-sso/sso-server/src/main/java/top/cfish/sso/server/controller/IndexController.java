package top.cfish.sso.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.cfish.sso.client.constant.AuthConst;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController
{
    /**
     * 登录页面
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model)
    {
        model.addAttribute(AuthConst.CLIENT_URL, request.getParameter(AuthConst.CLIENT_URL));
        return "index";
    }
    
    /**
     * 登录成功页面
     */
    @RequestMapping("/success")
    public String success()
    {
        return "success";
    }
}
