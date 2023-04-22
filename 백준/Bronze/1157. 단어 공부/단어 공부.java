import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s=st.nextToken();
        char[] arr = s.toCharArray();   // 문자를 배열에 저장
        int len = s.length();   // 배열의 길이저장
        int[] answer= new int[26];  // A~Z까지 0~26공간 0으로 초기화
        int max=0;  // 제일 많은 문자가 있는 인덱스, 초기에 0으로(A로되어있음)
        int over=0; // 0은 max가 두개이상이아님 1은 두개이상
        
        /* 문자열을 0부터 확인하면서 A~Z 배열에 1씩추가 */
        for(int i=0;i<len;i++){
            if(arr[i]>90) arr[i]-=32; // 소문자는 대문자로변환
            answer[arr[i]-65]++;
        }
        /* max찾기 */
        for(int i=1;i<26;i++){ // 초기 max는 A로 지정되있으므로 B부터
            if(answer[i]>answer[max])
            {
                over=0; // 새로운 max나오면 over 초기화
                max=i;
            }
            else if(answer[i]==answer[max]){ // 같은거 나오면 max 2개이상이라고 알림
                over=1;
            }
        }
        if(over==1){
            System.out.println("?");
        }
        else{
            System.out.println((char)(max+65));
        }
    }
}
