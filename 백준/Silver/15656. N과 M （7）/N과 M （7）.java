import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < N; i++) {
            bt(1,String.valueOf(list.get(i)));
        }

        System.out.println(sb.toString());
    }

    public static void bt(int depth, String s) {
        if(depth>=M){
            sb.append(s+"\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            bt(depth+1,s+" "+list.get(i));
        }
    }
}
