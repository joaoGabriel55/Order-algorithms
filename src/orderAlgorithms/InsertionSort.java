package orderAlgorithms;

public class InsertionSort {

    public static void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int j;
            int key = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static long runInsertionSort(int[] array, long avg) {
        long startTime3 = System.nanoTime();
        sort(array);
        long endTime3 = System.nanoTime();
        long timeElapsed3 = endTime3 - startTime3;
        return timeElapsed3;

    }

}
