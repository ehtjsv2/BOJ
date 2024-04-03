
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<String> splitStrings = new ArrayList<>();
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (j + i <= input.length()) {
                    String str = input.substring(j, j + i);
                    splitStrings.add(str);
                }
            }
        }
        Set<String> set = new HashSet<>(splitStrings);
        System.out.println(set.size());
    }
}
