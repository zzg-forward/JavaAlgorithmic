package 左程云算法题.chapter1;

import java.util.Stack;

/**
 * p5
 * 用两个栈组成的队列
 * 实现队列的add,poll,peek等方法
 */
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int newNum){
        stackPush.add(newNum);
    }

    public int poll(){
        if (stackPush.isEmpty() && stackPop.isEmpty())
            throw new RuntimeException("your queue is empty.");
        else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty())
                stackPop.add(stackPush.pop());
        }
        return stackPop.pop();

    }

    public int peek(){
        if (stackPush.isEmpty() && stackPop.isEmpty())
            throw new RuntimeException("your queue is empty.");
        else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty())
                stackPop.add(stackPush.pop());
        }
        return stackPop.peek();
    }

    //for test
    public static void main(String[] args){
        TwoStacksQueue stackQueue = new TwoStacksQueue();
        int[] testArr = new int[]{1,2,3,4,5};
        for (int i = 0; i < testArr.length;i++)
            stackQueue.add(testArr[i]);
        System.out.println(stackQueue.peek());
        System.out.println(stackQueue.poll());

    }

}
