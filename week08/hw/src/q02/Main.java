package q02;

public class Main {
    public static void main(String[] args) {
        char[] chas1 = {'h','e','i','i','o','i','i','i'};
        char[] chars2 = {' ','w','o','r','l','d'};
        char[] chas3 = {'a','l','l','a','h','1'};

        Sequence words1 = new Sequence();
        words1.setChars(chas1);
        Sequence words2 = new Sequence();
        words2.setChars(chars2);
        Sequence newWord = new Sequence();
        newWord.setChars(chas3);
        System.out.println(words1);
        System.out.println(words2);
        int indexOfChar = words1.indexOf('e');
        System.out.println("index of char is : " + indexOfChar);
        words1.concat(words2);

        System.out.println(words1);
        Sequence rep1 = new Sequence();

        System.out.println(words1);
        System.out.println(newWord);
        System.out.println(words2);
        words1.replace(words2,newWord);
        System.out.println(words1);
        Sequence words3 = new Sequence();
        words3.setChars(chars2);

        System.out.println(words1.equals(words3));
        System.out.println(words2.equals(words3));

    }
}
