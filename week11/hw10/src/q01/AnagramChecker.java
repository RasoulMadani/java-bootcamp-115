package q01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramChecker {

    // Recursive method to generate all possible combinations
    private static void generateCombinations(String prefix, String str, HashMap<String, Boolean> map) {
        int n = str.length();
        if (n == 0) {
            map.put(prefix, true);
        } else {
            for (int i = 0; i < n; i++) {
                generateCombinations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), map);
            }
        }
    }

    // Method to create a frequency map of characters in a word
    private static HashMap<Character, Integer> getCharFrequencyMap(String word) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }

    // Method to check if two words are anagrams
    private static boolean areAnagrams(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character, Integer> word1Map = getCharFrequencyMap(word1);
        HashMap<Character, Integer> word2Map = getCharFrequencyMap(word2);
        return word1Map.equals(word2Map);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part a: Generate all combinations of a word
        System.out.println("Enter a word to generate all combinations:");
        String inputWord = scanner.nextLine();
        HashMap<String, Boolean> combinationsMap = new HashMap<>();
        generateCombinations("", inputWord, combinationsMap);
        System.out.println("All possible combinations:");
        for (String combination : combinationsMap.keySet()) {
            System.out.println(combination);
        }

        // Part b: Check if two words are anagrams
        System.out.println("Enter the first word:");
        String word1 = scanner.nextLine();
        System.out.println("Enter the second word:");
        String word2 = scanner.nextLine();
        if (areAnagrams(word1, word2)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        scanner.close();
    }
}

