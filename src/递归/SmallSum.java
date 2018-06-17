package 递归;

/**
 * 小数问题:将数组左边比该数小的数加在一起
 * 在一个数组中， 每一个数左边比当前数小的数累加起来， 叫做这个数组的小和。 求一个数组的小和。
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数， 没有；
 * 3左边比3小的数， 1；
 * 4左边比4小的数， 1、 3；
 * 2左边比2小的数， 1；
 * 5左边比5小的数， 1、 3、 4、 2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 *
 * 递归实现
 * 类似归并排序的实现
 * 归并排序：合并前左右都有序了
 */
public class SmallSum {
    public static int getSmallSum(int[] arr, int l, int r){
        if (l == r)
            return 0;
        int mid = l + ((r - l) >> 1);
        return getSmallSum(arr, l, mid) + getSmallSum(arr,mid + 1, r) + getSumCount(arr, l, mid, r);
    }

    private static int getSumCount(int[] arr, int l, int mid, int r){
        int[] temp = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        int result = 0;
        while(p1 <= mid && p2 <= r){
            result += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1) : 0;  //归并到最小粒度时，左右都已经有序，所以可以直接加
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
        return result;

    }

    //for test
    public static void main(String[] args){
        int[] testArr = {6,4,3,1};
        int result = getSmallSum(testArr, 0, testArr.length - 1);
        System.out.println(result);
    }

}
