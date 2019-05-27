#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define n 1000000

int main(){
	srand( (unsigned)time( NULL ) );
	
	FILE *f = fopen("Goiaba.txt", "w");
	
	for (int i = 0; i < n; ++i) {
      fprintf(f, "%d\n", rand());
   	}
	
	fclose(f);
	
	
	return 0;
}
