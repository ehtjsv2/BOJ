import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int N = Integer.parseInt(st.nextToken());
        // int M = Integer.parseInt(st.nextToken());
        boolean arr[]= new boolean[42];
        for(int i=0;i<10;i++) {
            int num = Integer.parseInt(br.readLine())%42;
            arr[num]=true;
        }
        int answer=0;
        for(int i=0;i<42;i++){
            if(arr[i]==true)answer++;
        }
        System.out.println(answer);
        
    }
}