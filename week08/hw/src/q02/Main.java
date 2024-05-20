package q02;

public class Main {
    public static void main(String[] args) {
        char[] chas1 = {'h','e','i','i','o'};
        char[] chars2 = {' ','w','o','r','l','d'};
        Sequence words1 = new Sequence();
        words1.setChars(chas1);
        Sequence words2 = new Sequence();
        words2.setChars(chars2);
        System.out.println(words1);
        System.out.println(words2);
        int indexOfChar = words1.indexOf('e');
        System.out.println("index of char is : " + indexOfChar);
        words1.concat(words2);

        System.out.println(words1);
        Sequence rep1 = new Sequence();


        words1.replace(chas1,chars2);
        Sequence words3 = new Sequence();
        words3.setChars(chars2);

        System.out.println(words1.equals(words3));
        System.out.println(words2.equals(words3));

    }
}
