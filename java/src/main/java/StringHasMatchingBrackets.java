import java.util.Stack;

/**
 * Tests that in a string all opening brackets have matching (in number and type) brackets
 *
 * This was an programming test from an interview
 *
 * A pair of brackets is balanced if each opening bracket is accompanied by a closing bracket.  In the case of nested
 * brackets, the most recently opened bracket must be the first to be closed.
 *
 * The brackets consist of these characters:    (, ), {, } [, ], <, and >
 */
public class StringHasMatchingBrackets {

    public static void main(String[] args) {
        StringHasMatchingBrackets app = new StringHasMatchingBrackets();

        // Test True condition
        if (!app.hasBalancedBrackets("[](){}<>")) {
            throw new RuntimeException("Result should have been true");
        }

        // Test False condition
        if (app.hasBalancedBrackets("(h[e{lo}!]~)()()()(")) {
            throw new RuntimeException("Result should have been false");
        }

        System.out.println("Success!!!");
    }

    public boolean hasBalancedBrackets(String stringToCheck) {
        Stack<String> opens = new Stack<String>();
        Stack<String> closes = new Stack<String>();

        for (int count = 0; count < stringToCheck.length(); count++) {
            String character = stringToCheck.substring(count, count + 1);
            if ("(".equals(character) || "{".equals(character) || "[".equals(character) || "<".equals(character)) {
                opens.push(character);
            } else if (")".equals(character) || "}".equals(character) || "]".equals(character) || ">".equals(character)) {
                closes.push(character);
            }
        }

        if (opens.size() != closes.size()) {
            return false;
        }

        for (int count = opens.size() - 1; count > 0; count--) {
            String open = opens.get(count);
            String close = closes.get(count);
            if (open.equals("(") && !close.equals(")")) {
                return false;
            } else if (open.equals("{") && !close.equals("}")) {
                return false;
            } else if (open.equals("[") && !close.equals("]")) {
                return false;
            } else if (open.equals("<") && !close.equals(">")) {
                return false;
            }
        }

        return true;
    }
}
