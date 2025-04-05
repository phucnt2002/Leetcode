package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (!stack.isEmpty() && stack.peek() == map.get(s.charAt(i))) {
                    stack.pop();
                }else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "[]";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(str));
    }
}
