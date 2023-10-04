import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //int card[] = new int[N];
        ArrayList<Integer> card = new ArrayList<Integer>();        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)card.add(Integer.parseInt(st.nextToken()));
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int num[] = new int[M];
        int answer[] = new int[M];
        for(int i=0;i<M;i++)num[i]=Integer.parseInt(st.nextToken());


        //정렬
        Collections.sort(card);
        //이진탐색
        for(int i=0;i<M;i++){
            answer[i]=binarySearch(card, num[i]);
        }
        for(int i=0;i<M;i++)System.out.print(answer[i]+" ");
    }

    static int binarySearch(ArrayList<Integer> list, int num){
        int low = 0;
        int high = list.size()-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(list.get(mid)==num)return 1;
            if(list.get(mid)>num){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return 0;
    }
}
