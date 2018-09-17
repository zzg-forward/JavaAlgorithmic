package 剑指offer.Sort;

/**
 * 选择排序
 * O(N^2)
 */

public class SelectionSort {

    public static void selectSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1;i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length;j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(arr, minIndex, i);
        }
    }

    private static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
