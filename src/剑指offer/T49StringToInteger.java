package 剑指offer;

/**
 * 把字符串转换成整数
 *
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * 解题思路
 * 常规思路，先判断第一位是不是符号位，如果有符号，有flag 做标记。
 * 遍历字符串中的每个字符，如果存在非数字的字符，直接返回 0，否则，用当前字符减去’0’得到当前的数字，再进行运算。
 *
 * 流程：
 * 判断空格
 * 判断正负号
 * 判断数字（小于0 or 大于9则返回最大或最小值）
 */
public class T49StringToInteger {
    public static void main(String[] args) {
        int result = stringToInteger(" -1aaa23");
        System.out.println(result);
    }

    private static int stringToInteger(String str) {
        int sign = 1, i = 0, len = str.length(), result = 0;
        while (i < len && str.charAt(i) == ' ') {
            i++;
        }
        if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }
        for (;i < len;i++) {
            int temp = str.charAt(i) - '0';
            if (temp < 0 || temp > 9) {
                break;
            }
            if (result > Integer.MAX_VALUE/10 ||
                    (result == Integer.MAX_VALUE/10 && (sign == -1 && temp > 8 || sign == 1 && temp > 7))) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                result = result * 10 + temp;
            }
        }
        return sign * result;
    }
}
