class Solution {
    public boolean isValid(String s) {
        String stack = "";

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack += ch;
            } else {
                if (stack.length() == 0)
                    return false;

                char top = stack.charAt(stack.length() - 1);

                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')) {

                    stack = stack.substring(0, stack.length() - 1);
                } else {
                    return false;
                }
            }
        }

        return stack.length() == 0;
    }
}