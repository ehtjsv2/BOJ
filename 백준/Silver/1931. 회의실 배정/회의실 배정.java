import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int answer=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] TIME = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            TIME[i][0] = Integer.parseInt(st.nextToken());
            TIME[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(TIME, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                 if(o1[1] == o2[1]) {
                         return o1[0] - o2[0];
                 }else {
                     return o1[1] - o2[1]; 
                 }
               }
            });
            
        int accept_end_time=TIME[0][1];
        answer=1;
        for(int i=1;i<N;i++){
            if(TIME[i][0]==TIME[i][1]){
                accept_end_time=TIME[i][1];
                answer++;
            }
            else if(TIME[i][0]>=accept_end_time){
                accept_end_time=TIME[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
