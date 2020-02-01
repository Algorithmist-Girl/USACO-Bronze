import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class gymnastics {

    private static int K, N;
    private static ArrayList<ArrayList<Integer>> list;

    private static boolean checkIfPairIsConsistent(int num1, int num2) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).indexOf(num1) > list.get(i).indexOf(num2))
                return false;
        }
        return true;
    }

    public static int compute() {
        int ct = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j && checkIfPairIsConsistent(i, j)) {
                    ct++;
                    System.out.println(i + " " + j);
                }
            }
        }
        return ct;
    }

    public static void main(String[] args) throws IOException {

        // read standard input
        BufferedReader in = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter out = new PrintWriter(new File("gymnastics.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            ArrayList<Integer> temp = new ArrayList<>();
            while (st.hasMoreTokens())
                temp.add(Integer.parseInt(st.nextToken()));
            list.add(temp);
        }

        System.out.println(list.toString());

        out.println(compute());
        in.close();
        out.close();

    }
}
