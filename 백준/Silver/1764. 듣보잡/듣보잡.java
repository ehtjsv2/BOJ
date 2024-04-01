
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> nList= new HashSet<>();
        for (int i = 0; i < N; i++) {
            nList.add(br.readLine());
        }
        List<String> mList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < M; i++) {
            String mStr = br.readLine();
            if(nList.contains(mStr)){
                count++;
                mList.add(mStr);
            }
        }
        Collections.sort(mList);
        for (int i = 0; i < mList.size(); i++) {
            sb.append(mList.get(i)+"\n");
        }
        System.out.println(count);
        System.out.print(sb);
    }
}
