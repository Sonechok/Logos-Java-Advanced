import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class MainLesson2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = ConnectionManager.createConnection();
        BookRepository bookRepository = new BookRepository(connection);
        AuthorRepository authorRepository = new AuthorRepository(connection);
        String email;
        int min;
        int max;
        System.out.println("Enter email address of author you want to find");
        email = scanner.nextLine();
        Author author = authorRepository.findByEmail(email);
        if (author == null){
            System.out.println("There is no such author with this email");
        } else {
            System.out.println(author);
        }
        System.out.println("Enter min price of books you want to get");
        min = scanner.nextInt();
        System.out.println("Enter max price of books you want to get");
        max = scanner.nextInt();
        List<Book> books = bookRepository.findByRangeOfPrice(min, max);
        if (books.isEmpty()){
            System.out.println("List is empty");
        } else {
            System.out.println(books);
        }
    }
}