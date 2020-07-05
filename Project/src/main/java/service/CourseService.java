package service;

import entity.Course;

import java.util.Optional;

public interface CourseService extends CrudService<Course, Integer> {
    Optional<Course> findByName(String name);

    Integer findIdByName(String name);
}
