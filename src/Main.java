import orderAlgorithms.HeapSort;
import orderAlgorithms.InsertionSort;
import orderAlgorithms.MergeSort;
import orderAlgorithms.QuickSort;

import java.util.Random;

public class Main {
    /*Algorithms:
    Merge Sort
    Quick Sort
    Heap Sort
    Hybrid: Quick e Heap */
    public static void main(String args[]) {

        int[] array;
        int n = 1;

        for (int i = 0; i < n; i++) {
            array = generateArray(10, 0, 30000);
            printArray(array);

            long avg = 0;

//            InsertionSort.runInsertionSort(array, avg);

//            QuickSort.runQuickSort(array, avg);
//
//            HeapSort.runHeapSort(array, avg);
//
//            MergeSort.runMergeSort(array, avg);

//            long startTime3 = System.nanoTime();
//            QuickSort.quickSort(array3, 0, array3.length - 1);
//            long endTime3 = System.nanoTime();
//            long timeElapsed3 = endTime3 - startTime3;
//            avg3 = avg3 + timeElapsed3;
//            print(timeElapsed3 + "\n");
//
//            long startTime1 = System.nanoTime();
//            MergeSort.mergeSort(array1, 0, array1.length - 1);
//            long endTime1 = System.nanoTime();
//            long timeElapsed1 = endTime1 - startTime1;
//            avg1 = avg1 + timeElapsed1;
////
//            long startTime2 = System.nanoTime();
//            HeapSort.heapSort(array2, array2.length);
//            long endTime2 = System.nanoTime();
//            long timeElapsed2 = endTime2 - startTime2;
//            avg2 = avg2 + timeElapsed2;
            print("\n");
            printArray(array);
        }
//        print("\nAVG Merge Sort: " + avg1 / n);
//        print("\nAVG Heap Sort: " + avg2 / n);
//        print("\nAVG Quick Sort: " + avg3 / n + "\n");
    }

    private static int[] generateArray(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = generateRandomIntIntRange(minValue, maxValue);
        }
        return array;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    private static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}