package 左程云算法题.chapter1;

import java.util.Stack;

/**
 * p13
 * 用一个栈去排序另一个栈
 */
public class SortStack {

    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty() && cur > help.peek()){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args){
        Stack<Integer> stackArr = new Stack<>();
        int[] testArr = new int[]{66,6,1,2,88,3,4,5};
        for (int i = 0; i < testArr.length;i++)
            stackArr.push(testArr[i]);
        SortStack.sortStackByStack(stackArr);
        while(!stackArr.isEmpty())
            System.out.println(stackArr.pop());
    }

}
