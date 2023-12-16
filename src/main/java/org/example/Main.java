package org.example;

import org.example.data.InputStrings;


// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        InputStrings calibrator = new InputStrings();
        String[] result = calibrator.getInputStringArray();
        // Use the 'result' array or perform other operations here
        System.out.println(result);
    }
}

