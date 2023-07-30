import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int dp[][];
    public static void main(String[] args) throws NumberFormatException, IOException {
        dp=new int[41][2];
        //[x][0]은 0호출 횟수, [x][1]은 1호출 횟수
        dp[0][0]=1;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=1;
        dp[2][0]=1;
        dp[2][1]=1;
        
        
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int result [] = findFiboCallCount(N);
            System.out.println(result[0]+" "+result[1]);
        }
        

    }

    public static int[] findFiboCallCount(int N){
        //N-1과 N-2의 finfivoCallCount를 조회해서 dp[N]에 업데이트한다.
        
        if(dp[N][0]==0 && dp[N][1]==0){//아직 업데이트 된 dp가 아닌 경우
            int zeroNOne1[] = findFiboCallCount(N-1);
            int zeroNOne2[] = findFiboCallCount(N-2);
            dp[N][0]+=zeroNOne1[0];
            dp[N][0]+=zeroNOne2[0];
            dp[N][1]+=zeroNOne1[1];
            dp[N][1]+=zeroNOne2[1];
            return new int[]{dp[N][0],dp[N][1]};
        }
        else {//업데이트 된 dp인경우
            return new int[]{dp[N][0],dp[N][1]};
        }
    }
}