#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>


int solution(int n) {
    int answer = 0;
    int *a=(int*)malloc(sizeof(int)*100);
    int *b=(int*)malloc(sizeof(int)*100);
    int i=0;
    int j=0;
    while(n>=3){
        a[i++]=n%3;
        n=n/3;
    }
    a[i]=n;
    i+=1;
    
    for(int k=0;k<i;k++){
        answer+=pow(3,k)*a[i-1-k];
    }
    return answer;
}
/*
 for(int s=0;s<i;s++){
        printf("%d ",a[s]);
    }
    int af;
    
printf("%d",i);
    printf("\n");
 af=(pow(3,k)*a[i-1-k]);
        printf("%d\n",af);
*/