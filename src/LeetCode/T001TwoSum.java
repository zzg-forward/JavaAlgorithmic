package LeetCode;

/**
 * https://leetcode.com/problems/two-sum/
 */

import java.util.HashMap;

public class T001TwoSum {
    public static void main(String[] args) {
        int[] targetArray = new int[]{1, 2, 3, 4, 5};
        for (int item : twoSum(targetArray,9)) {
            System.out.println(item);
        }

    }

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = resultMap.get(target - nums[i]);
                break;
            } else {
                resultMap.put(nums[i], i);
            }
        }
        return result;
    }
}
