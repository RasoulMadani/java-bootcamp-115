package q02.commands;


import q02.*;
import q02.publicCalsses.IdGenerator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class AddCommands {
    Scanner scanner;
    Library library;

    public AddCommands(Scanner scanner, Library library) {
        this.scanner = scanner;
        this.library = library;
    }

    public void runCommand() {
        System.out.println("Enter \"member\" or \"book\" or \"writer\" or \"publisher\" ");
        String command = scanner.next();
        switch (command) {
            case "member" -> {
                addMember();
            }
            case "book" -> {
                addBook();
            }
            case "publisher" -> {
                addPublisher();
            }
            case "writer" -> {
                addWriter();
            }
        }
    }

    public  void addMember(){
        IdGenerator idGenerator = new IdGenerator();
        int idAddress = idGenerator.generator();
        int idMember = idGenerator.generator();
        System.out.println("Enter member name : ");
        String name = scanner.next();
        System.out.println("Enter city : ");
        String city = scanner.next();
        System.out.println("Enter street : ");
        String street = scanner.next();
        System.out.println("Enter plaque : ");
        int plaque = scanner.nextInt();
        Address address = new Address(idAddress,city,street,plaque);
        Member member = new Member(idMember,name,address);
        library.addMember(member);
        System.out.println(library);
    }

    public void addBook() {
        int id = new IdGenerator().generator();
        System.out.println("Enter name book : ");
        String name = scanner.next();
        System.out.println("Enter subject book : ");
        String subject = scanner.next();
        System.out.println("Enter year published book : ");
        LocalDate yearPublished = LocalDate.parse(scanner.next());

        System.out.println("Enter id of writer : ");
        int idWriter = scanner.nextInt();
        Writer writer = library.getWriter(idWriter);
        System.out.println("Enter id of publisher : ");
        int idPublisher = scanner.nextInt();
        Publisher publisher = library.getPublisher(idPublisher);
        Book book = new Book(id,name,subject,yearPublished,publisher,writer);
        library.addBook(book);
        System.out.println(library);
    }

    public void addPublisher() {
        int id = new IdGenerator().generator();
        System.out.println("Enter publisher name : ");
        String name = scanner.next();
        Publisher publisher = new Publisher(id, name);
        library.addPublisher(publisher);
        System.out.println(library);
    }

    public void addWriter() {
        int id = new IdGenerator().generator();
        System.out.println("enter fist name : ");
        String firstName = scanner.next();
        System.out.println("Enter last name : ");
        String lastName = scanner.next();
        System.out.println("Enter birth date : e.x 1980-01-03");
        String date = scanner.next();
        LocalDate dateOfBirth = LocalDate.parse(date);
        System.out.println("Enter email : ");
        String email = scanner.next();
        Writer writer = new Writer(id, firstName, lastName, dateOfBirth, email);
        library.addWriter(writer);
        System.out.println(library);

    }
}
