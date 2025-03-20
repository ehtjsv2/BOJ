import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if(dq.isEmpty() || dq.peekLast() !=now){
                dq.addLast(now);
            }
            else{
                dq.removeLast();
            }
        }

        int answer = dq.size()>0?0:1;

        return answer;
    }
}