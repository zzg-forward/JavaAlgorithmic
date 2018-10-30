package 剑指offer;

/**
 * 和为S的两个数字
 *
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 解题思路
 * 法一：哈希法。用一个HashMap，它的 key 存储数S与数组中每个数的差，value 存储当前的数字，比较S=15, 当前的数为 4，则往 hashmap 中插入(key=11, value=4)。我们遍历数组，判断hashmap 中的 key 是否存在当前的数字，如果存在，说明存在着另一个数与当前的数相加和为 S，我们就可以判断它们的乘积是否小于之前的乘积，如果小的话就替换之前的找到的数字，如果大就放弃当前找到的。如果hashmap 中的 key 不存在当前的数字，说明还没有找到相加和为 S 的两个数，那就把S与当前数字的差作为 key，当前数字作为 value 插入到 hashmap 中，继续遍历。
 *
 * 法二：左右夹逼的方法。a+b=sum，a和b越远乘积越小，因为数组是递增排序，所以一头一尾两个指针往内靠近的方法找到的就是乘积最小的情况。
 * 若ai + aj == sum，就是答案（相差越远乘积越小）
 * 若ai + aj > sum，说明 aj 太大了，j —
 * 若ai + aj < sum，说明 ai 太小了，i ++
 *
 * hashmap法
 * 双指针法
 */

import java.util.ArrayList;
import java.util.HashMap;

public class T41_1FindNumbersWithSum {
    public static void main(String[] args) {

    }

    private static ArrayList<Integer> findNumbersWithSum (int[] nums, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int less = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length;i++) {
            if (map.containsKey(nums[i])) {
                if (nums[i] * map.get(nums[i]) < less) {
                    less = nums[i] * map.get(nums[i]);
                    result.clear();
                    result.add(nums[i]);
                    result.add(map.get(nums[i]));
                }
            } else {
                map.put(target - nums[i], nums[i]);
            }
        }
        return result;
    }

    private static ArrayList<Integer> findNumbersWithSum2 (int[] nums, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return result;
        }
        int first = 0;
        int last = nums.length - 1;
        while (first < last) {
            if (nums[first] + nums[last] == target) {
                result.add(nums[first]);
                result.add(nums[last]);
                break;
            } else if (nums[first] + nums[last] < target) {
                first++;
            } else {
                last--;
            }
        }

        return result;

    }
}
