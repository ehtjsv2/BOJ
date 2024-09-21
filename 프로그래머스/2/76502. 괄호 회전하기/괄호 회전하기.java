import java.util.*;

class Solution {
    
    final static int SMALL = 0;
    final static int MEDIUM = 1;
    final static int LARGE = 2;
    
    public int solution(String s) {
        int answer = 0;
        Deque<Character> dq = new ArrayDeque<>();
        
        boolean isAnswer = true;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            dq.addLast(c);
        }        
        
        for(int i=0; i<s.length(); i++){
            if(isAnswer(dq)){
                answer++;
            }
            dq.addLast(dq.removeFirst());
        }
        
        return answer;
    }
    
    public static boolean isAnswer(Deque<Character> dq){
        if(dq.size()==1){
            return false;
        }
        Stack<Character> st = new Stack<>();
        boolean isAnswer = true;
        for(int i=0; i<dq.size(); i++){
            char c = dq.removeFirst();
            dq.addLast(c);
            if(c=='['){
                st.push('[');
            }
            if(c=='{'){
                st.push('{');
            }
            if(c=='('){
                st.push('(');
            }
            if(c==']'){
                if(st.isEmpty() || st.pop()!='['){
                    isAnswer = false;
                }
            }
            if(c=='}'){
                if(st.isEmpty() || st.pop()!='{'){
                    isAnswer = false;
                }
            }if(c==')'){
                if(st.isEmpty() || st.pop()!='('){
                    isAnswer = false;
                }
            }
        }
        if(!st.isEmpty()){
            isAnswer = false;
        }
        return isAnswer;
    }
}