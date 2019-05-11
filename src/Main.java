import orderAlgorithms.MergeSort;

public class Main {
    /*Algorithms:
    Merge Sort
    Quick Sort
    Heap Sort
    Hybrid: Quick e Heap */
    public static void main(String args[]) {

        int[] array = {5, 9, 7, 1, 2, 3};
        print("Original Array: ");
        printArray(array);
        MergeSort.mergeSort(array, 0, array.length - 1);
        print("\nOrder Array: ");
        printArray(array);

    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    private static void print(Object o) {
        System.out.print(o);
    }
}
