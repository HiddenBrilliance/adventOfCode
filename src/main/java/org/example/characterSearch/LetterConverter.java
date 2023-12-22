package org.example.characterSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


import java.util.ArrayList;
import java.util.List;




public class LetterConverter {
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

    public LetterConverter(String filePath) {
    }

    public static Integer wordToDigit(String word) {
        return wordToDigitMap.get(word.toLowerCase());
    }


    //TODO: Currently the word bulder collects the first sequence that forms a key from my map but it squishes other characters together. May need to put method in a separate class
    public List<Integer> performCharacterSearch(String filePath) {
        List<Integer> concatenatedDigits = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/dub/Desktop/adventOfCode-2023/adventOfCodeTrebuchet/src/main/resources/testInput2forConversion.rtf"))) {
            String line;
            while ((line = br.readLine()) != null) {
                concatenatedDigits.addAll(processLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return concatenatedDigits;
    }

    private List<Integer> processLine(String line) {
        List<Integer> concatenatedDigits = new ArrayList<>();
        StringBuilder wordBuilder = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (Character.isLetter(ch)) {
                wordBuilder.append(ch);

                for (String word : wordToDigitMap.keySet()) {
                    if (wordBuilder.toString().toLowerCase().contains(word)) {
                        Integer digitFromWord = wordToDigit(word);
                        if (digitFromWord != null) {
                            concatenatedDigits.add(digitFromWord);
                            wordBuilder.setLength(0);
                            break;
                        }
                    }
                }
            }
        }

        if (wordBuilder.length() > 0) {
            String lastWord = wordBuilder.toString().toLowerCase();
            Integer lastDigit = wordToDigit(lastWord);
            if (lastDigit != null) {
                concatenatedDigits.add(lastDigit);
            }
        }

        return concatenatedDigits;
    }
}




