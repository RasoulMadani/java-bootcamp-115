package q02;

public class Address {
    int id;
    String city;
    String street;

    int plaque;

    public Address(int id, String city, String street, int plaque) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.plaque = plaque;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", plaque=" + plaque +
                '}';
    }
}
