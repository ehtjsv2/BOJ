import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> list;
    static int last = -1;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<Integer>();

        /* 최소힙을 유지하며 숫자 insert , 0나오면 인덱스0 출력후 last인덱스를 0으로 옮기고 다시 heap*/
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
               deleteNum();
              // printList();
            } 
            else {
                addNum(num);
               /// printList();
            }
        }
    }
    static void printList(){
        for(int i=0;i<=last;i++){
            System.out.print(list.get(i));
        }
        System.out.println();
       // System.out.println("last = "+last);
    }
    static void deleteNum(){
        if(last<0){ // 리스트가 비었을 때
            System.out.println("0");
        }
        else{ // 안비었을 때
            int remove_num=list.get(0);
            System.out.println(remove_num);

            if(last==0){ // 원소가 혼자 였을 때
                last--;
                list.remove(0);
            }
            else{ // 두개 이상일 때
                int last_num=list.get(last);

                list.remove(last);
                last--;

                list.set(0, last_num);

                int me_index=0;
                int child_index=0;

                while (hasChild(list, me_index, last)>0) { // 자식이 있을 때까지
                    //printList();
                    if(hasChild(list, me_index, last)==1){// 왼쪽 자식만 있을 경우
                        if(list.get(me_index*2+1)<list.get(me_index)){
                            child_index=me_index*2+1;
                            int tmp=list.get(me_index);
                            list.set(me_index, list.get(child_index));
                            list.set(child_index, tmp);
                            me_index=child_index;
                        }
                        else break;
                    }
                    else if(hasChild(list, me_index, last)==2){ // 오른쪽 자식까지 있을 경우
                        if(list.get((me_index*2)+1)<list.get((me_index*2)+2)){ // 왼쪽 자식이 오른쪽 자식보다 작을 경우
                            child_index=me_index*2+1;
                        }
                        else child_index=me_index*2+2; // 클 경우
                        if(list.get(child_index)<list.get(me_index)){ // 자식이 본인보다 작을 경우
                            int tmp=list.get(me_index);
                            list.set(me_index, list.get(child_index));
                            list.set(child_index, tmp);
                            me_index=child_index;
                        }
                        else break; // 자신이 더 작을 경우
                    }
                    else break;
                }  
            }
            
        }
    }
    static void addNum(int num) {
        list.add(num);
        last++;

        int me = last;
        int parent = (me - 1) / 2;
        while (me > 0) {
            int me_num = list.get(me);
            int parent_num = list.get(parent);
            if (me_num < parent_num) {
                list.set(parent, me_num);
                list.set(me, parent_num);
                me = parent;
                parent = (me - 1) / 2;
            } else
                break;
        }
    }

    static int hasChild(ArrayList<Integer> list, int index, int last) {
            if(index*2+2<=last){
                return 2;
            }
            else if(index*2+1<=last){
                return 1;
            }
            else return 0;
    }
}
