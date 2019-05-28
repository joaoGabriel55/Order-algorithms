import orderAlgorithms.HeapSort;
import orderAlgorithms.InsertionSort;
import orderAlgorithms.MergeSort;
import orderAlgorithms.QuickSort;

import java.io.*;
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
        print("4 - HybridQuickSort\n");
        print("5 - HybridMergeSort\n");
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
            array = generateArray(size);
//            printArray(array);
            long avg = 0;
            switch (orderAlgorithm) {
                case 0:
                    print(InsertionSort.runInsertionSort(array, avg) + "\n");
                    break;
                case 1:
                    print(QuickSort.runQuickSort(array, avg) + "\n");
                    break;
                case 2:
                    print(HeapSort.runHeapSort(array, avg) + "\n");
                    break;
                case 3:
                    print(MergeSort.runMergeSort(array, avg) + "\n");
                    break;
                case 4:
                    print(QuickSort.runHybridQuickSort(array, avg) + "\n");

                    break;
                case 5:
                    print(MergeSort.runHybridMergeSort(array, avg) + "\n");
//                    printArray(array);
                    break;
            }
//           print("\n");
//            printArray(array);
        }
//        writer.close();


    }

    private static int[] generateArray(int size) {
        int[] array = new int[size];
        try {
            FileInputStream inputStream = new FileInputStream("C:\\Users\\Quaresma\\Documents\\Drive\\Academico\\Mestrado\\2019.1\\Estrutura_de_dados\\Projeto_unity_2\\Project\\src\\NumbersSample.txt");
            Scanner in = new Scanner(inputStream);
            for (int i = 0; in.hasNextLine() && i < size; i++) {
                int num = Integer.parseInt(in.nextLine());
                array[i] = num;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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