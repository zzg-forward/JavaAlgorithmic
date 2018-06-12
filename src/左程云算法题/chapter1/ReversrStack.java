package 左程云算法题.chapter1;

import java.util.Stack;

/**
 * 仅使用递归函数和栈操作逆序一个栈
 */
public class ReversrStack {
    // 递归获取栈的最底数值
    public int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty())
            return result;
        else{
            int last = getAndRemoveLastElement(stack);
            stack.push(last);
            return last;
        }
    }

    // 递归反转栈（获取到的数值递归的填入到栈中）
    public void reverseStack(Stack<Integer> stack){
        if (stack.isEmpty())
            return;
        else{
            int last = getAndRemoveLastElement(stack);
            reverseStack(stack);
            stack.push(last);
        }
    }

    //for test
    public static void main(String[] args){
        Stack<Integer> stackArr = new Stack<Integer>();
        int[] testArr = new int[]{1,2,3,4,5};
        for (int i = 0; i < testArr.length;i++)
            stackArr.push(testArr[i]);
        ReversrStack stacker = new ReversrStack();
        stacker.reverseStack(stackArr);
        System.out.println(stackArr.peek());
    }
}
