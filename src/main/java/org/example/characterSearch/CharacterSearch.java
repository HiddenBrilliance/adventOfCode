package org.example.characterSearch;
import org.example.data.InputStrings;

import java.util.ArrayList;
import java.util.List;



import org.example.data.InputStrings;

import java.util.ArrayList;
import java.util.List;




public class CharacterSearch {

    // Include the WordToDigitConverter logic here

    private static String[] digitWords = {
            "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine"
    };

    private static String wordToDigit(String word) {
        for (int i = 0; i < digitWords.length; i++) {
            if (word.equalsIgnoreCase(digitWords[i])) {
                return Integer.toString(i + 1);
            }
        }
        return null;
    }

    // End of WordToDigitConverter logic

    public List<Integer> performCharacterSearch() {
        //TODO: if digitWord exist at beginning or end they can also be firstDigit or lastDigit
        List<Integer> concatenatedDigits = new ArrayList<>();

        for (String str : InputStrings.readLinesFromFile("/Users/dub/Desktop/adventOfCode-2023/adventOfCodeTrebuchet/src/main/resources/testInput2forConversion.rtf")) {

            char firstDigit = '\0';
            char lastDigit = '\0';

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (Character.isDigit(ch)) {
                    if (firstDigit == '\0') {
                        firstDigit = ch;
                    }
                    lastDigit = ch;
                } else if (Character.isLetter(ch)) {
                    String digitFromWord = wordToDigit(Character.toString(ch));
                    if (digitFromWord != null) {
                        if (firstDigit == '\0') {
                            firstDigit = digitFromWord.charAt(0);
                        }
                        lastDigit = digitFromWord.charAt(0);
                    }
                }
            }

            if (firstDigit != '\0') {
                if (lastDigit == '\0') {
                    concatenatedDigits.add(Character.getNumericValue(firstDigit) * 10 + Character.getNumericValue(firstDigit));
                } else {
                    concatenatedDigits.add(Character.getNumericValue(firstDigit) * 10 + Character.getNumericValue(lastDigit));
                }
            }
        }

        return concatenatedDigits;
    }}




