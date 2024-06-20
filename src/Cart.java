import java.util.ArrayList;

public class Cart {
    private static Cart instance;
    private ArrayList<Book> books;

    private Cart() {
        books = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public double getTotal() {
        double total = 0;
        for (Book book : books) {
            total += book.getPrice();
        }
        return total;
    }
}
