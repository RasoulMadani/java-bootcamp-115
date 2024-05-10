package q01;

public class Branch {
    Customer[] customers = new Customer[10];
    private int code;
    private String city;
    private int level;

    public Branch(int code, String city, int level) {
        this.code = code;
        this.city = city;
        this.level = level;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
