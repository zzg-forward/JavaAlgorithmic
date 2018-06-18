package CodeJava.chapter2;

/**
 * 堆排序
 * 包含构建堆（heapInsert）和调整堆（heapIdf）两个过程
 * 引申：解决大数据量中位数问题，大顶堆和小顶堆
 */
public class HeapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2)
            return;

        //构建堆
        for (int i = 0;i < arr.length; i++)
            heapInsert(arr,i);

        //调整堆
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapIfy(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    private static void heapIfy(int[] arr, int index, int size){
        int left = 2 * index + 1;
        while (left < size) {
            int larget = arr[left] < arr[left + 1] && left + 1 < size ? left + 1 : left;    //arr[left] > arr[left + 1]会报错
            larget = arr[larget] > arr[index] ? larget : index;
            if (larget == index)
                break;
            swap(arr, larget, index);
            index = larget;
            left = 2 * index + 1;
        }
    }

    private static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]) { //叶子节点大于父节点
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] testArr = {6,4,3,1,1,2,3,4,3};
        heapSort(testArr);
        for (int item : testArr)
            System.out.println(item);
    }

}
