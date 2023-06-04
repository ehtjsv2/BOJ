
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int visited[];
    static Queue<Integer> Q=new LinkedList<>();
    static Stack<Integer> S=new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st =new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int initial_visit=Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph =new ArrayList<ArrayList<Integer>>();
        visited=new int[N+1];

        for(int i=0;i<=N;i++)// 1부터라 인덱스5까지가능하게.
        {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            putEdge(graph, x, y);
        }
        
        
       
        for(int i=1;i<=N;i++){
            Collections.sort(graph.get(i));
        }
        //printGraph(graph);
        
        DFS(graph,initial_visit);
        visited=new int[N+1];
        BFS(graph,initial_visit);
    }

    static void putEdge(ArrayList<ArrayList<Integer>> G,int x,int y){
        G.get(x).add(y);
        G.get(y).add(x);
    }
    static void printGraph(ArrayList<ArrayList<Integer>> G){
        for(int i=1;i<=N;i++){
            System.out.print("node["+i+"] : ");
            for(int j=0;j<G.get(i).size();j++){
                System.out.print(G.get(i).get(j)+"->");
            }
            System.out.println();
        }
    }

    static void BFS(ArrayList<ArrayList<Integer>> G, int initial_visit) {
        if(G.get(initial_visit).size()==0){
            System.out.println(initial_visit);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = initial_visit;
        sb.append(Integer.toString(i));
        sb.append(" ");
        visited[i] = 1;
        Q.add(i);
        while (Q.peek() != null) {
            int visit = Q.poll();
            for (int j = 0; j < G.get(visit).size(); j++) {
                if (visited[G.get(visit).get(j)] != 1) {
                    Q.add(G.get(visit).get(j));
                    sb.append(Integer.toString(G.get(visit).get(j)));
                    sb.append(" ");
                    visited[G.get(visit).get(j)] = 1;
                }
            }
        }
        System.out.println(sb.toString());
    }
    static void DFS(ArrayList<ArrayList<Integer>> G, int initial_visit){
        if(G.get(initial_visit).size()==0){
            System.out.println(initial_visit);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i= initial_visit;
        S.push(i);
        sb.append(Integer.toString(i));
        sb.append(" ");
        visited[i]=1;
        while(!S.empty()){
            int visit=S.peek();
            for(int j=0;j<G.get(visit).size();j++){
                if(visited[G.get(visit).get(j)]!=1){
                    visit=G.get(visit).get(j);
                    S.push(visit);
                    sb.append(Integer.toString(visit));
                    sb.append(" ");
                    visited[visit]=1;
                    break;
                }
                if(j==G.get(visit).size()-1){
                    S.pop();
                }
            }
        }
        System.out.println(sb.toString());
    }
}
