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
        int arr[]= new int[N+1];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            for(int j=first;j<=last;j++){
                arr[j]=number;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<arr.length;i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);
        
    }
}