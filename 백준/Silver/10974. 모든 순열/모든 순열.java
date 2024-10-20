import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N+1];
            visited[i] = true;
            bt(String.valueOf(i),2,visited);
        }

        System.out.println(sb);
    }

    public static void bt(String out, int depth, boolean[] visited){
        if(depth > N){
            sb.append(out).append("\n");
        }
        for (int j = 1; j <= N; j++) {
            boolean[] copyVisited = visited.clone();
            if(copyVisited[j] == false){
                copyVisited[j] = true;
                bt(out+" "+j,depth+1, copyVisited);
            }
        }
    }
}
