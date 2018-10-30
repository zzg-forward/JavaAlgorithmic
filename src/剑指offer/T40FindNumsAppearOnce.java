package 剑指offer;

/**
 * 数组中只出现一次的数字
 *
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 *
 * 解题思路
 * 法一：大家都能想到的HashMap法
 * 法二：异或法
 *
 * 任何一个数字异或它自己都等于0。
 *
 * 如果数组中只一个数字是只出现一次的，其他数字都是成双成对出现的，那么我们从头到尾依次异或数组中的每个数字，最终的结果刚好就是那个只出现一次的数字，因为那些成对出现两次的数字全部在异或中抵消了。
 *
 * 那么回到我们的题目，因为有两个只出现一次的数字，所以我们可以试着把原数组分成两个子数组，使得每个数组包含一个只出现一次的数字，而其他数字都成对出现两次。如果这样拆分成两个数组，那么我们就可以按照之前的办法分别对两个数组进行异或运算找出两个只出现一次的数字。
 *
 * 问题来了，如何进行分组呢？
 * 我们还是从头到尾依次异或数组中的每个数字，那么最终得到的结果就是两个只出现一次的数字异或的结果。
 * 由于这两个数字不一样，所以异或的结果至少有一位为1，我们在结果数字中找到第一个为1的位置，
 * 记为index位，现在我们以第index位是不是1为标准把原数组拆分成两个子数组，第一个子数组中的数组第index位都为1，
 * 第二个子数组中的数组第index位都为0，那么只出现一次的数字将被分配到两个子数组中去，
 * 于是每个子数组中只包含一个出现一次的数字，而其他数字都出现两次。这样我们就可以用之前的方法找到数组中只出现一次的数字了。
 *
 * 分解问题
 * 异或的办法,分组
 *
 */

public class T40FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] tempArr = findNumsAppearOnce(new int[]{1,1,2,3,2,6});
        for (int i : tempArr) {
            System.out.println(i);
        }
    }

    public static int[] findNumsAppearOnce(int[] nums) {
        int target1 = 0;
        int target2 = 0;
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int num = 0;
        for (int i : nums) {
            num ^= i;
        }

        int index = 0;
        int target = 1;
        while ((num & target) == 0 && index < 8) {
            target = target << 1;
            index++;
        }

        for (int i : nums) {
            if (isa1(i, index)) {
                target1 ^= i;
            } else {
                target2 ^= i;
            }
        }
        return new int[]{target1, target2};
    }

    private static boolean isa1(int target, int index) {
        return ((1 << index) & target) == 1;
    }

}
