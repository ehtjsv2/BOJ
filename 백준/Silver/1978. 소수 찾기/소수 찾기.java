import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int []arr = new int[N];
        int answer=0;

        /* 정수 입력받기 */
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        /* arr[i]까지의 모든 자연수중에 1을제외하고 나눠지는 수 있는지 판별 */
        for(int i=0;i<N;i++){
            if(arr[i]==2){
                answer++;
                //System.out.println(arr[i]);
                continue;
            }
            for(int j=2;j<arr[i];j++){
                if(arr[i]%j==0)break;
                else if(j==arr[i]-1){
                  //System.out.println(arr[i]);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}