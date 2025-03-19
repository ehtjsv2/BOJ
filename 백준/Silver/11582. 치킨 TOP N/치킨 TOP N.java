import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int nPerK = N / k;

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nPerK; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            list.sort(Comparator.naturalOrder());
            for (int j = 0; j < nPerK; j++) {
                answer.append(list.get(j)+" ");
            }
        }
        System.out.println(answer);
    }
}
