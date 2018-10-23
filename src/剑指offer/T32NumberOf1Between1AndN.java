package 剑指offer;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

/**
 * [剑指offer] 整数中1出现的次数（从1到n整数中1出现的次数）
 *
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * 解题思路
 * 三种解法：
 *
 * 法一：依次遍历每个数，判断每个数里面是否包含1
 * 法二：同法一，将数字转成字符串，直接判断
 * 法三：归纳法
 * 设N = abcde ,其中abcde分别为十进制中各位上的数字。
 * 如果要计算百位上1出现的次数，它要受到3方面的影响：百位上的数字，百位以下（低位）的数字，百位以上（高位）的数字。
 * ① 如果百位上数字为0，百位上可能出现1的次数由更高位决定。比如：12013，则可以知道百位出现1的情况可能是：100~199，1100~1199,2100~2199，，…，11100~11199，一共1200个。可以看出是由更高位数字（12）决定，并且等于更高位数字（12）乘以 当前位数（100）。
 * ② 如果百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响。比如：12113，则可以知道百位受高位影响出现的情况是：100~199，1100~1199,2100~2199，，….，11100~11199，一共1200个。和上面情况一样，并且等于更高位数字（12）乘以 当前位数（100）。但同时它还受低位影响，百位出现1的情况是：12100~12113,一共114个，等于低位数字（113）+1。
 * ③ 如果百位上数字大于1（2~9），则百位上出现1的情况仅由更高位决定，比如12213，则百位出现1的情况是：100~199,1100~1199，2100~2199，…，11100~11199,12100~12199,一共有1300个，并且等于更高位数字+1（12+1）乘以当前位数（100）。
 * ——参考牛客网@藍裙子的百合魂
 *
 *
 * 归纳法总结规律算出
 */

public class T32NumberOf1Between1AndN {
    private static ThreadLocal<DateFormat> threadLocalSession = new ThreadLocal<>();
    public static void main(String[] args) {
        //threadLocal的使用
//        threadLocalSession.set(new DateFormat() {
//            @Override
//            public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
//                return null;
//            }
//
//            @Override
//            public Date parse(String source, ParsePosition pos) {
//                return null;
//            }
//        });
//        threadLocalSession.get();
//        threadLocalSession.remove();

        System.out.println(getNumberOf1Between1AndN(13));
    }

    private static int getNumberOf1Between1AndN(int num) {
        int res = 0;
        int cur = 0, before = 0, after = 0;
        int i = 1;
        while (i <= num) {
            //1311
            before = num / (i * 10);
            after = num - num/i*i;
            cur = (num/i) % 10;
            if (cur == 0) {
                // 如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
                res += before * i;
            } else if (cur == 1) {
                // 如果为1, 出现1的次数由高位和低位决定,高位*当前位+低位+1
                res += before * i + after + 1;
            }else {
                // 如果大于1, 出现1的次数由高位决定,（高位数字+1）* 当前位数
                res += (before + 1) * i;
            }
            i *= 10;
        }
        return res;
    }
}
