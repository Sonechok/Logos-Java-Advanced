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
import java.math.BigDecimal;
import java.util.Optional;

@WebServlet("/admin/cabinet")
public class AdminController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AdminController.class);

    private CourseService courseService;

    public AdminController() {
        this.courseService = CourseServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        Float priceFloat = Float.parseFloat(price);
        BigDecimal priceDecimal = new BigDecimal(priceFloat);
        Course course = new Course();
        course.setPrice(priceDecimal);
        course.setName(name);
        course.setDescription(description);
        if (isValidCourse(course)) {
            courseService.save(course);
            resp.sendRedirect("/main");
        }else {
            LOG.warn("invalid input data");
            resp.setStatus(400);
        }
    }

    private boolean isValidCourse(Course course) {
        return course.getDescription() != null
                && course.getName() != null
                && course.getPrice() != null;
    }
}
