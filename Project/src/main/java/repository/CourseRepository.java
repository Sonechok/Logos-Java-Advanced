package repository;

import entity.Course;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    Optional<Course> findByName(String name);

    Integer findIdByName(String name);
}
