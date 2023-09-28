import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr1[i]=Integer.parseInt(st.nextToken());
            arr2[i]=arr1[i];
        }

        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        //정렬
        Arrays.sort(arr1);
        int rank=0;
        //등수 설정
        for(int i=0;i<N;i++){
            int j=i;
            //같은 숫자 생략
            while(arr1[i]==arr1[j]){
                j++;
                if(j>=N)break;
            }
            hm.put(arr1[i], rank);
            rank++;
            i=j-1;
        }
        // 원본 배열 기준 출력
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(hm.get(arr2[i])+" ");
        }
        System.out.println(sb.toString());

    }
}
