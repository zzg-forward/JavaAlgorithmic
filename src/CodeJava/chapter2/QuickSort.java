package CodeJava.chapter2;

/**
 * 随机快速排序
 * 时间复杂度O(N*logN)，额外空间复杂度O(logN)
 */
public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2)
            return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right){
        if (left < right) {
            swap(arr, left + (int)(Math.random() * (right - left + 1)), right);
            int[] flag = partition(arr, left, right);
            quickSort(arr, left, flag[0] - 1);
            quickSort(arr, flag[1] + 1, right);
        }
    }

    private static int[] partition(int[] arr, int left, int right){
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] < arr[right])
                swap(arr, ++less, left++);
            else if (arr[left] > arr[right])
                swap(arr, --more, left);   //left不用递增，因为不清楚下次替换过来的是否比当前的小
            else // arr[left] == arr[right]的情况
                left++;
        }
        swap(arr, right, more);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] testArr = {6,4,3,1,1,2,3,4,3};
        quickSort(testArr);
        for (int item : testArr)
            System.out.println(item);
    }
}
