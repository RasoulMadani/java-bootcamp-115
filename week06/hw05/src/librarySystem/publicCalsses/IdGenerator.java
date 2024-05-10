package librarySystem.publicCalsses;

public class IdGenerator {
    public int generator(){
        return (int)(Math.random() * (10000 - 1000 + 1)) + 1000;
    }
}
