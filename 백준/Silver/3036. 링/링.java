import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /* N입력받기 */
        int N=Integer.parseInt(st.nextToken());

        /* 링 반지름들 입력받기 */
        int []ring= new int[N];
        st= new StringTokenizer((br.readLine()));
        for(int i=0;i<N;i++){
            ring[i]=Integer.parseInt(st.nextToken());
        }

        /* 유클리드 호제법으로 ring1과 ring[i]들 간의 최대공약수 구하기 */
        int []GCD = new int[N];
        for(int i=1;i<N;i++){
            int remainder=ring[0]%ring[i];
            int a=ring[i];
            while(remainder!=0){
                int preremainder=remainder;
                remainder=a%remainder;
                a=preremainder;
            }
            GCD[i]=a;
        }

        /* 최대공약수로 나눈몫 몫1/몫2 출력하기 */
        int quot[][]= new int[N][2];
        for(int i=1;i<N;i++){
            quot[i][0]=ring[0]/GCD[i];
            quot[i][1]=ring[i]/GCD[i];
        }
        for(int i=1;i<N;i++){
            System.out.println(quot[i][0]+"/"+quot[i][1]);
        }
    }
}