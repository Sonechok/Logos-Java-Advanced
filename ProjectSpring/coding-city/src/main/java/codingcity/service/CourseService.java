package codingcity.service;

import codingcity.dto.CourseDTO;
import codingcity.entity.Course;

import java.util.List;

public interface CourseService {
    CourseDTO createCourse(CourseDTO courseDTO);

    Course findById(Long id);
}
