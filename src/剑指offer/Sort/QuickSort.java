package 剑指offer.Sort;

/**
 * 随机快速排序
 */

public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(arr, left + (int)(Math.random() * (right - left + 1)), right);
        int[] flags = partition(arr, left, right);
        quickSort(arr, left, flags[0] - 1);
        quickSort(arr, flags[1] + 1, right);
    }

    private static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] < arr[right])
                swap(arr, ++less, left++);
            else if (arr[left] > arr[right])
                swap(arr, left, --more);
            else {
                left++;
            }
        }
        swap(arr, right, more);

        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
