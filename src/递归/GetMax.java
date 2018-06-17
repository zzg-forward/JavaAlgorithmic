package 递归;

/**
 * 递归求数组最大的值
 */
public class GetMax {
    public static int getArrMax(int[] arr, int l, int r){
        if (l == r)
            return arr[l];
        int mid = l + ((r - l) >> 1);
        int leftMax = getArrMax(arr, l, mid);
        int rightMax = getArrMax(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args){
        int[] testArr = {1,4,3,2};
        System.out.println(getArrMax(testArr, 0, testArr.length - 1));
    }

}
