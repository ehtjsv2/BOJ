
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean visited[] = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0);
        } else {
            int time = 0;
            List<Integer> list = new ArrayList<>();
            list.add(N);
            int start = 0;
            int end = 0;
            int plusEndCount = 0;
            while (visited[K] == false) {
                time++;
                int oldEnd = end;
//                System.out.println("start = " + start + ", end = " + end);
                for (int i = start; i <= end; i++) {
//                    System.out.println("search = " + list.get(i));
                    int searchNum = list.get(i);
                    //-1
                    if (!(searchNum - 1 < 0) && visited[searchNum - 1] == false) {
                        list.add(searchNum - 1);
                        visited[searchNum - 1] = true;
                        plusEndCount++;
                    }
                    //+1
                    if (!(searchNum + 1 > 100_000) && visited[searchNum + 1] == false) {
                        list.add(searchNum + 1);
                        visited[searchNum + 1] = true;
                        plusEndCount++;
                    }
                    //*2
                    if (!(searchNum * 2 > 100_000) && visited[searchNum * 2] == false) {
                        list.add(searchNum * 2);
                        visited[searchNum * 2] = true;
                        plusEndCount++;
                    }
                }
                start = oldEnd + 1;
                end = end + plusEndCount;
                plusEndCount = 0;
            }
            System.out.println(time);
        }
    }
}
