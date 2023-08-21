
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        // int M = Integer.parseInt(st.nextToken());
        double arr[]= new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = 0;
        for(int i=0;i<N;i++){
            arr[i] = Double.parseDouble(st.nextToken());
            if(arr[i]>max)max=arr[i];
        }
        double sum =0;
        for(double num : arr){
            sum+=num;
        }
        double answer = sum / max * 100/arr.length;
        System.out.println(answer);
    }
}