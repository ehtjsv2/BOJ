import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int dp[][]=new int[15][15];
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T,k,n;
        int result=0;
        //0층 초기화
        for(int i=1;i<15;i++)dp[0][i]=i;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            k=Integer.parseInt(br.readLine());
            n=Integer.parseInt(br.readLine());
            result = findMyNumOfPeoples(k, n);
            System.out.println(result);
        }   
    }
    
    public static int findMyNumOfPeoples(int floor, int room){
        
        if(dp[floor][room]==0){//아직 업데이트 되지 않은 dp일 경우
            for(int i=1;i<=room;i++){
                dp[floor][room]+=findMyNumOfPeoples(floor-1,i);
            }
            return dp[floor][room];
        }
        else{ //dp값이 있을 경우
            return dp[floor][room];
        }
    }
}