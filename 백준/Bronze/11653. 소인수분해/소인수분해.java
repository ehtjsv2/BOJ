import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(N>1){
            for(int i=2;i<=N;i++){
                if(N%i==0){
                    list.add(i);
                    N=N/i;
                    break;
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++)sb.append(list.get(i)+"\n");
        System.out.println(sb.toString());
    }
}