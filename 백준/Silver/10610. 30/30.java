import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main{
    static String N; // 최대 10^5개 숫자이므로 String 처리
    static int answer=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=br.readLine();

        Integer[] inputArray = new Integer[N.length()];
        int sum=0;
        int len = N.length();
        //0있는지 체크, integer배열에 숫자 담기
        for(int i=0;i<len;i++){
            int ch;
            ch=N.charAt(i)-'0';
            sum+=ch;
            inputArray[i]=ch;
        }

        //배열 내림차순으로 정렬
        Arrays.sort(inputArray, Collections.reverseOrder());
        //sum이 3의 배수이고 배열에 0이 포함되어있을 때
        if(sum%3==0 && inputArray[inputArray.length-1]==0){
            //배열을 출력
            StringBuffer sb= new StringBuffer();
            for(int i=0;i<len;i++){
                sb.append(inputArray[i]);
            }
            System.out.println(sb);
        }
        else{ // 그 외
            System.out.println("-1");
        }
    }
}