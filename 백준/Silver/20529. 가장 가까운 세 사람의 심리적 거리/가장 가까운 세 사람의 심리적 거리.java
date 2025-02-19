import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            List<String> mbtis = new ArrayList<>();
            Map<String, Integer> mbtiCount = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String mbti = st.nextToken();
                mbtiCount.put(mbti, mbtiCount.getOrDefault(mbti, 0) + 1);
                if(mbtiCount.get(mbti)<=3){
                    mbtis.add(mbti);
                }
            }
            
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < mbtis.size(); i++) {
                String first = mbtis.get(i);
                for (int j = i + 1; j < mbtis.size(); j++) {
                    String second = mbtis.get(j);
                    for (int k = j + 1; k < mbtis.size(); k++) {
                        String third = mbtis.get(k);
                        int distance = 0;
                        distance += getDistance(first, second);
                        distance += getDistance(first, third);
                        distance += getDistance(third, second);
                        if (distance < minDistance) {
                            minDistance = distance;
                        }
                    }
                }
            }
            System.out.println(minDistance);
        }


    }

    public static int getDistance(String a, String b) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
