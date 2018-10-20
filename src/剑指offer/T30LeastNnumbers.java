package 剑指offer;

import java.util.ArrayList;

/**
 * 最小的K个数
 *
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *
 * 解题思路
 * 两种方法：
 *
 * 法1：先对数组排序，然后取出前k个
 * 法2：利用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
 *
 * 最大堆保存k个数，比堆顶大，则替换并放入
 */

public class T30LeastNnumbers {
    public static void main(String[] args) {
        ArrayList<Integer> result = getLeastNnumbers(new int[]{1,2,3,4,5,3,2,1}, 3);
        for (Integer temp : result) {
            System.out.println(temp);
        }
    }

    private static ArrayList<Integer> getLeastNnumbers(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length)
            return result;

        int i = 0;

        //构建大顶堆
        for (;i < k; i++) {
            heapInsert(nums, i);
        }

        //替换堆顶，调整大顶堆的过程
        for (;i < nums.length;i++) {
            if (nums[i] < nums[0]) {
                swap(nums, i, 0);
                heapVerify(nums, 0, k);
            }
        }
        i = 0;
        for (; i < k; i++) {
            result.add(nums[i]);
        }
        return result;

    }

    //构建大顶堆过程
    private static void heapInsert(int[] nums, int i) {
        while (nums[i] > nums[(i-1)/2]) {
            swap(nums, i, (i-1)/2);
            i = (i-1)/2;
        }
    }

    //调整大顶堆的过程
    private static void heapVerify(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = (nums[left] < nums[left+1] && left + 1 < heapSize) ? left + 1 : left;
            largest = nums[index] > nums[largest] ? index : largest;
            if (largest == index)
                break;
            swap(nums, largest, index);
            index = largest;
            left = 2 * index + 1;
        }

    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
