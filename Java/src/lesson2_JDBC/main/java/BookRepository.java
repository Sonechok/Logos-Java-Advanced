import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private Connection connection;

    public BookRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Book> findByRangeOfPrice(int min, int max){
        List<Book> arrayOfBooks = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM library.book WHERE Price BETWEEN ? and ?")) {
            preparedStatement.setInt(1, min);
            preparedStatement.setInt(2, max);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                arrayOfBooks.add(mapToBook(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayOfBooks;
    }

    private Book mapToBook(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nameOfBook = resultSet.getString("nameOfBook");
        String description = resultSet.getString("description");
        String category = resultSet.getString("category");
        String isbn = resultSet.getString("isbn");
        int price = resultSet.getInt("Price");
        return new Book(id, nameOfBook, description, category, isbn, price);
    }
}
