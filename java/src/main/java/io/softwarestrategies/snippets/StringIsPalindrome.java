package io.softwarestrategies.snippets;

/**
 * Test whether a string is a palindrome or not
 */
public class StringIsPalindrome {

    public static void main(String[] args) {
        StringIsPalindrome app = new StringIsPalindrome();

        // Test True condition
        if (!app.isPalindrome("abcba")) {
            throw new RuntimeException("Result should have been true");
        }

        // Test False condition
        if (app.isPalindrome("abcde")) {
            throw new RuntimeException("Result should have been false");
        }

        System.out.println("Success!!!");
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
