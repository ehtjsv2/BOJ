import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
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
                else{
                    if(o1[1]>o2[1]){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
            }
        });

//        for (int i = 0; i < N; i++) {
//            System.out.println(arr[i][0]+", "+arr[i][1]);
//        }

        int answer = 0;
        int last = arr[0][0];
        for (int i = 0; i < N; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if(start<=last){
                if(end>=last){
                    answer+=end-last;
                    last = end;
                }
            }
            else{
                answer+=end-start;
                last = end;
            }
        }

        System.out.println(answer);
    }
}
