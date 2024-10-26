import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Dot start = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Dot end = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int circleHasStartDotCount = 0;
            int circleHasEndDotCount = 0;
            int cirCount = Integer.parseInt(br.readLine());
            for (int j = 0; j < cirCount; j++) {
                st = new StringTokenizer(br.readLine());
                Dot dot = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                int distance = Integer.parseInt(st.nextToken());
                boolean hasStartDot = start.calDistance(dot) < distance;
                boolean hasEndDot = end.calDistance(dot) < distance;
                if(hasStartDot && !hasEndDot){
                    circleHasStartDotCount++;
                }
                if(!hasStartDot && hasEndDot){
                    circleHasEndDotCount++;
                }
            }
            System.out.println(circleHasEndDotCount+circleHasStartDotCount);
        }
    }

    public static class Dot {
        double x;
        double y;

        public Dot(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double calDistance(Dot other) {
            return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
        }
    }
}
