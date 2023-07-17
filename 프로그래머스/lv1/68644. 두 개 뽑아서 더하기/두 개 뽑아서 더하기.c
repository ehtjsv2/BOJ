#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>


bool check(int a[],int number, int leng){
    for(int i=0;i<leng;i++){
        if(a[i]==number)return false;
    }
    return true;
}
void Merge (int a[], int Left, int mid, int Right){
    //printf("Merge:Left=%d mid=%d Right=%d\n",Left,mid,Right);
    int index=Left;
    int p=Left;
    int q=mid+1;
    int* repl = (int*)malloc(sizeof(int)*100000);
    while(p<=mid&&q<=Right){
        if(a[p]<=a[q])repl[index++]=a[p++];
        else repl[index++]=a[q++];
    }
    while(p<=mid)repl[index++]=a[p++];
    while(q<=Right)repl[index++]=a[q++];
   
for(int j=Left;j<=Right;j++){
        a[j]=repl[j];
    }
    free(repl);
}

void Merge_Sort(int a[],int Left, int Right){
   // printf("Merge_Sort\n");
    if(Left<Right){
        int mid=(Left+Right)/2;
        Merge_Sort(a,Left,mid);
        Merge_Sort(a,mid+1,Right);
        
        Merge(a,Left,mid,Right);
    }
}

// numbers_len은 배열 numbers의 길이입니다.
int* solution(int numbers[], size_t numbers_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int)*10000);
    int cnt=0;
    for(int i=0;i<numbers_len;i++){
        for(int j=i+1;j<numbers_len;j++){
            if(check(answer,numbers[i]+numbers[j],cnt)){
                printf("%d ",numbers[i]+numbers[j]);
                answer[cnt++]=numbers[i]+numbers[j];
            }
        }
    }
    printf("%d %d %d",answer[0], answer[1], answer[2]);
    
    Merge_Sort(answer,0,cnt-1);
    printf("\n");
    for(int i=0;answer[i]!=NULL;i++){
        printf("%d, ",answer[i]);
    }
    printf("%d %d %d",answer[0], answer[1], answer[2]);
    return answer;
}