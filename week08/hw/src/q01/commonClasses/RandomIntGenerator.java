package q01.commonClasses;

import java.util.Random;

public class RandomIntGenerator {
    public static int generator(){
        Random random = new Random();
        return random.nextInt(11);
    }
}
