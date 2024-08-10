package q02;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetExample {


    public static TreeSet<Character> generateRandomCharSet() {
        TreeSet<Character> charSet = new TreeSet<>();
        Random random = new Random();
        while (charSet.size() < 10) {
            char c = (char) (random.nextInt(26) + 'a');
            charSet.add(c);
        }
        return charSet;
    }


    public static TreeSet<Character> findUnion(TreeSet<Character> set1, TreeSet<Character> set2) {
        TreeSet<Character> unionSet = new TreeSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }


    public static TreeSet<Character> findIntersection(TreeSet<Character> set1, TreeSet<Character> set2) {
        TreeSet<Character> intersectionSet = new TreeSet<>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }

    public static void main(String[] args) {

        TreeSet<Character> set1 = generateRandomCharSet();
        TreeSet<Character> set2 = generateRandomCharSet();

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        TreeSet<Character> unionSet = findUnion(set1, set2);
        System.out.println("Union: " + unionSet);

        TreeSet<Character> intersectionSet = findIntersection(set1, set2);
        System.out.println("Intersection: " + intersectionSet);
    }
}
