package io.softwarestrategies.snippets;

/**
 * Find all values in one array which are not present in another
 *
 * Coding challenge for interview:
 *
 * array1 = [a,b,c,d,e,f,g,s,t]
 * array2 = [a,b,b,d,f,g,s,z]
 *
 * answer = [c,e,t]
 */
public class FindAllValuesInOneArrayThatAreNotInTheOther {

    public static void main(String[] args) {
        char[] array1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 's', 't'};
        char[] array2 = {'a', 'b', 'b', 'd', 'f', 'g', 's', 'z'};

        FindAllValuesInOneArrayThatAreNotInTheOther app = new FindAllValuesInOneArrayThatAreNotInTheOther();

        String charsInFirstArrayThatAreNotInSecond = app.getCharsInFirstArrayThatAreNotInSecond(array1, array2);

        if (!"cet".equals(charsInFirstArrayThatAreNotInSecond)) {
            throw new RuntimeException("Result should have been true");
        }

        System.out.println("Success!!!");
    }

    private String getCharsInFirstArrayThatAreNotInSecond(char[] firstArray, char[] secondArray) {
        String result = "";
        for (char charToCheck : firstArray) {
            if (!charArrayContains(secondArray, charToCheck)) {
                result += charToCheck;
            }
        }
        return result;
    }

    private boolean charArrayContains(char[] theArray, char theChar) {
        for (char possible : theArray) {
            if (possible == theChar)
                return true;
        }
        return false;
    }
}
