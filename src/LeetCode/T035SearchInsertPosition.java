package LeetCode;

/**
 * 题意是让你从一个没有重复元素的已排序数组中找到插入位置的索引。因为数组已排序，所以我们可以想到二分查找法，因为查找到的条件是找到第一个等于或者大于 target 的元素的位置，所以二分法略作变动即可。
 *
 */

public class T035SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsertPosition(new int[]{1,3,5,6}, 5));
    }

    public static int searchInsertPosition(int[] ary, int target) {
        if (ary == null || ary.length == 0)
            return -1;
        int left = 0;
        int right = ary.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (target <= ary[mid])
                right = mid - 1;    //right = mid可能造成死循环
            else
                left = mid + 1;
        }
        return left;                //记住返回的是left
    }
}
