package repository.impl;

import config.ConnectionManager;
import entity.User;
import org.apache.log4j.Logger;
import repository.UserRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private static final Logger log = Logger.getLogger(UserRepositoryImpl.class);

    private static UserRepositoryImpl instance;

    private Connection connection;

    private UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public static UserRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl(ConnectionManager.createConnection());
        }
        return instance;
    }

    private User mapToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        Integer id = resultSet.getInt("id");
        String email = resultSet.getString("email");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String role = resultSet.getString("role");
        String password = resultSet.getString("password");
        BigDecimal amountOfMoney = resultSet.getBigDecimal("money");
        Integer course_id = resultSet.getInt("course_id");
        user.setId(id);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setRole(role);
        user.setAmountOfMoney(amountOfMoney);
        user.setCourseId(course_id);
        return user;
    }


    @Override
    public Optional<User> findByEmail(String email) {
        User user = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("select * from users where email = ?");
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            resultSet.next();
            user = mapToUser(resultSet);
        } catch (SQLException e) {
            log.error("Error while getting user by email: " + email, e);
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
        return Optional.ofNullable(user);
    }

    @Override
    public void save(User user) {
        try (PreparedStatement statement = connection.prepareStatement(
                "insert into users ( first_name , last_name , email , password , role , course , money ) value (?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole());
            if (user.getCourseId() == null){
                statement.setNull(6, Types.INTEGER);
            } else {
                statement.setInt(6, user.getCourseId());
            }
            statement.setBigDecimal(7, user.getAmountOfMoney());
            statement.execute();
        } catch (SQLException e) {
            log.error("Error while saving user" + user, e);
        }
    }

    @Override
    public void update(User user) {
        try (PreparedStatement statement = connection.prepareStatement(
                "update users set first_name =?, last_name=?, email=?, password=?, role=?, money=?, course_id=? where id =?")) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole());
            statement.setBigDecimal(6, user.getAmountOfMoney());
            statement.setInt(7, user.getCourseId());
            statement.setInt(8, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error while updating user " + user, e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from users");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                result.add(mapToUser(resultSet));
            }
        } catch (SQLException e) {
            log.error("Error while getting all users", e);
        }
        return result;
    }

    @Override
    public Optional<User> findById(Integer id) {
        User user = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("select * from users where id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            user = mapToUser(resultSet);
        } catch (SQLException e) {
            log.error("Error while getting user by id: " + id, e);
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
        return Optional.ofNullable(user);
    }

    @Override
    public void deleteById(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement("delete from users where id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error while deleting user by id: " + id, e);
        }
    }
}
