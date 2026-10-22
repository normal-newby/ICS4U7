package OOP;

public class Book {
    private String title;
    private String author;
    private int yearPublished;
    private boolean isAvailable;
    private static int bookCount;

    public Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        isAvailable = true;
        bookCount++;
    }

    public Book(){
        this("Unknown", "Unknown", 0);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public static int getBookCount() {
        return bookCount;
    }

    public void borrowBook() {
        if (isAvailable) isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString(){
        return "Title: " + title + ", Author: " + author + ", Publication Year: " + yearPublished + ", Availability: " + isAvailable;
    }
}
