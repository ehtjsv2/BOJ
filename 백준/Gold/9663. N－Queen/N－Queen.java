import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] chess = new int[N + 1]; // 같은 행에는 퀸을 놓으면 정답이 아니기에 열의 번호만 저장하는 1차원배열로.
        bt(chess, 1);
        System.out.println(answer);
    }

    public static void bt(int[] chess, int depth) {
        if (depth > N) {
            answer++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            chess[depth] = i;
            if (existAttackableQueen(chess, depth) == false) { // 현재 깊이에서 부터 공격가능한 퀸이 존재하면 더 깊이가도 의미 X
                bt(chess, depth + 1);
            }
        }
    }

    public static boolean existAttackableQueen(int[] chess, int depth) {
        int now = chess[depth];
        for (int i = 1; i <= depth-1; i++) { // i는 행의 번호와 같음
            if(now == chess[i]){ // 세로 검증
                return true;
            }
            if(depth-i == Math.abs(now-chess[i])){ // 대각선 검증
                return true;
            }
        }
        return false;
    }
}
