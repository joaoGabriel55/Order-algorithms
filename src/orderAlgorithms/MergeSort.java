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

    public static void mergeSort(int[] array, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            merge(array, p, q, r);
        }
    }

}
