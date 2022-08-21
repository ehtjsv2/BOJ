import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int[][] arr= new int[N][2]; // 좌표받을 배열

        /* 좌표받기 */
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                 if(o1[0] == o2[0]) {
                         return o1[1] - o2[1];
                 }else {
                     return o1[0] - o2[0]; 
                 }
               }
        });
        for(int i=0;i<N;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
    }
}