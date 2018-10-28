package 剑指offer;

/**
 * 数字在排序数组中出现的次数
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 *
 * 解题思路
 * 正常的思路就是二分查找了，我们用递归的方法实现了查找k第一次出现的下标，用循环的方法实现了查找k最后一次出现的下标。
 * 除此之外，还有另一种奇妙的思路，因为data中都是整数，所以我们不用搜索k的两个位置，而是直接搜索k-0.5和k+0.5这两个数应该插入的位置，然后相减即可。
 *
 * 二分查找的应用
 * （1）查找k的开头语结尾（注意判断条件，分两个函数，一个返回start，一个返回end）
 * （2）查找k+/-0.5的位置（只要一个函数即可）
 */

public class T38GetNumberOfK {
    public static void main(String[] args) {
        int[] temp = new int[]{-1,2,3,3,3,3,6,9,10};
        System.out.println(getNumberOfK(temp, 3));
        System.out.println(getNumberOfK_2(temp, 3));
    }

    //法一，二分法寻找k的start与end
    public static int getNumberOfK(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int length = nums.length;
        int start = getStartOfK(nums, 0, nums.length - 1, k);
        int end = getEndOfK(nums, 0, nums.length - 1, k);
        if (start != -1 && end != -1) {
            return end - start + 1;
        }
        return 0;
    }

    private static int getStartOfK(int[] nums, int start, int end, int k) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (k <= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start < nums.length && nums[start] == k) {
            return start;
        }
        return -1;
    }

    private static int getEndOfK(int[] nums, int start, int end, int k) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (k >= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (end < nums.length && nums[end] == k) {
            return end;
        }
        return -1;
    }

    //法二，寻找k-0.5与k+0.5的位置
    public static int getNumberOfK_2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int start = getIndex(nums, 0, length - 1, k - 0.5);
        int end = getIndex(nums, 0, length - 1, k + 0.5);
        if (start != -1 && end != -1) {
            return end - start;
        }
        return 0;
    }

    private static int getIndex(int[] nums, int start, int end, double k) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start < nums.length) {
            return start;
        }
        return -1;
    }

}
