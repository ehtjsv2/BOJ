import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int join = Integer.parseInt(st.nextToken());
                if(join == 1){
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int parent = findParent(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < M-1; i++) {
            if(parent != findParent(Integer.parseInt(st.nextToken()))){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static boolean union(int x, int y){
        x = findParent(x);
        y = findParent(y);

        if(x==y){
            return false;
        }

        if(x<=y){
            arr[y] = x;
        }else{
            arr[x] = y;
        }
        return true;
    }

    public static int findParent(int x){
        if(arr[x] == x){
            return x;
        }
        return findParent(arr[x]);
    }
}
