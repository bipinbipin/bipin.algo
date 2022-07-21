package bipin.cracking;

import java.util.HashMap;
import java.util.Map;

public class OneArraysStrings {


    public static void main(String[] args) {
//        oneDotOne_UniqueString();
        oneDotTwo_PermutationChecker();
    }

    static void oneDotTwo_PermutationChecker() {
        boolean permutation = false;
        String inputA = "abcffeaA";
        String inputB = "Abffecaa";
        Map<Character, Integer> letterMapA = mapLettersOfString(inputA);
        Map<Character, Integer> letterMapB = mapLettersOfString(inputB);
        if (letterMapA.equals(letterMapB)) {
            permutation = true;
        }
        System.out.println("StringA: " + inputA + "\tStringB: " + inputB + "\t\tPermutation:\t" + permutation);
    }

    static Map<Character, Integer> mapLettersOfString(String input) {
        Map<Character, Integer> letterMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);
            if (letterMap.containsKey(x)) {
                letterMap.put(x, letterMap.get(x)+1);
            } else {
                letterMap.put(input.charAt(i), 1);
            }
        }
        return letterMap;
    }


    static void oneDotOne_UniqueString() {
        boolean unique = true;
        String input = "abdef";
        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);
            String tmp = input.substring(i+1);
            if (tmp.indexOf(x) >= 0) {
                unique = false;
                continue;
            }
        }
        System.out.println("String:\t" + input + "\t\tUnique:\t" + unique);
    }
}
