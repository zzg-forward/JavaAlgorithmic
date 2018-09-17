package 剑指offer.Sort;

/**
 *堆排序
 */
public class HeapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2)
            return;

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapIfy(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    private static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapIfy(int[] arr, int index, int size){
        int left = 2 * index + 1;
        while (left < size) {
            //zijiedain zuidazhi
            int largest = (arr[left] < arr[left+1] && left + 1 < size) ? left+1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index)
                break;
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
