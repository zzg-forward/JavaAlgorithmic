package 剑指offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 *
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 解题思路
 * 先将数组转换成字符串数组，然后对字符串数组按照规则排序，最后将排好序的字符串数组拼接出来。
 * 关键就是制定排序规则：
 *
 * 若ab > ba 则 a > b
 * 若ab < ba 则 a < b
 * 若ab = ba 则 a = b
 * 解释说明：
 * a = 21
 * b = 2
 * 因为 212 < 221, 即 ab < ba ，所以 a < b
 * 所以我们通过对ab和ba比较大小，来判断a在前或者b在前的。
 *
 * 其实就是运算符的重载，在java中，就是比较器
 */

public class T33PrintMinNumber {
    public static void main(String[] args) {
        System.out.println(printMinNumber(new int[]{3, 32, 321}));
    }

    public static String printMinNumber(int[] numbers) {
        int len = numbers.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return String.valueOf(numbers[0]);
        }

        StringBuilder result = new StringBuilder();
        String[] strings = new String[len];
        for (int i = 0;i < len;i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });

        for (int i = 0;i < len;i++) {
            result.append(strings[i]);
        }

        return result.toString();
    }

}
