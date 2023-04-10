import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        /*입력할당*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        int num_team=0;

        /* 인턴 생각않고, 최대팀 구하기 */
        while(N>=2 && M>=1){
            num_team++;
            N-=2;
            M-=1;
        }

        /* 인턴수만큼 학생빼기(팀에 배정되지않은 인원부터, 모두 배정되었다면 팀-1 하고 여자+2 남자+1) */
        while(K>0){
            if(N>0){
                N--;
                K--;
            }
            else if(M>0){
                M--;
                K--;
            }
            else{
                if(num_team>0){
                    num_team--;
                    N+=2;
                    M+=1;
                }
                else{
                    break;     
                }
            }
        }
        answer=num_team;
        System.out.println(answer);
    }
}
