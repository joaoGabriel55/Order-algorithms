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

    public static void quickSort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    public static void runQuickSort(int[] array, long avg) {
        long startTime3 = System.nanoTime();
        QuickSort.quickSort(array, 0, array.length - 1);
        long endTime3 = System.nanoTime();
        long timeElapsed3 = endTime3 - startTime3;
        avg = avg + timeElapsed3;
        System.out.println(timeElapsed3 + "\n");
    }

}
