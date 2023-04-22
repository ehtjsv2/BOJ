import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int stack[]=new int[10000];
        int top=-1;
        int N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack[++top]=num;
            } else if (command.equals("top")) {
                if(top==-1){
                    System.out.println(-1);
                }
                else System.out.println(stack[top]);
            } else if (command.equals("size")) {
                System.out.println(top+1);
            } else if (command.equals("empty")) {
                if(top==-1){
                    System.out.println(1);
                }
                else System.out.println(0);
            } else if (command.equals("pop")) {
                if(top==-1)System.out.println(-1);
                else System.out.println(stack[top--]);
            } else {
                System.out.println("error");
            }
        }
    }
}