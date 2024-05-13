package q03.baseClasses;

public class User {
    protected String firstName;
    protected String lastName;
    protected String nationality;
    protected Contract contract;

    public User(String firstName, String lastName, String nationality, Contract contract) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.contract = contract;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public User setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public Contract getContract() {
        return contract;
    }

    public User setContract(Contract contract) {
        this.contract = contract;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", contract=" + contract +
                '}';
    }
}
