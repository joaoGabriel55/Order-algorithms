package orderAlgorithms;

public class QuickSort {

    private static int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array[j] <= x) {
                i++;
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }

        }
        int aux = array[i + 1];
        array[i + 1] = array[r];
        array[r] = aux;
        return i + 1;
    }

    private static void insertionSort(int vetor[], int low, int high) {
        int key = 0;
        for (int j = low + 1; j <= high; j++) {
            int i = 0;
            key = vetor[j]; // 4
            i = j - 1; //2 - 1 = 1
            while (i >= 0 && vetor[i] > key) {//V - V
                vetor[i + 1] = vetor[i];
                i = i - 1; // 0
            }
            vetor[i + 1] = key;
        }
    }

    public static void quickSort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    public static void hybridQuickSort(int[] array, int p, int r) {
        if (p < r) {
            if (r - p < 10) {
                insertionSort(array, p, r);
            } else {
                int q = partition(array, p, r);
                hybridQuickSort(array, p, q - 1);
                hybridQuickSort(array, q + 1, r);
            }
        }
    }

    public static long runQuickSort(int[] array, long avg) {
        long startTime3 = System.nanoTime();
        QuickSort.quickSort(array, 0, array.length - 1);
        long endTime3 = System.nanoTime();
        long timeElapsed3 = endTime3 - startTime3;
        avg = avg + timeElapsed3;
        return timeElapsed3;
    }

    public static long runHybridQuickSort(int[] array, long avg) {
        long startTime3 = System.nanoTime();
        QuickSort.hybridQuickSort(array, 0, array.length - 1);
        long endTime3 = System.nanoTime();
        long timeElapsed3 = endTime3 - startTime3;
        avg = avg + timeElapsed3;
        return timeElapsed3;
    }

}
