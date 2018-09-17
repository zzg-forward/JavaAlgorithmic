package Test.other;

/**
 * 波那契数列
 * https://www.cnblogs.com/gleesu/p/6751382.html
 */

public class Fibonacci {
    /**
     * 迭代计算波那契数列
     * @param n
     * @return
     */
    public static int fibonacciNew(int n){
        if (n <= 0){
            return 0;
        } else if (n <= 2){
            return 1;
        }else {
            int result = 1;
            int temp = 1;
            for (int i = 3;i <= n;i++){
                result += temp;
                temp = result - temp;
            }
            return result;
        }
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public static int jumpFloor(int target){
        int kinds = 0;
        if (target == 1)
            kinds = 1;
        else if (target == 2)
            kinds = 2;
        else {
            kinds = jumpFloor(target - 1) + jumpFloor(target - 2);
        }
        return kinds;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 数学归纳：2的n-1次方
     * @param target
     * @return
     */
    public static int jumpEver(int target){
        int result = 1;
        if (target <= 0)
            return 0;
        else if (target <= 1)
            return 1;
        else {
            for (int i = 1;i < target;i++)
                result *= 2;
            return result;
        }
    }

    public static void main(String[] args) {
//        System.out.println(fibonacciNew(8));
        System.out.println(jumpFloor(8));
    }
}
