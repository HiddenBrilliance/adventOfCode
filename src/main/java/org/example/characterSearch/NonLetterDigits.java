package org.example.characterSearch;

public class NonLetterDigits {

    public NonLetterDigits(String filePath) {
    }

    public String getNonLetterDigits(String inputString) {
            StringBuilder result = new StringBuilder();

            char firstDigit = '\0';
            char lastDigit = '\0';
            boolean digitFound = false;

            for (int i = 0; i < inputString.length(); i++) {
                char ch = inputString.charAt(i);

                if (Character.isDigit(ch)) {
                    if (!digitFound) {
                        firstDigit = ch;
                        digitFound = true;
                    }
                    lastDigit = ch;
                }
            }

            if (!digitFound) {
                // If no digit found, concatenate the first digit again to itself
                result.append(firstDigit != '\0' ? firstDigit : '0');
                result.append(firstDigit != '\0' ? lastDigit : "");
            } else {
                // If digits found, concatenate the last digit
                result.append(lastDigit);
            }

            return result.toString();
        }
    }

