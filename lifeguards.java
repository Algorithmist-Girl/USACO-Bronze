import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lifeguards {

    private static int N;
    private static ArrayList<Lifeguard> list;

    public static int getAmtTimeCovered(int removeIndex) {
        boolean[] temp = new boolean[1002];
        for (int i = 0; i < list.size(); i++) {
            if (i != removeIndex) {
                int startTime = list.get(i).start;
                int endTime = list.get(i).end;
                for (int j = startTime; j < endTime; j++)
                    temp[j] = true;
            }
        }

        int ct = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i])
                ct++;
        }
        return ct;
    }

    public static int getMaxTime() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, getAmtTimeCovered(i));
        }
        return max;
    }


    public static void main(String[] HI) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter out = new PrintWriter("lifeguards.out");
        StringTokenizer st = new StringTokenizer(in.readLine());


        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Lifeguard(start, end));
        }

        out.println(getMaxTime());
        in.close();
        out.close();

    }
}

class Lifeguard implements Comparable<Lifeguard> {
    int start, end;

    Lifeguard(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public int compareTo(Lifeguard two) {
        return start - two.start;
    }

}
