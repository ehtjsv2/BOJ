import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] visited;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited=new int[N+1];
        array=new int[N];
        recur(0);
    }
    /* 백트래킹 */
    static void recur(int index){
        /* M개를 다골랐을경우 */
        if(index>M-1){
            /* 출력 */
            for(int i=0;i<M;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
            return;
        }
        /* 1~N까지 하나씩 array에 집어넣기. 단, 방문했으면 하지않는다. */
        for(int i=1;i<=N;i++){
            if(visited[i]==0){
                visited[i]=1;
                array[index]=i;
                recur(index+1);
                visited[i]=0;
            }
        }
        return ;
    }
}
