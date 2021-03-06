package 剑指offer;

/**
 * [剑指offer] 连续子数组的最大和
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * 解题思路
 * 对于一个数组中的一个数x，若是x的左边的数加起来非负，那么加上x能使得值变大，这样我们认为x之前的数的和对整体和是有贡献的。如果前几项加起来是负数，则认为有害于总和。
 * 我们用cur记录当前值, 用max记录最大值，如果cur<0,则舍弃之前的数，让cur等于当前的数字，否则，cur = cur+当前的数字。若cur和大于max更新max。
 */

public class FindGreatestSumOfSubArray {
    public static int findGreatestSumOfSubArray(int[] array){
        if (array.length == 0)
            return 0;
        int cur = array[0];
        int max = array[0];

        for (int i = 1;i < array.length;i++){
            cur = cur > 0 ? cur + array[i] : array[i];
            if (max < cur)
                max = cur;
        }
        return max;
    }
}
