import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class blist {

    // private instance variables
    private static ArrayList<Cow> cows;
    private static int numCows;


    // return # buckets needed at time i
    public static int numBucketsAtTimeT(int time) {
        int numBuckets = 0;
        for (int i = 0; i < cows.size(); i++) {
            Cow currCow = cows.get(i);
            if (currCow.getFinishTime() >= time && currCow.getStartTime() <= time) {
                numBuckets += currCow.getNumBuckets();
            }
        }
        return numBuckets;
    }

    public static void main(String[] DEEPANSHA) throws IOException {

        // read standard input
        BufferedReader in = new BufferedReader(new FileReader("blist.in"));
        PrintWriter out = new PrintWriter(new File("blist.out"));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        numCows = Integer.parseInt(st.nextToken());

        int minStart = Integer.MAX_VALUE;
        int maxEnd = Integer.MIN_VALUE;
        cows = new ArrayList<Cow>();

        for (int i = 0; i < numCows; i++) {
            st = new StringTokenizer(in.readLine());
            int currStart = Integer.parseInt(st.nextToken());
            minStart = Integer.min(minStart, currStart);
            int currEnd = Integer.parseInt(st.nextToken());
            maxEnd = Integer.max(maxEnd, currEnd);
            int currBuckets = Integer.parseInt(st.nextToken());

            cows.add(new Cow(currStart, currEnd, currBuckets));
        }

        // compute the value
        int maxNumberBuckets = Integer.MIN_VALUE;
        for (int i = minStart; i <= maxEnd; i++) {
            int currBuckets = numBucketsAtTimeT(i);
//            System.out.println("Time = " + i + " " + currBuckets);
            maxNumberBuckets = Integer.max(maxNumberBuckets, currBuckets);
        }

        out.println(maxNumberBuckets);
        in.close();
        out.close();
        System.exit(0);
    }

}

class Cow {
    private int startTime;
    private int finishTime;
    private int numBuckets;

    Cow(int s, int f, int b) {
        startTime = s;
        finishTime = f;
        numBuckets = b;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getNumBuckets() {
        return numBuckets;
    }
}
