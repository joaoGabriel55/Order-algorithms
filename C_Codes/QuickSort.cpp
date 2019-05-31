#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define n 100000 //Tamanho do vetor a ser gerado

int partition(int array[], int p, int r) {
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

void insertionSort (int vetor[],int low, int high){
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

void hybridQuickSort(int array[], int p, int r) {
    if (p < r) {
    	if(r - p < 10){
			insertionSort(array, p, r);
		} else {
			int q = partition(array, p, r);
	        hybridQuickSort(array, p, q - 1);
	        hybridQuickSort(array, q + 1, r);	
		}
    }
}

void quickSort(int array[], int p, int r) {
    if (p < r) {
		int q = partition(array, p, r);
	    quickSort(array, p, q - 1);
		quickSort(array, q + 1, r);	
	}
}

void genereateArray(int vetor[]){
   FILE *f = fopen("NumbersSamples.txt", "r");
	
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
	printf("Quick Sort\n\n");
	srand( (unsigned)time( NULL ) );
	
	int op;
	
	printf("Digite [1] para o QuickSort Normal ou [2] para o QuickSort Hybrid:\n");
	scanf("%d", &op);
	printf("%d Selecionado\n\n", op);
	clock_t t;

	int key = 0;
	int count = 0;
	while(count <= 100) { 
		int vetor[n];
		genereateArray(vetor);
		//printArray(vetor);
		//hybridQuickSort(vetor, 0, n - 1);
		if(op == 1){
			t = clock();
			quickSort(vetor, 0, n - 1);
			t = clock() - t;
		}
		if(op == 2){
			t = clock();
			hybridQuickSort(vetor, 0, n - 1);
			t = clock() - t;
		}
		
		float time_taken = ((float)t)/CLOCKS_PER_SEC;
		printf("%f\n", time_taken); 
		//printArray(vetor);
		//printf("\n");
		count++;
	}
	//getch();
	return 0;
}
