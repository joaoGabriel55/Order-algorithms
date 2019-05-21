import orderAlgorithms.HeapSort;
import orderAlgorithms.InsertionSort;
import orderAlgorithms.MergeSort;
import orderAlgorithms.QuickSort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /*Algorithms:
    Merge Sort
    Quick Sort
    Heap Sort
    Hybrid: Quick e Heap */
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        print("Choose order Algorithm:\n");
        print("0 - InsertionSort\n");
        print("1 - QuickSort\n");
        print("2 - HeapSort\n");
        print("3 - MergeSort\n");
        print("Type your chose: ");
        int orderAlgorithm = scanner.nextInt();
        print("Define the array size: ");
        int size = scanner.nextInt();
        print("Define the loop size: ");
        int n = scanner.nextInt();
        try {
            runOrderAlgorithms(orderAlgorithm, size, n);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void runOrderAlgorithms(int orderAlgorithm, int size, int n) throws IOException {
        int[] array;

        BufferedWriter writer = null;
        for (int i = 0; i < n; i++) {
            array = generateArray(size, 0, 30000);
//            printArray(array);
            long avg = 0;
            if (orderAlgorithm == 0) {
//                writer = new BufferedWriter(new FileWriter("time_insertion_sort"));
                print(InsertionSort.runInsertionSort(array, avg) + "\n");
            }
            if (orderAlgorithm == 1) {
//                writer = new BufferedWriter(new FileWriter("time_quick_sort_" + size + "_" + n));
                print(QuickSort.runQuickSort(array, avg) + "\n");
            }
            if (orderAlgorithm == 2) {
//                writer = new BufferedWriter(new FileWriter("time_heap_sort_" + size + "_" + n));
                print(HeapSort.runHeapSort(array, avg) + "\n");
            }
            if (orderAlgorithm == 3) {
//                writer = new BufferedWriter(new FileWriter("time_merge_sort_" + size + "_" + n));
                print(MergeSort.runMergeSort(array, avg) + "\n");
            }

//           print("\n");
//            printArray(array);
        }
//        writer.close();


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