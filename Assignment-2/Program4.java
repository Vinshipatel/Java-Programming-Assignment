import java.util.*;

class Book implements Comparable<Book> {
    int id;
    String name;
    double price;

    Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int compareTo(Book b) {
        return this.name.compareTo(b.name);
    }

    public String toString() {
        return id + " " + name + " " + price;
    }
}

class PriceComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        return Double.compare(b1.price, b2.price);
    }
}

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            books.add(new Book(id, name, price));
        }

        Collections.sort(books);

        System.out.println("\nSorted by Name:");
        for (Book b : books)
            System.out.println(b);

        Collections.sort(books, new PriceComparator());

        System.out.println("\nSorted by Price:");
        for (Book b : books)
            System.out.println(b);
    }
}