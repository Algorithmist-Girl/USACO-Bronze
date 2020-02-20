import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class taming {

    private static int N;
    private static int[] input;
    private static boolean[] minBreakouts;
    private static boolean[] maxBreakouts;
    private static boolean flag = false;

    public static boolean checkIfValid(int negativeOneIndex) {
        for (int i = negativeOneIndex; i < N; i++) {
//            if (negativeOneIndex == 3)
//                System.out.println(input[i]);
            if (input[i] != -1 && (i - input[i]) < negativeOneIndex)
                return false;
        }
        return true;
    }

    public static boolean checkIfBreakOutEntryIsLogical(int index) {
        int lastBreakOutDay = index - input[index];
        for (int i = index; i > lastBreakOutDay; i--) {
            if (i != lastBreakOutDay && minBreakouts[i])
                return false;
        }
        return true;
    }

    public static int countBools(boolean[] arr) {
        int ct = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i])
                ct++;

        return ct;
    }

    public static void compute() {
        for (int i = 0; i < input.length; i++) {

            if (!checkIfBreakOutEntryIsLogical(i)) {
                flag = true;
                break;
            }

            int index = input[i];
            if (index == -1) {
                minBreakouts[i] = false;
                if (checkIfValid(i)) {
                    maxBreakouts[i] = true;
                }
            } else {
                minBreakouts[i - index] = true;
                maxBreakouts[i - index] = true;
            }
        }
        minBreakouts[0] = true;
        maxBreakouts[0] = true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("taming.in"));
        PrintWriter out = new PrintWriter("taming.out");
        StringTokenizer st = new StringTokenizer(in.readLine());


        N = Integer.parseInt(st.nextToken());
        minBreakouts = new boolean[N];
        maxBreakouts = new boolean[N];
        input = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        compute();
        if (flag)
            out.println(-1);
        else
            out.println(countBools(minBreakouts) + " " + countBools(maxBreakouts));
        in.close();
        out.close();

    }
}
