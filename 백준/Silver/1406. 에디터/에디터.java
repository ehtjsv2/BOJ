import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str=br.readLine();
        /* linkedList 선언 */
        LinkedList list = new LinkedList();
        /* 초기문자 넣기 */
        for(int i=0;i<str.length();i++){
            list.P(str.charAt(i));
        }
        int cnt=Integer.parseInt(br.readLine());
        for(int i=0;i<cnt;i++){
            st=new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "L":list.L();break;
                case "D":list.D();break;    
                case "B":list.B();break;
                case "P":
                char ch = st.nextToken().charAt(0);
                list.P(ch);
                break;
                default:
                System.out.println("error!");
                    break;
            }
        }
        list.print();
        
        
    }

    public static class Node{
        char ch;
        Node next;
        Node pre;
        public Node(){
            next=null;
            pre=null;
            ch=0;
        }
        public Node(char ch){
            this.ch=ch;
            this.next=null;
            this.pre=null;
        }
        public void preNode(Node pre){
            this.pre=pre;
        }
        public void nextNode(Node next){
            this.next=next;
        }
    }

    public static class LinkedList{
        Node head;
        Node cursor;
        public LinkedList(){
            Node newNode=new Node();
            cursor = newNode;
            head=newNode;
            newNode.pre=null;
            newNode.next=null;
        }
        public void print(){
            Node horse=head;
            StringBuffer sb = new StringBuffer();
            while(horse.next!=null){
                //System.out.print(horse.ch);
                sb.append(horse.ch);
                horse=horse.next;
            }
            System.out.println(sb);
        }
        public void L(){
            if(cursor==head)return;
            else cursor=cursor.pre;
        }
        public void D(){
            if(cursor.next==null)return;
            else cursor=cursor.next;

        }
        public void P(char ch){
            Node newNode=new Node(ch);
            newNode.next=cursor;
            if(cursor==head)head=newNode;
            else {
                newNode.pre=cursor.pre;
                cursor.pre.next=newNode;
            }
            cursor.pre=newNode;
            
        }
        public void B(){
            if(cursor==head)return;
            if(cursor.pre==head){
                head=cursor;
                cursor.pre=null;
            }
            else{
                cursor.pre.pre.next=cursor;
                cursor.pre=cursor.pre.pre;
            }
        }
    }
}
