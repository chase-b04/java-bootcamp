import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        // TODO: declare List<String> books as new ArrayList<>()
        List<String> books = new ArrayList<String>();

        // TODO: add four titles — include "Java Fundamentals" twice (duplicate allowed)
        //   "Java Fundamentals", "Clean Code", "Effective Java", "Java Fundamentals"
        books.add("Java Fundamentals");
        books.add("Clean Code");
        books.add("Effective Java");
        books.add("Java Fundamentals");

        // TODO: replace the value at index 1 with "Clean Architecture"
        books.set(1, "Clean Architecture");

        // TODO: search — does books contain "Effective Java"?
        boolean found = books.contains("Effective Java");

        // TODO: remove the first "Java Fundamentals" only (not removeIf)
        books.remove(0);

        System.out.println(
                "Found Effective Java: " + found);
        System.out.println("Size: " + books.size());
        System.out.println(books.get(99));
        // TODO: print index and title for each element
        for (int i = 0; i < books.size(); i++) {
            System.out.printf(
                    "%d: %s%n", i, books.get(i));
        }
    }
}