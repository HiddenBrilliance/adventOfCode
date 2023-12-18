package org.example.sum;

import org.example.characterSearch.CharacterSearch;

import java.util.List;

public class DigitSum {

    public int sumDigitsFromSearch(CharacterSearch characterSearch) {
        List<Integer> concatenatedDigits = characterSearch.performCharacterSearch();
        int sum = 0;

        for (Integer concatenatedDigit : concatenatedDigits) {

                sum += concatenatedDigit; // Add the concatenated digit directly

        }

        return sum;
    }
}