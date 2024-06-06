package q01.commonClasses;

public class IdGenerator {
    public  static int generator(){
        return (int)(Math.random() * (10000 - 1000 + 1)) + 1000;
    }
}
