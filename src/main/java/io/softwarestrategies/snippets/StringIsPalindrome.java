package io.softwarestrategies.snippets;

/**
 * Test whether a string is a palindrome or not
 */
public class StringIsPalindrome {

    public static void main(String[] args) {
        StringIsPalindrome app = new StringIsPalindrome();

        // Test True condition
        boolean result = app.isPalindrome("abcba");
        if (result != true) {
            throw new RuntimeException("Result should have been true");
        }

        // Test False condition
        result = app.isPalindrome("abcde");
        if (result != false) {
            throw new RuntimeException("Result should have been false");
        }
    }

    public boolean isPalindrome(String word) {
        int iterations = word.length() / 2;
        int length = word.length();
        for (int count = 0; count < iterations; count++) {
            if (word.charAt(count) != word.charAt(length - 1 - count)) {
                return false;
            }
        }
        return true;
    }
}
