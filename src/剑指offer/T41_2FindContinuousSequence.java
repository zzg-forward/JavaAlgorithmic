package 剑指offer;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 *
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 解题思路
 * 滑动窗口的方法：用两个数字 start 和 end 分别表示序列的最小值和最大值，首先将 start 初始化为1，end 初始化为2。如果从start到end的和大于sum，我们就从序列中去掉较小的值(即增大start),
 * 相反，只需要增大end。
 * 终止条件为：一直增加begin到(1+sum)/2并且end小于sum为止
 *
 * 滑动窗口？
 *
 */

public class T41_2FindContinuousSequence {
    public static void main(String[] args) {
        System.out.println(leftRotateString(" abcXYZdef", 3));
    }

    //T42 左旋转字符串
    public static String leftRotateString (String str, int n) {
        int len = str.length();
        if (len == 0) {
            return "";
        }
        n = n % len;
        String s1 = str.substring(n, len);
        String s2 = str.substring(0, n);
        return s1 + s2;
    }

    public static ArrayList<ArrayList<Integer>> findContinuousSequence (int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3) {
            return result;
        }
        int start = 1, end = 2, mid = (1 + sum) / 2;
        while (start < mid && end < sum) {
            int s = totalSum(start, end);
            if (s == sum) {
                result.add(getSequence(start, end));
            } else if (s > sum) {
                start++;
            } else {
                end++;
            }
        }
        return result;
    }

    private static int totalSum(int start, int end) {
        int sum = 0;
        for (int i = start;i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    private static ArrayList<Integer> getSequence(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start;i <= end;i++) {
            result.add(i);
        }
        return result;
    }

}
