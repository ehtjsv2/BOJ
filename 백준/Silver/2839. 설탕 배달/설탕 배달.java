import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N,n; // N무게, n나머지
		int a; // 5키로봉지 개수
		N=sc.nextInt();
		a=N/5;
		while(true) {
			n=N-5*a; // 나머지는 무게-현재5키로짜리봉지개수*5
			if(a==0&&n%3!=0) { // 5키로 봉지 0개되고 그때마저 3키로봉지로 딱 안떨어지면
				System.out.println("-1");
				break;
			}
			if(n%3==0) {
				System.out.format("%d",(a+n/3));
				break;
			}
			else a--;
		}
		
	}

}
