import java.util.*;
import java.io.*;


class Main
{
	static Stack<Integer> stack = new Stack<Integer>();
	static int N;
	static int[][] computer;
	static int[] visited;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		computer = new int[N+1][N+1];
		visited = new int [N+1];
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			computer[a][b] = 1;	
			computer[b][a] = 1;
		}
		DFS(1);
		int sum = 0;
		for(int i=1;i<=N;i++) {
			if(visited[i]!=0)sum++;
		}
		System.out.println(sum-1);
	}
	
	public static void DFS(int visit) {
		visited[visit] = 1;
		for(int i=1;i<=N;i++) {
			if(computer[visit][i]==1 && visited[i]==0) {
				DFS(i);
			}
		}
	}
}