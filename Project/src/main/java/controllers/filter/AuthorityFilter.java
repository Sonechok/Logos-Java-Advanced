package controllers.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthorityFilter implements Filter {
    private final Logger log = Logger.getLogger(AuthorityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Init filter " + filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Filter log in");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        boolean isLoggedIn = session != null && session.getAttribute("email") != null;
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");
        boolean isRegistrationPage = httpRequest.getRequestURI().endsWith("registration");
        boolean isMainPage = httpRequest.getRequestURI().endsWith("main");
        if (isLoggedIn) {
            if (isLoginPage || isRegistrationPage) {
                ((HttpServletResponse)response).sendRedirect("/main");
            } else {
                chain.doFilter(request, response);
            }
        } else if (isLoginPage || isRegistrationPage || isMainPage) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {
        log.info("Destroy");
    }
}
