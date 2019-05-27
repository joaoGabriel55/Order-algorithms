#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define n 100000 //Tamanho do vetor a ser gerado

int left(int i) {return 2 * i + 1;}
int right(int i) {return 2 * i + 2;}

void maxHeapify(int array[], int size, int i) {
    int largest = i;
    int l = left(i);
    int r = right(i);

    if (l < size && array[l] > array[largest]) {
        largest = l;
    }

    if (r < size && array[r] > array[largest]) {
        largest = r;
    }

    if (largest != i) {
        int aux = array[i];
        array[i] = array[largest];
        array[largest] = aux;
        maxHeapify(array, size, largest);
    }
}

void buildMaxHeap(int array[], int size) {
    for (int i = size / 2 - 1; i >= 0; i--)
    	maxHeapify(array, size, i);        
}

void heapSort(int array[], int size) {
    buildMaxHeap(array, size);
    for (int i = size - 1; i >= 0; i--) {
        int aux = array[0];
        array[0] = array[i];
        array[i] = aux;
        maxHeapify(array, i, 0);
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
	printf("Heap Sort\n\n");
	srand( (unsigned)time( NULL ) );
	
	clock_t t;

	int key = 0;
	int count = 0;
	while(count <= 100){
		int vetor[n];
		genereateArray(vetor);
		//printArray(vetor);
		t = clock();
		heapSort(vetor, n);
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
