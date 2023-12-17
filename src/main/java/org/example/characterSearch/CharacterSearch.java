package org.example.characterSearch;
import org.example.data.InputStrings;

import java.util.ArrayList;
import java.util.List;

public class CharacterSearch {

    public List<Character> performCharacterSearch() {
        List<Character> digits = new ArrayList<>();

        for (String str : InputStrings.inputStringArray) {
            char firstDigit = '\0'; // Initialize as null character
            char lastDigit = '\0'; // Initialize as null character

            for (char ch : str.toCharArray()) {
                if (Character.isDigit(ch)) {
                    if (firstDigit == '\0') {
                        firstDigit = ch;
                    }
                    lastDigit = ch;
                }
            }

            // If lastDigit is still null and firstDigit isn't, use the same digit again
            if (lastDigit == '\0' && firstDigit != '\0') {
                lastDigit = firstDigit;
            }

            // If both digits are valid, concatenate them into a single numerical string
            if (firstDigit != '\0' && lastDigit != '\0') {
                String concatenatedDigits = String.valueOf(firstDigit) + String.valueOf(lastDigit);
                for (char digit : concatenatedDigits.toCharArray()) {
                    digits.add(digit);
                }
            }
        }

        return digits;
    }
}