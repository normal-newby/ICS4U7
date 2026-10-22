package OOP;

import java.util.*;

public class Main {

    public static void main(String[] args){
        ArrayList<Book> library = new ArrayList<>();
        library.add(new Book("The Hobbit", "J.R.R Tolkien", 1937));
        library.add(new Book("Harry Potter", "J.K. Rowling", 1997));
        library.add(new Book("The Giver", "Lois Lowry", 1993));
        library.add(new Book("Animal Farm", "George Orwell", 1945));
        library.add(new Book("Dune", "Frank Herbert", 1965));

        int sz = library.size();
        for (int i = 0; i < sz; i++){
            System.out.println(library.get(i).toString());
        }

        System.out.println("Total number books: " + Book.getBookCount());

        for (Book book : library){
            if (book.getYearPublished() < 1960){
                book.borrowBook();
            }
        }

        System.out.println("Available books:");
        for (Book book : library){
            if (book.isAvailable()){
                System.out.println(book.toString());
            }
        }

        for (Book book : library){
            if (book.getTitle().equals("The Hobbit")){
                book.returnBook();
                break;
            }
        }

        for (Book book : library){
            System.out.println(book.toString());
        }
    }
}
