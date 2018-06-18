package CodeJava.递归;

/**
 * 逆序对问题
 * 在一个数组中，左边的数如果比右边的数大， 则两个数构成一个逆序对， 请输出所有逆序对总数(或者打印出所有逆序对)。
 */
public class ReverseOrder {
    public static void reverseOrder(int[] arr){
        if (arr == null || arr.length < 2)
            return;
        System.out.println(reverseArr(arr, 0, arr.length - 1));
    }

    public static int reverseArr(int[] arr, int l, int r){
        if (l == r)
            return 0;
        int mid = l + ((r - l) >> 1);
        return reverseArr(arr, l, mid) + reverseArr(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        int result = 0;
        while (p1 <= mid && p2 <= r) {
            result += arr[p1] > arr[p2] ? (r - p2 + 1) : 0;
            temp[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid)
            temp[i++] = arr[p1++];

        while (p2 <= r)
            temp[i++] = arr[p2++];

        //将新数组中的数拷贝到原数组
        for (i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
        return result;
    }

    //for test
    public static void main(String[] args){
        int[] testArr = {8,6,4,1,2,3};
        reverseOrder(testArr);
    }

}
