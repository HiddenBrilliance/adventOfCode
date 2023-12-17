package org.example.c;

import org.example.characterSearch.CharacterSearch;

import java.util.List;

public class DigitSum {

    public int sumDigitsFromSearch(CharacterSearch characterSearch) {
        List<Character> digits = characterSearch.performCharacterSearch();
        int sum = 0;

        for (Character digit : digits) {
            if (Character.isDigit(digit)) {
                sum += Character.getNumericValue(digit);
            }
        }

        return sum;
    }
}