import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Node[] tree;
    static int[] levelToFirstIndex = new int[10_001];
    static int[] levelToLastIndex = new int[10_001];
    static int treeIndex = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree[parent] = new Node(-1, left, right);
        }
        for (int i = 1; i <= N; i++) {
            Node node = tree[i];
            if (node.right != -1) {
                tree[node.right].parent = i;
            }
            if (node.left != -1) {
                tree[node.left].parent = i;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (tree[i].parent == -1) {
                dfs(i, 1);
            }
        }

        int maxWidth = 0;
        int answerLevel = 0;
        for (int i = 1; i <= 10_001; i++) {
            if (levelToLastIndex[i] == 0) {
                break;
            }
            if (levelToLastIndex[i] != 0 && levelToFirstIndex[i] != 0) {
                if(levelToLastIndex[i] - levelToFirstIndex[i] + 1 > maxWidth){
                    answerLevel = i;
                    maxWidth = levelToLastIndex[i] - levelToFirstIndex[i] + 1;
                }
            }
        }

        System.out.println(answerLevel + " " + maxWidth);
    }

    private static void dfs(int num, int depth) {
        if (tree[num].left != -1) {
            dfs(tree[num].left, depth + 1);
        }

        if (levelToFirstIndex[depth] == 0) {
            levelToFirstIndex[depth] = treeIndex;
        }
        if (levelToLastIndex[depth] == 0) {
            levelToLastIndex[depth] = treeIndex;
        }
        if (levelToFirstIndex[depth] > treeIndex) {
            levelToFirstIndex[depth] = treeIndex;
        }
        if (levelToLastIndex[depth] < treeIndex) {
            levelToLastIndex[depth] = treeIndex;
        }
        treeIndex++;

        if (tree[num].right != -1) {
            dfs(tree[num].right, depth + 1);
        }
    }

    static class Node {
        int parent;
        int left;
        int right;

        Node(int parent, int left, int right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}
