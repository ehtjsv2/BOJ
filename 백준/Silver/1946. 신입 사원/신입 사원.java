import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]>o2[0]){
                        return 1;
                    }
                    else if(o1[0]<o2[0]){
                        return -1;
                    }
                    return 0;
                }
            });

            int answer =1;
            int minNum = arr[0][1];
            for (int j = 1; j < N; j++) { // 1등은 합격
                if(arr[j][1]<minNum){
                    answer++;
                    minNum = arr[j][1];
                }
            }
            System.out.println(answer);
        }


    }
}
