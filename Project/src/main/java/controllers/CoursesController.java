package controllers;

import entity.Course;
import entity.User;
import org.apache.log4j.Logger;
import service.CourseService;
import service.UserService;
import service.impl.CourseServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/courses")
public class CoursesController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(CoursesController.class);

    private CourseService courseService;

    private UserService userService;

    public CoursesController() {
        this.courseService = CourseServiceImpl.getInstance();
        this.userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("courses.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("course");
        Optional<Course> courseByName = courseService.findByName(name);
        if (courseByName.isPresent()) {
            User user = new User();
            Integer id = courseService.findIdByName(name);
            String email = (String) req.getSession().getAttribute("email");
            Optional<User> userByEmail = userService.findByEmail(email);
            if (userByEmail.isPresent()) {
                userByEmail.ifPresent(user1 -> user.setRole(user1.getRole()));
                userByEmail.ifPresent(user1 -> user.setEmail(user1.getEmail()));
                userByEmail.ifPresent(user1 -> user.setFirstName(user1.getFirstName()));
                userByEmail.ifPresent(user1 -> user.setLastName(user1.getLastName()));
                userByEmail.ifPresent(user1 -> user.setId(user1.getId()));
                userByEmail.ifPresent(user1 -> user.setPassword(user1.getPassword()));
                userByEmail.ifPresent(user1 -> user.setCourse(id));
                userService.update(user);
                resp.sendRedirect("/main");
            } else {
                resp.setStatus(422);
            }
        } else {
            resp.setStatus(422);
        }
    }
}
