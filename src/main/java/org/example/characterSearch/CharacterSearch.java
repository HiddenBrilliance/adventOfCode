package org.example.characterSearch;
import org.example.data.InputStrings;

import java.util.ArrayList;
import java.util.List;


public class CharacterSearch {

    public List<Integer> performCharacterSearch() {
        List<Integer> concatenatedDigits = new ArrayList<>();

        for (String str : InputStrings.readLinesFromFile("/Users/dub/Desktop/adventOfCode-2023/adventOfCodeTrebuchet/src/main/resources/input.text")) {
            char firstDigit = '\0';
            char lastDigit = '\0';

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (Character.isDigit(ch)) {
                    if (firstDigit == '\0') {
                        firstDigit = ch;
                    }
                    lastDigit = ch;
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
    }
}