import java.util.ArrayList;
import java.util.Scanner;

class Book{
    String title;
    String author;
    boolean isIssued=false;

    Book(String title, String author){
        this.title=title;
        this.author=author;
    }
}

class Library{
    ArrayList<Book> books = new ArrayList<>();

    void addBook(String title, String author){
        books.add(new Book(title, author));
        System.out.println("Book added: " + title);
    }
    void issueBook(String title){
        for(Book b : books){
            if(b.title.equalsIgnoreCase(title) && b.isIssued){
                b.isIssued=true;
                System.out.println("Book Issued: " + title);
                return;
            }
        }System.out.println("Book not Available!");
    }
    void returnBook(String title){
        for(Book b : books){
            if(b.title.equalsIgnoreCase(title) && b.isIssued){
                b.isIssued=false;
                System.out.println("Book Issued: " + title);
                return;
            }
        }System.out.println("Invalid return attempt!");
    }
    void showBooks() {
        System.out.println("\nAvailable Books:");
        for (Book b : books) {
            String status = b.isIssued ? "Issued" : "Available";
            System.out.println(b.title + " by " + b.author + " [" + status + "]");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add Book\n2. Issue Book\n3. Return Book\n4. View Books\n5. Exit");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    lib.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter title to issue: ");
                    lib.issueBook(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter title to return: ");
                    lib.returnBook(sc.nextLine());
                    break;
                case 4:
                    lib.showBooks();
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}