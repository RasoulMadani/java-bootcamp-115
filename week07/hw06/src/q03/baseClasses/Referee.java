package q03.baseClasses;

public class Referee  extends User{
    String level;

    public Referee(String firstName, String lastName, String nationality, Contract contract, String level) {
        super(firstName, lastName, nationality, contract);
        this.level = level;
    }
}
