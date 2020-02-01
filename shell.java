import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class shell {

    private static int N;
    private static ArrayList<ArrayList<Integer>> list;

    public static int whichIndexTrue(boolean[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i])
                return i;
        return -1;
    }

    private static int whenRockStartedUnderShell(int startingIndex) {
        boolean[] shells = new boolean[3];
        shells[startingIndex - 1] = true;

        int ct = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> currList = list.get(i);
            if (shells[currList.get(0) - 1] || shells[currList.get(1) - 1]) {
                shells[currList.get(0) - 1] = !shells[currList.get(0) - 1];
                shells[currList.get(1) - 1] = !shells[currList.get(1) - 1];
            }
            if ((currList.get(2) - 1) == whichIndexTrue(shells))
                ct++;
//            System.out.println(startingIndex - 1 + " " + Arrays.toString(shells));
        }
//        System.out.println(ct);
        return ct;
    }

    public static void main(String[] DEEPANSHA_IS_AWESOME) throws IOException {
        // read standard input
        BufferedReader in = new BufferedReader(new FileReader("shell.in"));
        PrintWriter out = new PrintWriter(new File("shell.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());

        list = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            st = new StringTokenizer(in.readLine());
            while (st.hasMoreTokens()) {
                temp.add(Integer.parseInt(st.nextToken()));
            }
            list.add(temp);
        }
        out.println(Math.max(Math.max(whenRockStartedUnderShell(1), whenRockStartedUnderShell(2)), whenRockStartedUnderShell(3)));

        in.close();
        out.close();
    }
}
