
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10001;i++){
            if(arr[i]!=0){
                int end = arr[i];
                for(int j=0;j<end;j++){
                    sb.append(i+"\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
