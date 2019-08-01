package top.cfish.sso.client.filter;

import top.cfish.sso.client.constant.AuthConst;
import top.cfish.sso.client.storage.SessionStorage;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: isisiwish
 * @date: 2019/3/26
 * @time: 17:46
 */
public class LoginFilter implements Filter
{
    private FilterConfig config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        config = filterConfig;
    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        HttpSession session = request.getSession();
        
        // 已登录状态，通过
        if (session.getAttribute(AuthConst.IS_LOGIN) != null)
        {
            chain.doFilter(req, res);
            return;
        }
        
        // 从认证中心跳转含token的请求，有效则放行
        String token = request.getParameter(AuthConst.TOKEN);
        if (token != null)
        {
            session.setAttribute(AuthConst.IS_LOGIN, true);
            session.setAttribute(AuthConst.TOKEN, token);
            // 存储，用于注销
            SessionStorage.INSTANCE.set(token, session);
            chain.doFilter(req, res);
            return;
        }
        
        // 重定向至登录页面，并附带当前请求地址
        response.sendRedirect(config.getInitParameter(AuthConst.LOGIN_URL) + "?" + AuthConst.CLIENT_URL + "=" + request.getRequestURL());
    }
    
    @Override
    public void destroy()
    {
    
    }
}
