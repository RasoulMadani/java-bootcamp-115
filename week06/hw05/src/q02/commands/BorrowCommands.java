package q02.commands;


import q02.*;
import q02.publicCalsses.IdGenerator;

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
        System.out.println("Enter \"create\" or \"add\" or \"remove\" ");
        String command = scanner.next();
        switch (command) {
            case "create" -> {
                createBorrow();
            }
            case "add" ->{
                addItems();
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
    public void addItems(){
        System.out.println("Enter your borrow id : ");
        int borrowId = scanner.nextInt();
        Borrow borrow = library.getBorrow(borrowId);
        System.out.println("Enter book id : ");
        int bookId = scanner.nextInt();
        Book book = library.getBook(bookId);
        if (!book.isBorrowed()){
            book.setBorrowed(true);
            book.setDate_borrowed(LocalDate.now());
            borrow.addItem(book);
            System.out.println(library);
        }else{
            System.out.println("book is borrowed");
        }
    }

}
