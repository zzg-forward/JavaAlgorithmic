package 剑指offer;

/**
 * 不用加减乘除做加法
 *
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 解题思路
 * 用位运算来实现。
 *
 * step1: 进行异或运算，计算两个数各个位置上的相加，不考虑进位；
 * step2: 进行位与运算，然后左移一位，计算进位值；
 * step3: 把异或运算的结果赋给 num1，把进位值赋给 num2，依此循环，进位值为空的时候结束循环，num1就是两数之和。
 *
 */

public class T47AddNum {
    public static void main(String[] args) {

    }

    private static int addNum(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        int sum = 0, carry = 0;
        while (num2 != 0) {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

}
