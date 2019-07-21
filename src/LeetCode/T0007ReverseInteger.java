package LeetCode;

/**
 * Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * 题目：https://leetcode.com/problems/reverse-integer/submissions/
 *
 * 解法：就是翻转数字，运用取余，进位的做法
 */

public class T0007ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseInteger(-123));
    }

    private static int reverseInteger(int target) {
        int result = 0;
        while (target != 0) {
            if (Math.abs(result) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + target % 10;
            target = target / 10;
        }
        return result;

    }
}
