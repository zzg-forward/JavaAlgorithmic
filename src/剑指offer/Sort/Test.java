package 剑指offer.Sort;

public class Test {
    public static void main(String[] args) {
        int[] arr = {100, 1, 3, 5, 1000, 99};
//        BubbleSort.bubbleSort(arr);
//        InsertionSort.insertionSort(arr);
//        MergeSort.mergeSort(arr);
//        QuickSort.quickSort(arr);
        HeapSort.heapSort(arr);
        for(int item : arr){
            System.out.println(item);
        }
    }
}
