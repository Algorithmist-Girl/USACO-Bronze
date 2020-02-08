import java.io.*;
import java.util.StringTokenizer;

public class buckets {

    private static int BXcoord;
    private static int BYcoord;

    private static int LXcoord;
    private static int LYcoord;

    private static int RXcoord;
    private static int RYcoord;

    public static int compute() {
        if (BYcoord == RYcoord && BYcoord == LYcoord)
            if ((RXcoord < BXcoord && RXcoord > LXcoord) || (RXcoord > BXcoord) && (RXcoord < LXcoord))
                return Math.abs(BXcoord - LXcoord) + 1;
        if (BXcoord == RXcoord && BXcoord == LXcoord)
            if ((RYcoord < BYcoord && RYcoord > LYcoord) || (RYcoord > BYcoord) && (RYcoord < LYcoord))
                return Math.abs(BYcoord - LYcoord) + 1;
        return (Math.abs(LXcoord - BXcoord) + Math.abs(LYcoord - BYcoord)) - 1;
    }

    public static void main(String[] args) throws IOException {

        // read standard input
        BufferedReader in = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter out = new PrintWriter(new File("buckets.out"));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(in.readLine());
            String currString = st.nextToken();
            for (int j = 0; j < currString.length(); j++) {
                if (currString.charAt(j) == 'B') {
                    BXcoord = i + 1;
                    BYcoord = j + 1;
                } else if (currString.charAt(j) == 'R') {
                    RXcoord = i + 1;
                    RYcoord = j + 1;
                } else if (currString.charAt(j) == 'L') {
                    LXcoord = i + 1;
                    LYcoord = j + 1;
                }
            }
        }

        out.println(compute());
        in.close();
        out.close();
    }
}
