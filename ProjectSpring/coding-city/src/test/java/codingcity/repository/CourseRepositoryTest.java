package codingcity.repository;

import codingcity.dto.CourseDTO;
import codingcity.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    CourseService courseService;

    @Test
    void createCourse() {
        CourseDTO courseDTO = new CourseDTO("Second", "description", 1000);
        CourseDTO result = courseService.createCourse(courseDTO);
        Assertions.assertEquals("Second", result.getName());
    }
}