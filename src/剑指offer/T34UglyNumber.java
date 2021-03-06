package 剑指offer;

/**
 *
 * 丑数
 *
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 解题思路
 * 判断一个数是不是丑数，最简单的方法就是让这个数不断除以2，3，5。要求第N个丑数，只要从1开始，依次判断每个数是不是丑数，如果是，则相应的序号加1，直到序号为N，就是我们要的丑数了。但是这种方法时间效率很，通常面试官不会满意这样的答案。因此我们需要一个时间复杂度更低的解法。
 *
 * 换个思路，我们只求丑数，不要去管非丑数。每个丑数必然是由小于它的某个丑数乘以2，3或5得到的，这样我们把求得的丑数都保存下来，用之前的丑数分别乘以2，3，5，找出这三这种最小的并且大于当前最大丑数的值，即为下一个我们要求的丑数。这种方法用空间换时间，时间复杂度为O(n)。
 *
 * 分析：
 * 这种思路的关键在于怎样确保数组里面的丑数是排好序的。假设数组中已经有若干个丑数排好序后存放在数组中，并且把己有最大的丑数记做M，我们接下来分析如何生成下一个丑数。该丑数肯定是前面某一个丑数乘以2、3 或者5 的结果， 所以我们首先考虑把已有的每个丑数乘以2。在乘以2 的时钝能得到若干个小于或等于M 的结果。由于是按照顺序生成的，小于或者等于M 肯定己经在数组中了，我们不需再次考虑：还会得到若干个大于M 的结果，但我们只需要第一个大于M 的结果，因为我们希望丑数是按从小到大的顺序生成的，其他更大的结果以后再说。我们把得到的第一个乘以2 后大于M 的结果记为M2，同样，我们把已有的每一个丑数乘以3 和5，能得到第一个大于M 的结果M3 和M，那么下一个丑数应该是M2、M3 和M5这3个数的最小者。
 *
 * 前面分析的时候，提到把已有的每个丑数分别都乘以2、3 和5。事实上这不是必须的，因为已有的丑数是按顺序存放在数组中的。对乘以2而言， 肯定存在某一个丑数T2，排在它之前的每一个丑数乘以2 得到的结果都会小于已有最大的丑数，在它之后的每一个丑数乘以2 得到的结果都会太大。我们只需记下这个丑数的位置， 同时每次生成新的丑数的时候，去更新这个T2。对乘以3 和5 而言， 也存在着同样的T3和T5。
 *
 * 其实就是每个丑数乘以2,3或者5，从中比较最小的数拿出来
 * t2,t3,t5相当于三个指针，一直往前移动
 * 前面的都是乘过的数，具体见上述分析
 */

public class T34UglyNumber {
    public static void main(String[] args) {
        System.out.println(getUglyNumber(5));
    }

    public static int getUglyNumber(int index) {
        if (index <= 0) { return 0; }
        if (index == 1) { return 1; }
        int t2 = 0, t3 = 0, t5 = 0;
        int[] result = new int[index];
        result[0] = 1;
        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[t2]*2, Math.min(result[t3]*3, result[t5]*5));
            if (result[i] == result[t2]*2) t2++;
            if (result[i] == result[t3]*3) t3++;
            if (result[i] == result[t5]*5) t5++;
        }
        return result[index - 1];
    }

}
