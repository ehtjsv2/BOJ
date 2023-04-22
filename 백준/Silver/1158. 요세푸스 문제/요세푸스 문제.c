#include <stdio.h>
#include <stdlib.h>

typedef struct node{
  int data;
  struct node* back;
  struct node* next;
}node;

typedef struct linkedList{
  node *head;
}linkedList;

linkedList *List;

node* Creat_Node(int data){
  node* newNode=(node*)malloc(sizeof(node));
  newNode->data=data;
  newNode->back=NULL;
  newNode->next=NULL;
  return newNode;
}

void Input(int Max){
  node *newNode=Creat_Node(1);
  List->head=newNode;
  node *p=List->head;
  for(int i=2;i<Max;i++){
    node *newNode;
    newNode=Creat_Node(i);
    newNode->back=p;
    p->next=newNode;
    p=p->next;
  }
  newNode=Creat_Node(Max);
  newNode->back=p;
  p->next=newNode;
  newNode->next=List->head;
  List->head->back=newNode;
}

void Print_List(int Max){
  node *horse;
  horse=List->head;
  for(int i=0;i<=Max;i++){
    printf("%d -> ",horse->data);
    horse=horse->next;
  }
}

int main(void) {
  List=(linkedList*)malloc(sizeof(linkedList));
  int N,Max;
  int cnt=0;
  scanf("%d %d ",&Max, &N);
  if(Max==1){
      printf("<1>");
      return 0;
  }
  Input(Max);
  //Print_List(Max);
  node *p, *old_p;
  p=List->head;
  for(int i=0;i<N-1;i++){
      p=p->next;
  }
 // old_p=p;
  printf("<%d, ",p->data);
  p->next->back=p->back;
  p->back->next=p->next;
  for(int i=0;i<N;i++){
      p=p->next;
  }
  //free(old_p);
  for(int i=1;i<Max-1;i++){
    printf("%d, ",p->data);
    p->next->back=p->back;
    p->back->next=p->next;
   for(int i=0;i<N;i++){
      p=p->next;
    }
  }
  printf("%d>",p->data);
  return 0;
}