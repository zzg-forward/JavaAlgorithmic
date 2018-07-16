import java.util.LinkedList;

/**
 *最大值减去最小值小于等于num的子数组的数量
 * O(N)
 */
public class P31GetNum {

    public static int getNum(int[] arr, int num){
        if (arr == null || arr.length == 0){
            return 0;
        }
        LinkedList<Integer> qMin = new LinkedList<>();
        LinkedList<Integer> qMax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int result = 0;
        while (i < arr.length){
            while (j < arr.length){
                while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[j]){
                    qMin.pollLast();
                }
                qMin.addLast(j);
                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[j]){
                    qMax.pollLast();
                }
                qMax.addLast(j);
                if ((arr[qMax.getFirst()] - arr[qMin.getFirst()]) > num){
                    break;
                }
                j++;
            }
            if (qMin.peekFirst() == i){
                qMin.pollFirst();
            }
            if (qMax.peekFirst() == i){
                qMax.pollFirst();
            }
            result += j - i;
            i++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] testArr = {1, 2};
        int result = P31GetNum.getNum(testArr, 1);
        System.out.println(result);
    }

}
