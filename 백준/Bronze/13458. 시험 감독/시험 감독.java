import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Long answer = 0L;
        for (int i = 0; i < N; i++) {
            int candidateN = A.get(i);
            candidateN -= B;
            answer++;
            if (candidateN > 0) {
                answer += candidateN / C;
                if (candidateN % C != 0) {
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }
}