import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack<Integer> stack =new Stack<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            String command=st.nextToken();
            if(command.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("empty")){
                if(stack.empty()){
                    System.out.println("1");
                }
                else System.out.println("0");
            }
            else if(command.equals("pop")){
                if(stack.empty()){
                    System.out.println("-1");
                }
                else System.out.println(stack.pop());
            }
            else if(command.equals("size")){
                System.out.println(stack.size());
            }
            else {
                if(stack.empty()){
                    System.out.println("-1");
                }
                else System.out.println(stack.peek());
            }
        }
    }
}
