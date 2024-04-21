import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Integer, Boolean> broken;
    static String channel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        channel = br.readLine();
        int N = Integer.parseInt(channel); // 최대 500,000
        int M = Integer.parseInt(br.readLine());

        // 초기화
        broken = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            broken.put(i, false);
        }
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int brokenNum = Integer.parseInt(st.nextToken());
                broken.replace(brokenNum, true);
            }
        }
        int initialLowChannel = N;
        int initialHighChannel = N;
        // 아래로
        while (initialLowChannel >= 0 && !can(initialLowChannel)) {
            initialLowChannel--;
        }
        // 위로
        while (!can(initialHighChannel) && initialHighChannel<=1_000_000) {
            initialHighChannel++;
        }
        int lowChannelAnswer;
        int highChannelAnswer = initialHighChannel - N + String.valueOf(initialHighChannel).length();
        if (initialLowChannel < 0) {
            lowChannelAnswer = Integer.MAX_VALUE;
        } else {
            lowChannelAnswer = N - initialLowChannel + String.valueOf(initialLowChannel).length();
        }

        int hundredChannelAnswer = Math.abs(100 - N);
        int initialChannelAnswer = Math.min(lowChannelAnswer, highChannelAnswer);
        int answer = Math.min(hundredChannelAnswer, initialChannelAnswer);
        System.out.println(answer);
    }

    private static boolean can(int initialChannel) {
        String channelS = String.valueOf(initialChannel);
        for (int i = 0; i < channelS.length(); i++) {
            if (broken.get(channelS.charAt(i) - '0') == true) {
                return false;
            }
        }
        return true;
    }
}