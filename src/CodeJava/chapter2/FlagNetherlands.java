package CodeJava.chapter2;

/**
 * 荷兰国旗问题
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 */

public class FlagNetherlands {
    public static int[] partitions(int[] arr, int left, int right, int num){
        int less = left - 1;  //其实less和more指针可以设置为left与right，就是移动顺序不同而已
        int cur = left;
        int more = right + 1;
        while (cur < more){     //判断条件是cur指针与more指针相遇
            if (arr[cur] < num)
                swap(arr, cur++, ++less); //cur移动是因为数组左边已经是排好序了
            else if (arr[cur] > num)
                swap(arr, cur, --more); //cur指针不往后移动,是因为右边是待排序
            else   // == num
                cur++;
        }
        return new int[]{less + 1, more - 1};  //返回相等的数组区间
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] testArr = {6,4,3,1,1,2,3,4,3};
        int[] result = partitions(testArr, 0, testArr.length - 1, 3);
        for (int item : result)
            System.out.println(item);
    }
}
