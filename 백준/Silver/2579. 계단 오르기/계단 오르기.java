import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[] stairScore = new int[300];
    static int[][] dpScore = new int[300][2]; //0->이전계단 밟은 최대점수, 1->이전 계단 밟지 않은 최대점수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            stairScore[i] = num;
        }
        if(N==1){
            System.out.println(stairScore[0]);
        }
        else{
            // N부터 밟고 시작하며 0으로 진행한다(마지막 계단은 꼭 밟아야하므로.)
            dpScore[0][0] = stairScore[0];
            dpScore[0][1] = stairScore[0];

            dpScore[1][0] = stairScore[1] + dpScore[0][0]; // 이전 계단 밟음
            dpScore[1][1] = stairScore[1]; // 이전 밟지 않음

            // 계단 한개씩 진행하며 해당 계단을 밟았을 때 최대 점수를 구한다.
            // a번째 계단을 밟을 수 있는 경우는 a-1계단을 밟았거나 a-2계단을 밟았을 경우다.
            // a-1계단의 경우 a-1이 이전계단을 밟지 않은 점수만 고려해야한다.
            // a-2계단의 경우 이전계단 밟은 최대점수와 이전계단 밟지 않은 최대점수 중 높은 점수를 반영하면된다.
            for (int i = 2; i < N; i++) {
                int bfMaxScore = dpScore[i - 1][1]; // 이전 계단 최대점수
                int bfbfMaxScore = Math.max(dpScore[i - 2][0], dpScore[i - 2][1]); // 이전이전 계단 최대점수
                dpScore[i][0] = stairScore[i] + bfMaxScore;
                dpScore[i][1] = stairScore[i] + bfbfMaxScore;
            }
            System.out.println(Math.max(dpScore[N-1][0],dpScore[N-1][1]));
        }
    }
}
