package 剑指offer;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * 解题思路
 * 公式:
 * f(n) = n, n <= 1
 * f(n) = f(n-1) + f(n-2), n > 1
 * 可以直接使用递归的方法：
 *
 * if(n<=1) return n;
 * else return Fibonacci(n-1)+Fibonacci(n-2);
 * 递归的方法可能会遇到Stack Overflow，
 * 所以我们可以考虑用动态规划的方法来实现。
 * 采用自底向上方法来保存了先前计算的值，为后面的调用服务。
 */

public class T09Fibonacci {
    public static void main(String[] args) {
        System.out.println(getFibonacci(6));
    }

    private static int getFibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        int f1 = 0;
        int f2 = 1;
        for (int i = 2; i <= n;i++){
            f2 += f1;
            f1 = f2 - f1;
        }
        return f2;
    }
}
