import java.io.*;
import java.util.StringTokenizer;

public class mixmilk {
    // private instance variables
    private static int[] buckets;  // buckets
    private static int[] capacities;    // capacities
    private static int capacity1, capacity2, capacity3;    // capacities of all buckets
    private static int milk1, milk2, milk3; // current milk in  each bucket

    public static void pourFromXtoY(int indexFrom, int indexTo) {

        if ((buckets[indexFrom] + buckets[indexTo]) > capacities[indexTo]) {
            buckets[indexFrom] -= (capacities[indexTo] - buckets[indexTo]);
            buckets[indexTo] = capacities[indexTo];
        } else if (buckets[indexFrom] > capacities[indexTo]) {
            buckets[indexTo] = capacities[indexTo];
            buckets[indexFrom] -= capacities[indexTo];
        } else {
            buckets[indexTo] += buckets[indexFrom];
            buckets[indexFrom] = 0;
        }
    }

    public static void main(String[] DEEPANSHA) throws IOException {

        buckets = new int[3];
        capacities = new int[3];

        // read standard input
        BufferedReader in = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter out = new PrintWriter(new File("mixmilk.out"));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        capacities[0] = Integer.parseInt(st.nextToken());
        buckets[0] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        capacities[1] = Integer.parseInt(st.nextToken());
        buckets[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        capacities[2] = Integer.parseInt(st.nextToken());
        buckets[2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 33; i++) {

            pourFromXtoY(0, 1);
            pourFromXtoY(1, 2);
            pourFromXtoY(2, 0);
        }
        pourFromXtoY(0, 1);
        out.println(buckets[0] + "\n" + buckets[1] + "\n" + buckets[2]);
        in.close();
        out.close();


    }

}
