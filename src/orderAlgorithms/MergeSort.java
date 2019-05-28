package orderAlgorithms;

public class MergeSort {

    /*
     * @params
     * p = start
     * q = end
     * r = get the end of sub-array
     * */
    public static void merge(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int i, j, k;

        //New Arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (i = 0; i < n1; i++)
            left[i] = array[p + i];

        for (j = 0; j < n2; j++)
            right[j] = array[q + j + 1];

        i = 0;
        j = 0;
        k = p;

        while (j < n2 && i < n1) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        /* Copy the remaining elements for array */
        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    private static void insertionSort(int vetor[],int low, int high){
        int key = 0;
        for(int j = low+1; j <= high; j++) {
            int i = 0;
            key = vetor[j]; // 4
            i = j - 1; //2 - 1 = 1
            while(i >= 0 && vetor[i] > key) {//V - V
                vetor[i + 1] = vetor[i];
                i = i - 1; // 0
            }
            vetor[i + 1] = key;
        }
    }

    public static void hybridMergeSort(int array[], int p, int r) {
        if (p < r) {
            if(r - p < 2){
                insertionSort(array, p, r);
            } else {
                int q = (p + r) / 2;
                hybridMergeSort(array, p, q);
                hybridMergeSort(array, q + 1, r);
                merge(array, p, q, r);
            }
        }
    }


    public static void mergeSort(int[] array, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            merge(array, p, q, r);
        }
    }

    public static long runMergeSort(int[] array, long avg) {
        long startTime1 = System.nanoTime();
        MergeSort.mergeSort(array, 0, array.length - 1);
        long endTime1 = System.nanoTime();
        long timeElapsed1 = endTime1 - startTime1;
        avg = avg + timeElapsed1;
       return timeElapsed1;
    }

    public static long runHybridMergeSort(int[] array, long avg) {
        long startTime1 = System.nanoTime();
        MergeSort.hybridMergeSort(array, 0, array.length - 1);
        long endTime1 = System.nanoTime();
        long timeElapsed1 = endTime1 - startTime1;
        avg = avg + timeElapsed1;
       return timeElapsed1;
    }

}
