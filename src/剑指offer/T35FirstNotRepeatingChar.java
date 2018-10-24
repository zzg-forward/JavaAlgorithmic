package 剑指offer;

/**
 * 第一个只出现一次的字符
 *
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1.
 *
 * 解题思路
 * 先在hash表中统计各字母出现次数，第二次扫描直接访问hash表获得次数。也可以用数组代替hash表。
 *
 */

import java.util.HashMap;

public class T35FirstNotRepeatingChar {
    public static void main(String[] args) {
        System.out.println(getFirstNotRepeatingChar("aaaadsdffff"));
    }

    public static int getFirstNotRepeatingChar(String str) {

        if (str == null || str.length() == 0) { return -1; }

        int len = str.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0;i < len;i++) {
            if (map.containsKey(str.charAt(i))) {
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        for (int i = 0;i < str.length();i++) {
            if (map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

}
