package librarySystem.commands;


import librarySystem.*;
import librarySystem.publicCalsses.IdGenerator;

import java.time.LocalDate;
import java.util.Scanner;

public class BorrowCommands {
    Scanner scanner;
    Library library;

    public BorrowCommands(Scanner scanner, Library library) {
        this.scanner = scanner;
        this.library = library;
    }

    public void runCommand() {
        System.out.println("Enter \"create\" or \"add\" or \"remove\" or \"canGetBook\" ");
        String command = scanner.next();
        switch (command) {
            case "create" -> {
                createBorrow();
            }
            case "add" -> {
                addItems();
            }
            case "remove" -> {
                removeItem();
            }
            case "canGetBook" -> {
                canGetBook();
            }

        }
    }

    public void createBorrow() {
        int id = new IdGenerator().generator();
        System.out.println("Enter member id : ");
        int memberId = scanner.nextInt();
        Member member = library.getMember(memberId);
        Borrow borrow = new Borrow(id, member);
        library.addBorrow(borrow);
        System.out.println(library);
    }

    public void addItems() {
        System.out.println("Enter your borrow id : ");
        int borrowId = scanner.nextInt();
        Borrow borrow = library.getBorrow(borrowId);
        System.out.println("Enter book id : ");
        int bookId = scanner.nextInt();
        Book book = library.getBook(bookId);
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            book.setDate_borrowed(LocalDate.now().minusDays(10));
            borrow.addItem(book);
            System.out.println(library);
        } else {
            System.out.println("book is borrowed");
        }
    }

    public void removeItem() {
        System.out.println("Enter your Borrow Id : ");
        int borrowId = scanner.nextInt();
        Borrow borrow = library.getBorrow(borrowId);
        System.out.println("Enter your Book Id : ");
        int bookId = scanner.nextInt();
        Book[] items = borrow.getItems();
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                if (items[i].getId() == bookId) {
                    double penalty = items[i].penalty();
                    System.out.println("your penalty is : " + penalty);
                    items[i] = null;
                }
            }
        }


    }

    public void canGetBook() {
        System.out.println("Enter book name :");
        String name = scanner.next();
        Book[] books = library.getBooks();
        System.out.println("Enter member id : ");
        int memberId = scanner.nextInt();
        Borrow[] borrows = library.getBorrows();
        boolean countBorrow = false;
        for (Borrow borrow1 : borrows) {
            if (borrow1 != null) {
                if (borrow1.getMember().getId() == memberId) {
                    if (borrow1.getIndexItems() < 1) {
                        countBorrow = true;
                        break;
                    }

                }
            }
        }
        boolean availableBook = false;
        for (Book book : books) {
            if (book != null) {
                if (book.getName().equals(name) && !book.isBorrowed()) {
                    availableBook = true;
                    break;
                }
            }
        }
        if (countBorrow && availableBook) {
            System.out.println("you can get this book .");
        }
    }

}
