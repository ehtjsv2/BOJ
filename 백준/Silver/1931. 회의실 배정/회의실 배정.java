import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws NumberFormatException, IOException{
        int N;
        int times[][];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        times = new int[N][2];
        StringTokenizer st;

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            times[i][0]=Integer.parseInt(st.nextToken());
            times[i][1]=Integer.parseInt(st.nextToken());
        }
        /* 끝나는 시간 기준으로 정렬 */ 
        Arrays.sort(times,new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                else return o1[1]-o2[1];
            }
            
        });

        // for(int i=0;i<N;i++){
        //     System.out.println(times[i][0]+" ~ "+times[i][1]);
        // }
        /* 첫시간을 배정후, 순차적으로search-> start_time이 end_time보다 크거나같으면 회의에 배정 후 end_tiem update */
        int answer=0;
        int end_time=0;
        end_time=times[0][1];
        answer++;
        for(int i=1;i<N;i++){
            if(times[i][0]>=end_time){
                answer++;
                end_time=times[i][1];
            }
        }
        System.out.println(answer);

    }
}