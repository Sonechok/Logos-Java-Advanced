package service.impl;

import entity.Course;
import org.apache.log4j.Logger;
import repository.CourseRepository;
import repository.UserRepository;
import repository.impl.CourseRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.CourseService;

import java.util.List;
import java.util.Optional;

public class CourseServiceImpl implements CourseService {
    private static Logger log = Logger.getLogger(CourseServiceImpl.class);

    private CourseRepository courseRepository;


    private static CourseServiceImpl instance;

    private CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public static CourseServiceImpl getInstance() {
        if (instance == null) {
            instance = new CourseServiceImpl(CourseRepositoryImpl.getInstance());
        }
        return instance;
    }
    @Override
    public Optional<Course> findByName(String name) {
        log.debug("Find course by name " + name);
        return courseRepository.findByName(name);
    }

    @Override
    public Integer findIdByName(String name) {
        log.debug("Find course id by name " + name);
        return courseRepository.findIdByName(name);
    }

    @Override
    public void save(Course course) {
        log.debug("Save new course " + course);
        courseRepository.save(course);
    }

    @Override
    public void update(Course course) {

    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Optional<Course> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
