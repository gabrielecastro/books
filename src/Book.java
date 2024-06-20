import javax.swing.*;
import java.awt.*;

public class Book {
    private String title;
    private String author;
    private double price;
    private ImageIcon coverImage;
    private int rating;
    private String synopsis;

    public Book(String title, String author, double price, String coverImagePath, int rating, String synopsis) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.coverImage = new ImageIcon(new ImageIcon(coverImagePath).getImage().getScaledInstance(110, 160, Image.SCALE_SMOOTH));
        this.rating = rating;
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public ImageIcon getCoverImage() {
        return coverImage;
    }

    public int getRating() {
        return rating;
    }

    public String getSynopsis() {
        return synopsis;
    }
}
