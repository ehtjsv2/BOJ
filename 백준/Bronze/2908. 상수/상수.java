import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        char tmp ;
        // 배열로 변경
        char arrayA[] = a.toCharArray();
        char arrayB[] = b.toCharArray();
        // 스왑
        tmp = arrayA[2];
        arrayA[2]=arrayA[0];
        arrayA[0]=tmp;

        tmp = arrayB[2];
        arrayB[2]=arrayB[0];
        arrayB[0]=tmp;

        a=String.valueOf(arrayA);
        b=String.valueOf(arrayB);

        int intA=Integer.parseInt(a);
        int intB=Integer.parseInt(b);
        int max = (intA>intB)?intA:intB;
        
        System.out.println(max);
        
        
        
    }
}