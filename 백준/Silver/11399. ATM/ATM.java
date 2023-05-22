import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int time[]=new int[N];
        int result=0;

        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            time[i]=Integer.parseInt(st.nextToken());
        }
        //정렬
        Arrays.sort(time);
        
        int add=0;
        //add=pre_add+time[i]
        for(int i=0;i<N;i++){
            add = add+time[i];
            result +=add;
        }
        System.out.println(result);
    }
}
