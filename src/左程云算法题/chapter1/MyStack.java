package 左程云算法题.chapter1;

import java.util.Stack;

/**
 * p2
 * 设计一个特殊的栈，有getMin功能的栈
 * （1）实现栈的功能；（2）实现返回栈中最小元素的功能
 */

public class MyStack{
    //test
    public static void main(String[] args){
        int[] intArr = new int[]{1,2,3,4,5,2};
        MyStack1 myStack = new MyStack1();
        MyStack2 myStack2 = new MyStack2();
        for(int i = 0;i < intArr.length;i++){
            myStack.push(intArr[i]);
            myStack2.push(intArr[i]);
        }
        System.out.println(myStack.getMin());
        System.out.println(myStack2.getMin());
    }
}

/**
 *方法一：用两个栈实现
 */
class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        this.stackData.push(newNum);
        if (this.stackMin.isEmpty() || newNum <= this.getMin())  //互斥
            this.stackMin.push(newNum);
    }

    public int pop(){
        if (this.stackData.isEmpty())
            throw new RuntimeException("Your stack is empty.");
        int value = this.stackData.pop();
        if (value == this.getMin())
            this.stackMin.pop();
        return value;
    }

    public int getMin(){
        if (this.stackMin.isEmpty())
            throw new RuntimeException("Your stack is empty.");
        return this.stackMin.peek();
    }
}

/**
 * 方法二：
 */
class MyStack2{
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2(){
        this.stackMin = new Stack<Integer>();
        this.stackData = new Stack<Integer>();
    }

    public void push(int newNum){
        this.stackData.push(newNum);
        if (this.stackMin.isEmpty())
            this.stackMin.push(newNum);
        else if (newNum > this.getMin()) {
            int target = this.getMin();
            this.stackMin.push(target);
        }
        else {
            this.stackMin.push(newNum);
        }
    }

    public int pop(){
        if (this.stackData.isEmpty())
            throw new RuntimeException("Your stack is empty.");
        else {
            this.stackMin.pop();
            return this.stackData.pop();
        }
    }

    public int getMin(){
        if (this.stackMin.isEmpty())
            throw new RuntimeException("Your stack is empty.");
        return this.stackMin.peek();
    }
}
