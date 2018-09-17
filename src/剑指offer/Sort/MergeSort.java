package 剑指offer.Sort;

/**
 * 归并排序
 *
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = l + ((r - l) >> 1);

        sortProcess(arr, l, mid);
        sortProcess(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= r) {
            temp[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid){
            temp[index++] = arr[p1++];
        }

        while (p2 <= r) {
            temp[index++] = arr[p2++];
        }

        for (int j = 0; j < temp.length; j++) {
            arr[l + j] = temp[j];
        }
    }
}
