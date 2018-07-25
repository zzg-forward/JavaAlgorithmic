package 剑指offer;

/**
 * Java 用栈解决括号匹配问题
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StrMatch {

    private Map<Character, Character> pair = null;

    public StrMatch(){
        pair = new HashMap<Character, Character>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');
    }

    public boolean isMatch(String s){
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (pair.containsValue(c)){
                stack.push(c);
            } else if (pair.containsKey(c)) {
                if (stack.isEmpty()){
                    return false;
                }
                if (stack.peek() == pair.get(c)){
                    stack.pop();
                } else {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StrMatch judger = new StrMatch();
        System.out.println(judger.isMatch("(***)-[{-------}]")); //true
        System.out.println(judger.isMatch("(2+4)*a[5]")); //true
        System.out.println(judger.isMatch("({}[]]])")); //false
        System.out.println(judger.isMatch("())))")); //false
    }


}
