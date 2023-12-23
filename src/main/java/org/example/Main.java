package org.example;

import org.example.characterSearch.NumberDigitLogic;


public class Main {
    public static void main(String[] args) {
        String filePath = "/path/to/your/testInput2forConversion.rtf"; // Replace this with your file path




        // Using NonLetterDigits
        NumberDigitLogic numberDigitLogic = new NumberDigitLogic(filePath);
        String nonLetterDigitsString = numberDigitLogic.getNonLetterDigits(filePath);
        System.out.println("Non-Letter Digits: " + nonLetterDigitsString);
    }
}