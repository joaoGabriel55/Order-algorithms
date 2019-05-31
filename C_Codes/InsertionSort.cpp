#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define n 100000 //Tamanho do vetor a ser gerado

void sort (int vetor[]){
	int key = 0;
	for(int j = 0; j < n; j++) {
		int i = 0;
		key = vetor[j];
		i = j - 1;
		while(i >= 0 && vetor[i] > key) {
			vetor[i + 1] = vetor[i];
			i = i - 1;
		}
		vetor[i + 1] = key;
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
	printf("Insertion Sort\n\n");
	
	srand( (unsigned)time( NULL ) );
	
	clock_t t;
	
	int count = 0;
	while(count <= 100){
		int vetor[n];
		genereateArray(vetor);
		//printArray(vetor);
		t = clock();
		sort(vetor);
		t = clock() - t;
		float time_taken = ((float)t)/CLOCKS_PER_SEC;
		printf("%f\n", time_taken); 
		//printArray(vetor);
		//printf("\n");
		count++;
	}
	return 0;
}
