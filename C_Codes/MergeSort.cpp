#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define n 100000 //Tamanho do vetor a ser gerado

void merge(int array[], int p, int q, int r) {
    int n1 = q - p + 1;
    int n2 = r - q;

    int i, j, k;

    //New Arrays
    int left[n1];
    int right[n2];

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

void insertionSort(int vetor[],int low, int high){
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

void hybridMergeSort(int array[], int p, int r) {
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

void mergeSort(int array[], int p, int r) {
	if (p < r) {
		int q = (p + r) / 2;
		mergeSort(array, p, q);
		mergeSort(array, q + 1, r);
		merge(array, p, q, r);
	}
}

void genereateArray(int vetor[]){
   	FILE *f = fopen("Goiaba.txt", "r");
	
	for (int i = 0; i < n; ++i) {
		fscanf(f, "%d", &vetor[i]);
	}
	
	fclose(f);
}

void printArray(int arr[])  {    
    for (int i = 0; i < n; i++)
    	printf("%d\t", arr[i]);
   	printf("\n");
}

int main() {
	printf("Merge Sort\n\n");
	srand( (unsigned)time( NULL ) );
	
	clock_t t;

	int key = 0;
	int count = 0;
	while(count <= 100){
		int vetor[n];
		genereateArray(vetor);
		//printArray(vetor);
		t = clock();
		hybridMergeSort(vetor, 0, n - 1);
		t = clock() - t;
		float time_taken = ((float)t)/CLOCKS_PER_SEC;
		printf("%f\n", time_taken); 
		//printArray(vetor);
		//printf("\n");
		count++;
	}
	//getch();
	return 0;
}
