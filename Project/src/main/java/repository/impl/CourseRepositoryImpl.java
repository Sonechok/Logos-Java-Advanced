package repository.impl;

import config.ConnectionManager;
import entity.Course;
import entity.User;
import org.apache.log4j.Logger;
import repository.CourseRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class CourseRepositoryImpl implements CourseRepository{
    private static final Logger log = Logger.getLogger(CourseRepositoryImpl.class);

    private static CourseRepositoryImpl instance;

    private Connection connection;

    private CourseRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public static CourseRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CourseRepositoryImpl(ConnectionManager.createConnection());
        }
        return instance;
    }

    private Course mapToCourse(ResultSet resultSet) throws SQLException {
        Course course = new Course();
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        BigDecimal price = resultSet.getBigDecimal("price");
        course.setDescription(description);
        course.setName(name);
        course.setId(id);
        course.setPrice(price);
        return course;
    }

    private Integer mapToId(ResultSet resultSet) throws SQLException {
        return resultSet.getInt("id");
    }

    @Override
    public void save(Course course) {
        try (PreparedStatement statement = connection.prepareStatement(
                "insert into courses ( name, description, price) value (?, ?, ?)")) {
            statement.setString(1, course.getName());
            statement.setString(2, course.getDescription());
            statement.setBigDecimal(3, course.getPrice());
            statement.execute();
        } catch (SQLException e) {
            log.error("Error while saving course" + course, e);
        }
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

    @Override
    public Optional<Course> findByName(String name) {
        Course course = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("select * from courses where name = ?");
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            resultSet.next();
            course = mapToCourse(resultSet);
        } catch (SQLException e) {
            log.error("Error while getting course by name: " + name, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return Optional.ofNullable(course);
    }

    @Override
    public Integer findIdByName(String name) {
        Integer id = null;
        Course course = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("select id from courses where name = ?");
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            resultSet.next();
            id = mapToId(resultSet);
        } catch (SQLException e) {
            log.error("Error while getting course id by name: " + name, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return id;
    }
}
