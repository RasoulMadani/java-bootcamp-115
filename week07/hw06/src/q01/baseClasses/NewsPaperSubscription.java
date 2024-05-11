package q01.baseClasses;

abstract class NewsPaperSubscription {
    String name;
    String address;
    int rate;

    public String getName() {
        return name;
    }

    public abstract String setAddress(String  address);

    public int getRate() {
        return rate;
    }
}
