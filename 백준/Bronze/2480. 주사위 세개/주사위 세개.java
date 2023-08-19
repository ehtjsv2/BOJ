import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dice[] = new int[7];
        for(int i=0;i<3;i++){
            dice[Integer.parseInt(st.nextToken())]++;
        }
        int maxCntDice=0;
        for(int i=1;i<7;i++){
            if(dice[i]>=dice[maxCntDice]) maxCntDice=i;
        }
        if(dice[maxCntDice]>=3){
            System.out.println(10000+maxCntDice*1000);
        }
        else if(dice[maxCntDice]>=2){
            System.out.println(1000+maxCntDice*100);
        }
        else System.out.println(maxCntDice*100);
        
    }
}
