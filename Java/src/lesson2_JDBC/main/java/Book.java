public class Book {
    private int id;
    private String nameOfBook;
    private String description;
    private String category;
    private String isbn;
    private int price;

    public Book(int id, String nameOfBook, String description, String category, String isbn, int price) {
        this.id = id;
        this.nameOfBook = nameOfBook;
        this.description = description;
        this.category = category;
        this.isbn = isbn;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameOfBook='" + nameOfBook + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                "}\n";
    }
}
