package q02;

import java.util.Arrays;

public class Sequence {
    private char[] chars;



    public char[] getChars() {
        return chars;
    }
    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public void concat(Sequence sequence) {
        char[] chars1 = new char[chars.length + sequence.getChars().length];
        for (int i = 0; i < chars.length; i++) {
            chars1[i] = chars[i];
        }
        for (int i = chars.length,k=0; i < chars1.length; i++,k++) {
            chars1[i] = sequence.getChars()[k];
        }
        chars = chars1;
    }

    public int indexOf(char character) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == character)
                return i;
        }
        return -1;
    }

    public boolean equals(Sequence sequence) {
        if (sequence.getChars().length != chars.length)
            return false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != sequence.getChars()[i])
                return false;
        }
        return true;
    }

    public void replace(Sequence oldChars, Sequence newChars) {
        int counter;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == oldChars.getChars()[0]) {
                counter = 1;
                for (int j = 1, k = i + 1; j < oldChars.getChars().length; j++, k++) {
                    if (oldChars.getChars()[j] == chars[k]) {
                        counter++;
                        System.out.println(oldChars.getChars()[j] + " " + counter);
                    }
                }
                if (counter == oldChars.getChars().length){
                    System.out.println("allah");
                    for (int j = 0,k = i; j < newChars.getChars().length; j++,k++) {
                        chars[k] = newChars.getChars()[j];
                    }
                    System.out.println(chars);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "chars=" + Arrays.toString(chars) +
                '}';
    }
}
