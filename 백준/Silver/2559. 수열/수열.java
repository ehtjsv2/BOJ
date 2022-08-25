import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* N, K 입력받기 */
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        /* 온도수열 입력받기 */
        st=new StringTokenizer((br.readLine()));
        int []temp=new int[N];
        for(int i=0;i<N;i++){
            temp[i]=Integer.parseInt(st.nextToken());
        }

        /* 최대치 찾기, i+K-1가 N이상이면 종료 */
        int max=-2147483648;
        for(int i=0;i+K-1<N;i++){
            int sum=0;
            for(int j=i;j<i+K;j++){
                sum+=temp[j];
            }
            if(sum>max)max=sum;
        }
        System.out.println(max);
    }
}
