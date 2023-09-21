import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = 0;i<N;i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            sb.append(num+"\n");
        }
        System.out.println(sb.toString());
        
    }

}