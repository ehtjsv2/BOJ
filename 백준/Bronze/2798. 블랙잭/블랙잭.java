import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int card[]= new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0;i<N;i++){
            card[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N-2;i++){
            for(int j=i+1;j<N-1;j++){
                int sum = card[i];
                sum+=card[j];
                for(int k=j+1;k<N;k++){
                    
                    if(sum+card[k]>max && sum+card[k]<=M)max=sum+card[k];
                }
            }
        }
        System.out.println(max);


        

    }
}
