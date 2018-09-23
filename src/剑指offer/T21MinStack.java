package 剑指offer;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 用一个栈stack保存数据，用另外一个栈temp保存依次入栈最小的数
 * 比如，stack中依次入栈
 * 5, 3, 4, 10, 2, 12, 1, 8
 * 则temp依次入栈
 * 5, 3, 3，3, 2, 2, 1, 1
 *
 * 每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则用最小元素入栈。
 */

import java.util.Stack;

public class T21MinStack {
    public static void main(String[] args) {

    }

    static Stack<Integer> pushStack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    static int minInt = Integer.MAX_VALUE;

    private static void push(int pushInt){
        pushStack.push(pushInt);
        if (pushInt < minInt) {
            minStack.push(pushInt);
            minInt = pushInt;
        }else {
            minStack.push(minInt);
        }
    }

    private static int pop() {
        if (pushStack.isEmpty() && minStack.isEmpty()) {
            throw new RuntimeException("stack is empty.");
        }

        int result = pushStack.pop();
        minStack.pop();
        return result;

    }

    private static int peek(){
        if (pushStack.isEmpty() && minStack.isEmpty()) {
            throw new RuntimeException("stack is empty.");
        }
        return pushStack.peek();
    }

    private static int getMin(){
        if (pushStack.isEmpty() && minStack.isEmpty()) {
            throw new RuntimeException("stack is empty.");
        }
        return minStack.peek();
    }

}
