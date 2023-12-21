package org.example.characterSearch;
import org.example.data.InputStrings;

import java.util.*;


import java.util.ArrayList;
import java.util.List;




public class CharacterSearch {
    private static final Map<String, Integer> wordToDigitMap = new HashMap<>();

    static {
        wordToDigitMap.put("one", 1);
        wordToDigitMap.put("two", 2);
        wordToDigitMap.put("three", 3);
        wordToDigitMap.put("four", 4);
        wordToDigitMap.put("five", 5);
        wordToDigitMap.put("six", 6);
        wordToDigitMap.put("seven", 7);
        wordToDigitMap.put("eight", 8);
        wordToDigitMap.put("nine", 9);
    }

    public static Integer wordToDigit(String word) {
        return wordToDigitMap.get(word.toLowerCase());
    }


    //TODO: Currently the word bulder collects the first sequence that forms a key from my map but it squishes other characters together. May need to put method in a separate class

    public List<Integer> performCharacterSearch() {
        List<Integer> concatenatedDigits = new ArrayList<>();

        for (String str : InputStrings.readLinesFromFile("/Users/dub/Desktop/adventOfCode-2023/adventOfCodeTrebuchet/src/main/resources/testInput2forConversion.rtf")) {
            char firstDigit = '\0';
            char lastDigit = '\0';
            StringBuilder wordBuilder = new StringBuilder();

            for (int i = 0; i <= str.length(); i++) {
                char ch = (i < str.length()) ? str.charAt(i) : '\0';

                if (Character.isDigit(ch)) {
                    if (firstDigit == '\0') {
                        firstDigit = ch;
                    }
                    lastDigit = ch;
                } else if (Character.isLetter(ch)) {
                    wordBuilder.append(ch);

                    String word = wordBuilder.toString().toLowerCase();
                    Integer digitFromWord = wordToDigit(word);
                    if (digitFromWord != null) {
                        if (firstDigit == '\0') {
                            firstDigit = Character.forDigit(digitFromWord, 10);
                        }
                        lastDigit = Character.forDigit(digitFromWord, 10);
                        wordBuilder.setLength(0);
                    }
                } else {

                    wordBuilder.setLength(0);
                }
            }

            if (firstDigit != '\0' || lastDigit != '\0') {
                int concatenatedDigit = (firstDigit != '\0') ? Character.getNumericValue(firstDigit) * 10 : 0;
                concatenatedDigit += (lastDigit != '\0') ? Character.getNumericValue(lastDigit) : 0;
                concatenatedDigits.add(concatenatedDigit);
            }
        }

        return concatenatedDigits;
    }
}




