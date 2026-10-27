package librarygraphtraversal;

import java.util.*;

// Node represents a Book in the Library
class Book {
    String title;
    List<Book> relatedBooks;

    public Book(String title) {
        this.title = title;
        this.relatedBooks = new ArrayList<>();
    }

    public void addRelatedBook(Book book) {
        relatedBooks.add(book);
    }
}

public class LibraryGraphTraversal {

    // Breadth-First Search (BFS)
    public static void BFS(Book startBook) {
        Set<Book> visited = new HashSet<>();
        Queue<Book> queue = new LinkedList<>();

        visited.add(startBook);
        queue.add(startBook);

        System.out.println("BFS Traversal (Recommended Books Order):");

        while (!queue.isEmpty()) {
            Book current = queue.poll();
            System.out.println(" -> " + current.title);

            for (Book related : current.relatedBooks) {
                if (!visited.contains(related)) {
                    visited.add(related);
                    queue.add(related);
                }
            }
        }
    }

    // Depth-First Search (DFS)
    public static void DFS(Book book, Set<Book> visited) {
        visited.add(book);
        System.out.println(" -> " + book.title);

        for (Book related : book.relatedBooks) {
            if (!visited.contains(related)) {
                DFS(related, visited);
            }
        }
    }

    public static void main(String[] args) {
        // Create sample book network (graph)
        Book b1 = new Book("Data Structures and Algorithms");
        Book b2 = new Book("Introduction to Java Programming");
        Book b3 = new Book("Algorithm Design Manual");
        Book b4 = new Book("Advanced Java Concepts");
        Book b5 = new Book("Research in Data Science");

        // Establish relationships (edges)
        b1.addRelatedBook(b2);
        b1.addRelatedBook(b3);
        b2.addRelatedBook(b4);
        b3.addRelatedBook(b5);
        b4.addRelatedBook(b5);

        // Run BFS
        BFS(b1);

        // Run DFS
        System.out.println("\nDFS Traversal (Deep Reference Exploration):");
        Set<Book> visited = new HashSet<>();
        DFS(b1, visited);
    }
}


