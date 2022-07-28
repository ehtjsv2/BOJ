import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer=0;
		int N=Integer.parseInt(st.nextToken()); // 동전가치 개수
		int K=Integer.parseInt(st.nextToken());	// Money
		
		int A[]= new int[N];
		
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(br.readLine()); // 가치 입력받기
		}
		for(int i=N-1;i>=0;i--) { // 제일 가치큰 것부터 몫구하기
			answer+=K/A[i]; // 동전=동전+남은Money/현재 돈의가치(큰거부터)
			K=K%A[i]; // 남은돈= 남은돈%현재 돈의가치
			if(K==0)break; // 남은돈이 0이면 그만하기
		}
		System.out.println(answer);
	}
}