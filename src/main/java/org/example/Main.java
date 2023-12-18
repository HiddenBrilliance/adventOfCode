package org.example;

import org.example.characterSearch.CharacterSearch;
import org.example.sum.DigitSum;


public class Main {
    public static void main(String[] args) {
        CharacterSearch characterSearch = new CharacterSearch();
        DigitSum digitSummation = new DigitSum();


        int sumOfDigits = digitSummation.sumDigitsFromSearch(characterSearch);
        System.out.println("Sum of digits: " + sumOfDigits);
    }
}