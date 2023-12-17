package org.example;

import org.example.characterSearch.CharacterSearch;


public class Main {
    public static void main(String[] args) {
        CharacterSearch characterSearch = new CharacterSearch();
        org.example.c.DigitSum digitSummation = new org.example.c.DigitSum();


        int sumOfDigits = digitSummation.sumDigitsFromSearch(characterSearch);
        System.out.println("Sum of digits: " + sumOfDigits);
    }
}