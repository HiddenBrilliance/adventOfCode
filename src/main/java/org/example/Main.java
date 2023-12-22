package org.example;

import org.example.characterSearch.LetterConverter;
import org.example.characterSearch.NonLetterDigits;


public class Main {
    public static void main(String[] args) {
        String filePath = "/path/to/your/testInput2forConversion.rtf"; // Replace this with your file path




        // Using NonLetterDigits
        NonLetterDigits nonLetterDigits = new NonLetterDigits(filePath);
        String nonLetterDigitsString = nonLetterDigits.getNonLetterDigits(filePath);
        System.out.println("Non-Letter Digits: " + nonLetterDigitsString);
    }
}