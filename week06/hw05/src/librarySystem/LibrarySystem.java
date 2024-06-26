package librarySystem;

import librarySystem.commands.AddCommands;
import librarySystem.commands.BorrowCommands;
import librarySystem.commands.SearchCommands;

import java.util.Scanner;

public class LibrarySystem {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter your Library name : ");
        String nameLibrary = scanner.next();
        Library library = new Library(nameLibrary);

//        Writer writer = writerGenerator();
        while (true) {
            System.out.println("Enter \"add\" or \"search\" or \"borrow\"");
            String command = scanner.next();
            switch (command) {
                case "add" -> {
                    AddCommands addCommands = new AddCommands(scanner,library);
                    addCommands.runCommand();
                }
                case "borrow" ->{
                    BorrowCommands borrowCommands = new BorrowCommands(scanner,library);
                    borrowCommands.runCommand();
                }
                case "search" ->{
                    SearchCommands searchCommands = new SearchCommands(scanner,library);
                    searchCommands.runCommand();
                }
                case "test"->{
                    System.out.println();
//                    Duration.ofDays(DAYS.between(LocalDate.now(), secondDate));
//                    double daysBetween = Duration.between(LocalDate.now(), LocalDate.now().minusDays(7)).toDays();
//                    System.out.println(daysBetween);
                }
            }
        }
    }
}
