package 剑指offer;

/**
 * 用两个栈实现队列
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 两个栈 stack1 和 stack2:
 * push 动作都在 stack1 中进行，
 * pop 动作在 stack2 中进行。当 stack2 不为空时，直接 pop，当 stack2 为空时，先把 stack1 中的元素 pop 出来，push 到 stack2 中，再从 stack2 中 pop 元素。
 */

import java.util.Stack;

public class T07TwoStackInQueue {

    public static void main(String[] args) {

    }

    static Stack<Integer> pushStack = new Stack<>();
    static Stack<Integer> popStack = new Stack<>();

    private static void push(int pushInt) {
        pushStack.push(pushInt);
    }

    private static int pop() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

}
