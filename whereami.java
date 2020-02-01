import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class whereami {

    private static String input;
    private static int N;

    public static boolean doesThisWork(int k) {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < input.length() - k + 1; i++) {
            String newString = input.substring(i, i + k);
            if (list.contains(newString))
                return false;
            else
                list.add(newString);
        }
//        System.out.println(list);
        return true;
    }

    public static int compute() {
        boolean bool = true;
        int K = 1;
        while (bool) {
            if (doesThisWork(K)) {
                bool = false;
                break;
            } else
                K++;
        }
        return K;
    }

    public static void main(String[] DEEPANSHAISAWESOME) throws IOException {

        // read standard input
        BufferedReader in = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter out = new PrintWriter(new File("whereami.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        input = st.nextToken();

        out.println(compute());

        in.close();
        out.close();

    }
}
