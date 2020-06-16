import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AuthorRepository {
    private Connection connection;

    public AuthorRepository(Connection connection) {
        this.connection = connection;
    }

    public Author findByEmail(String email){
        Author author = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM library.author where author_email = ?")){
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            author = mapToAuthor(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    private Author mapToAuthor(ResultSet resultSet) throws SQLException {
        String firstName = resultSet.getString("author_first_name");
        String lastName = resultSet.getString("author_last_name");
        String email = resultSet.getString("author_email");
        String address = resultSet.getString("author_address");
        LocalDate dateOfBirth = (resultSet.getDate("authorDateOfBirthday")).toLocalDate();
        return new Author(firstName, lastName, email, address, dateOfBirth);
    }
}
