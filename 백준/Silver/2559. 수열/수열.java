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

        int max=Integer.MIN_VALUE;

        /* 최대치 찾기, i+K-1가 N이상이면 종료 */
        
        // for(int i=0;i+K-1<N;i++){
        //     int sum=0;
        //     for(int j=i;j<i+K;j++){
        //         sum+=temp[j];
        //     }
        //     if(sum>max)max=sum;
        // }

        /* 연산횟수 줄이고 max찾기 */
        int start=0,end=0;// 진행중인 첫과 끝 인덱스
        int cnt_k=0;    // K의 어느만큼 진행됐는지 카운트
        int sum=0;
        while(true){
            /* K만큼 더했다면 max인지 확인하고, 현재합의 첫인덱스 빼기*/
            if(cnt_k>=K){ 
                if(sum>max)max=sum;
                sum-=temp[start++];
            }
            
            /* 마지막인덱스까지 한번 더했다면 끝임 */
            if(end==N)break;

            /* 합구하기 */
            sum+=temp[end++];
            cnt_k++;
        }
        System.out.println(max);
    }
}
