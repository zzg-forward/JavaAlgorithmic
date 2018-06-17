package 递归;

/**
 * 归并排序
 * 实质是分治的思想
 * 递归实现
 *
 */
public class MergeSort {
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2)
            return;
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int l, int r){
        if (l == r)
            return;
        int mid = l + ((r - l) >> 1);
        sortProcess(arr, l, mid);
        sortProcess(arr, mid + 1, r);
        merge(arr, l, mid, r);  //对比左右两边的数，并添加到开辟出的新数组中
    }

    public static void merge(int[] arr, int l, int mid, int r){
        int[] temp = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while(p1 <= mid && p2 <= r) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= mid)
            temp[i++] = arr[p1++];

        while (p2 <= r)
            temp[i++] = arr[p2++];

        //将新数组中的数拷贝到原数组
        for(i = 0;i < temp.length;i++){
            arr[l + i] = temp[i];
        }
    }

    //for test
    public static void main(String[] args){
        int[] testArr = {1,4,3,2};
        mergeSort(testArr);
        for (int item: testArr) {
            System.out.println(item);
        }
    }
}
