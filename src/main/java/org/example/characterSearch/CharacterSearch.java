package org.example.characterSearch;
import org.example.data.InputStrings;

import java.util.ArrayList;
import java.util.List;


public class CharacterSearch {

    public List<Character> performCharacterSearch() {
        List<Character> digits = new ArrayList<>();

        for (String str : InputStrings.readLinesFromFile("/Users/dub/Desktop/adventOfCode-2023/adventOfCodeTrebuchet/src/main/resources/input.text")) {
            boolean foundFirstDigit = false;
            char foundSecondDigit = '\0'; // Initialize as null character
            int i = 0;

            while (i < str.length()) {
                char ch = str.charAt(i);
                if (Character.isDigit(ch)) {
                    if (!foundFirstDigit) {
                        digits.add(ch);
                        foundFirstDigit = true;
                    } else {
                        foundSecondDigit = ch; // Update foundSecondDigit for each subsequent digit
                    }
                }
                i++;
            }

            // If only one digit is found, add the first one again
            if (foundFirstDigit && foundSecondDigit == '\0' && digits.size() >= 2) {
                digits.add(digits.get(digits.size() - 2));
            } else if (foundFirstDigit && foundSecondDigit == '\0' && digits.size() == 1) {
                digits.add(digits.get(0)); // If there's only one digit, add it again
            } else if (foundSecondDigit != '\0') {
                digits.add(foundSecondDigit); // Add the last found digit as the second digit
            }
        }

        return digits;
    }
    }