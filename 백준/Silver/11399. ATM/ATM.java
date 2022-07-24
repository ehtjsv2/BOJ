import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N,answer=0; // N 사람수, answer 답
		String str; // 시간pi를 받을 배열
		N=sc.nextInt();
		sc.nextLine();
		str=sc.nextLine();
		
		String[] array=str.split(" "); // 공백단위로 잘라서 배열에 저장
		
		int[] array2=new int[N]; // 정수형 배열선언
		int wait=0;
		
		for(int i=0;i<N;i++) {
			array2[i]=Integer.parseInt(array[i]); //문자 배열을 정수배열로 이동
		}
		
		Arrays.sort(array2); // 오름차순으로 정렬
		
		for(int i=0;i<N;i++) {
			answer=answer+wait+array2[i]; //총+ 본인이 기다린시간+ 본인 인출시간
			wait=wait+array2[i]; // 다음 사람이 기다릴 시간 동기화
		}
		
		System.out.println(answer);

	}
}