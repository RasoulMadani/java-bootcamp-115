package ir.maktabsharif.entity;

public class Bank extends BaseEntity{
    public static final String TABLE_NAME = "banks";
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public Bank(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                " id='" + getId() + '\'' +
                " name='" + name + '\'' +
                '}';
    }
}
