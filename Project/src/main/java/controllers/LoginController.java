package controllers;

import entity.User;
import org.apache.log4j.Logger;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(LoginController.class);

    private UserService userService;

    public LoginController() {
        this.userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email != null && password != null) {
            Optional<User> optionalUser = userService.findByEmail(email);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                if (password.equals(user.getPassword())) {
                    req.getSession().setAttribute("email", email);
                    req.getSession().setAttribute("role", user.getRole());
                    resp.sendRedirect("/main");
                } else {
                    LOG.warn("Invalid password");
                    resp.setStatus(401);
                }
            } else {
                LOG.warn("User not found");
                resp.setStatus(404);
            }
        }

    }
}
