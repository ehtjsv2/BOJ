import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        List<String> positions = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            positions.add(getSortedPosition(input[i]));
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            String string = positions.get(i);
            for (int j = i+1; j < N; j++) {
                String string2 = positions.get(j);
                if(string.equals(string2)){
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static String getSortedPosition(String a) {
        boolean[] visited = new boolean['z'+1];
        String[] position = new String['z' + 1];
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (visited[ch] == true) {
                position[ch] = position[ch] + "," + i;
            } else {
                visited[ch] = true;
                position[ch] = String.valueOf(i);
            }
        }
        List<String> list = new ArrayList<>();
        for (String s : position) {
            if(s!=null){
                list.add(s);
            }
        }
        list.sort(Comparator.naturalOrder());
        return String.join(":", list);
    }
}

