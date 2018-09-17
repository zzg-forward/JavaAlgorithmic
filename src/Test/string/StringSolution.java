package Test.string;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 字符串相关
 */

public class StringSolution {
    public static void main(String[] args) {
        String temp = "we are happy.";
//        System.out.println(Solution.replaceSpace(temp));
//        System.out.println(Solution.getLongestCommonPre(new String[]{"A1BC", "ABCd", "ABC123"}));
        System.out.println(Solution.longestPalindrome2("ddaddcacc"));
//        System.out.println(Solution.isPalindrome("abca"));
    }

}

class Solution{

    /**
     * 剑指offer
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    static String replaceSpace(String str){
        StringBuilder strBuilder = new StringBuilder(str);
        int length = strBuilder.length();
        int spaceNum = 0;
        for (int i = 0;i < length;i++){
            if (strBuilder.charAt(i) == ' ')
                spaceNum++;
        }
        int newLength = length + 2 * spaceNum;
        strBuilder.setLength(newLength);
        int newIndex = newLength - 1;
        for (int i = length - 1;i >= 0;i--){
            if (strBuilder.charAt(i) == ' '){
                strBuilder.setCharAt(newIndex--, '%');
                strBuilder.setCharAt(newIndex--, '0');
                strBuilder.setCharAt(newIndex--, '2');
            }else {
                strBuilder.setCharAt(newIndex--, strBuilder.charAt(i));
            }
        }
        return strBuilder.toString();
    }

    /**
     * 写一个函数找出一个字串所数组中的最长的公共前缀。
     * https://blog.csdn.net/DERRANTCM/article/details/46963385
     */
    public static String getLongestCommonPre(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for(String temp : strs){
            if (temp == null)
                return "";
            if (temp.length() < minLen)
                minLen = temp.length();
        }
        int i = 0;
        boolean flag;
        for (;i < minLen;i++){
            flag = true;
            for (int j = 1;j < strs.length;j++){
                if (strs[0].charAt(i) != strs[j].charAt(i)){
                    flag = false;
                    break;
                }
            }
            //跳出循环
            if (!flag)
                break;
        }
        return strs[0].substring(0, i);
    }

    /**
     * https://blog.csdn.net/derrantcm/article/details/46922011
     * 解法一
     * 给定一个字符串S，找出它的最大的回文子串，你可以假设字符串的最大长度是1000，而且存在唯一的最长回文子串
     * @return
     */
    public static String longestPalindrome(String s){
        if (s == null || s.length() < 2){
            return s;
        }
        int maxLength = 0;
        String longest = null;

        int length = s.length();
        boolean[][] table = new boolean[length][length];

        for (int i = 0;i < length;i++){
            table[i][i] = true;
            longest = s.substring(i, i+1);
            maxLength = 1;
        }

        for (int i = 0;i < length - 1;i++){
            if (s.charAt(i) == s.charAt(i + 1)){
                table[i][i+1] = true;
                longest = s.substring(i, i+2);
                maxLength = 2;
            }
        }

        for (int len = 3;len <= length;len++){
            for (int i = 0,j;(j=i+len-1)<=length-1;i++){
                if (s.charAt(i) == s.charAt(j)){
                    table[i][j] = table[i+1][j-1];
                    if (table[i][j] && maxLength < len){
                        longest = s.substring(i, j+1);
                        maxLength = len;
                    }
                }else {
                    table[i][j] = false;
                }

            }

        }
        return longest;
    }

    /**
     * Leetcode: 验证回文串 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
     */
    public static boolean isPalindrome(String s){
        if (s == null || s.length() <= 1){
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            if (!Character.isLetterOrDigit(s.charAt(left)))
                left++;
            else if (!Character.isLetterOrDigit(s.charAt(right)))
                right--;
            else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }

    /**
     * https://juejin.im/post/5b8f9aed6fb9a05d2e1b75d9
     * 解法二
     * 给定一个字符串S，找出它的最大的回文子串，你可以假设字符串的最大长度是1000，而且存在唯一的最长回文子串
     * @return
     */
    private static int index, len;
    public static String longestPalindrome2(String s) {
        if (s.length() < 2)
            return s;
        for (int i = 0;i < s.length() - 1;i++){
            palindromeHelper(s, i, i);  //奇数
            palindromeHelper(s, i, i+1);  //偶数
        }

        return s.substring(index, index + len);
    }

    private static void palindromeHelper(String s, int l, int r){
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        if (len < r - l - 1){
            index = l + 1;
            len = r - l - 1;
        }
    }

    /**
     * LeetCode: 最长回文子序列
     * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
     * 最长回文子序列和上一题最长回文子串的区别是，子串是字符串中连续的一个序列，而子序列是字符串中保持相对位置的字符序列，例如，"bbbb"可以使字符串"bbbab"的子序列但不是子串。
     *https://juejin.im/post/5b8f9aed6fb9a05d2e1b75d9#heading-6s
     */
    //

}
