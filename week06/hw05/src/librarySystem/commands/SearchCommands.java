package librarySystem.commands;


import librarySystem.*;

import java.util.Scanner;

public class SearchCommands {
    Scanner scanner;
    Library library;

    public SearchCommands(Scanner scanner, Library library) {
        this.scanner = scanner;
        this.library = library;
    }

    public void runCommand() {
        System.out.println("Enter \"writer\" or \"book_writer\" or \"book\" ");
        String command = scanner.next();
        switch (command) {
            case "writer" -> {
                writer();
            }
            case "book_writer" -> {
                book_writer();
            }
            case "book" -> {
                book();
            }

        }
    }

    public void writer() {
        System.out.println("Enter writer last name :");
        String lastName = scanner.next();
        Writer[] writers = library.getWriters();
        for (Writer writer : writers) {
            if (writer != null) {
                if (writer.getLastName().contains(lastName)) {
                    System.out.println(writer);
                }
            }
        }
    }

    public void book() {
        System.out.println("Enter book name :");
        String name = scanner.next();
        Book[] books = library.getBooks();
        for (Book book : books) {
            if (book != null) {
                if (book.getName().contains(name)) {
                    System.out.println(book);
                }
            }
        }
    }

    public void book_writer() {
        System.out.println("Enter writer first name :");
        String firstName = scanner.next();
        System.out.println("Enter writer last name :");
        String lastName = scanner.next();
        Book[] books = library.getBooks();
        for (Book book : books) {
            if (book != null) {
                if (book.getWriter().getFirstName().equals(firstName) &&
                        book.getWriter().getLastName().equals(lastName)
                ) {
                    System.out.println(book);
                }
            }
        }
    }


}
