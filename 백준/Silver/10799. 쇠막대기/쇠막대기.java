import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int answer=0;
        int isLazer=1;
        int Lbk=0;
        for(int i=0;i<len;i++){
            if(str.charAt(i)=='('){
                Lbk++;
                isLazer=1;
            }
            else{
                if(isLazer==1){
                    isLazer=0;
                    Lbk--;
                    answer=answer+Lbk;
                }
                else{
                    answer=answer+1;
                    Lbk--;
                }
                
            }
        }
        System.out.println(answer);
    }
}
