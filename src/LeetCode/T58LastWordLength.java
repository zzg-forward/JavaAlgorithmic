package LeetCode;

/**
 *Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * 　　If the last word does not exist, return 0.
 * 　　Note: A word is defined as a character sequence consists of non-space characters only.
 * 　　For example,
 * 　　Given s = "Hello World",
 * 　　return 5.
 *
 * ---------------------
 *
 * 本文来自 derrantcm 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/DERRANTCM/article/details/47164433?utm_source=copy
 *
 * 给定一个由大小写字母组和空格组成的字符串，返回字符串中的最后一个单词长度。
 *
 * 先从后找第一个字母的位置x，如果没有找到就返回0，如果找到，再找第一个空格的位记为y(y可能是-1，因为没有找到空格)，返回结果x-y。
 */

public class T58LastWordLength {
    public static void main(String[] args) {
        System.out.println(getLastWordLength("happy"));
    }

    private static int getLastWordLength(String str) {
        if (str == null)
            return 0;

        int totalIndex = str.length() - 1;
        int index = totalIndex;
        while (index >= 0 && str.charAt(index) == ' ')
            index--;
        if (index < 0)
            return 0;
        int lastIndex = index;
        while (index >= 0 && str.charAt(index) != ' ')
            index--;

        return lastIndex - index;

    }

}
