import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class breedflip {

    private static int N;
    private static String A;
    private static String B;
    private static ArrayList<Integer> misMatchedIndices;

    public static void getMismatched() {
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i))
                misMatchedIndices.add(i);
        }
    }

    //
//    public static int getRunEndingIndex(int start) {
//        for (int i = start + 1; i < misMatchedIndices.size(); i++) {
//            if (misMatchedIndices.get(i) != (misMatchedIndices.get(i - 1) + 1))
//                return i - 1;
//        }
//        return misMatchedIndices.size() - 1;
//    }
//
    public static int compute() {
        int ct = 1;
        for (int i = 0; i < misMatchedIndices.size() - 1; i++) {
            if (misMatchedIndices.get(i + 1) != (misMatchedIndices.get(i) + 1))
                ct++;
        }
        return ct;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter out = new PrintWriter(new File("breedflip.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        A = st.nextToken();
        st = new StringTokenizer(in.readLine());
        B = st.nextToken();

        misMatchedIndices = new ArrayList<>();

        getMismatched();
        System.out.println(compute());

        in.close();
        out.close();
    }
}
