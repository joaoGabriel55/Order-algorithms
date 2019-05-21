package orderAlgorithms;

public class HeapSort {

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    /*n == size of array*/
    private static void maxHeapify(int[] array, int n, int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);

        if (l < n && array[l] > array[largest]) {
            largest = l;
        }

        if (r < n && array[r] > array[largest]) {
            largest = r;
        }

        if (largest != i) {
            int aux = array[i];
            array[i] = array[largest];
            array[largest] = aux;
            maxHeapify(array, n, largest);
        }
    }

    private static void buildMaxHeap(int array[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(array, n, i);
        }
    }

    public static void heapSort(int[] array, int n) {
//        int heapSize = array.length;
        buildMaxHeap(array, n);
        for (int i = n - 1; i >= 0; i--) {
            int aux = array[0];
            array[0] = array[i];
            array[i] = aux;
            maxHeapify(array, i, 0);
        }
    }

    public static long runHeapSort(int[] array, long avg) {
        long startTime2 = System.nanoTime();
        HeapSort.heapSort(array, array.length);
        long endTime2 = System.nanoTime();
        long timeElapsed2 = endTime2 - startTime2;
        avg = avg + timeElapsed2;
        return timeElapsed2;
    }
}
