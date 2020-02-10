import java.io.*;
import java.util.StringTokenizer;

public class shuffle {
    private static int N;
    private static int[] danceCode;
    private static int[] endingPosition;

    public static void fillArray1IntoArray2(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }

    public static int[] getStartingPosition() {
        int[] startingPos = new int[endingPosition.length];
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < danceCode.length; j++) {
                startingPos[j] = endingPosition[danceCode[j] - 1];
//                System.out.println(printArr(startingPos));
//                System.out.println(printArr(endingPosition));
            }
//            System.out.println(printArr(startingPos) + "\n");
            fillArray1IntoArray2(startingPos, endingPosition);
//            System.out.println("ENDING = " + printArr(endingPosition) + "\n");
            startingPos = new int[N];
        }
        return endingPosition;
    }

    public static String printArr(int[] arr) {
        String print = "";
        for (int i = 0; i < arr.length; i++)
            if (i == arr.length - 1)
                print += arr[i];
            else
                print += arr[i] + "\n";
        return print;
    }

    public static void main(String[] args) throws IOException {
        // read standard input
        BufferedReader in = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter out = new PrintWriter(new File("shuffle.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        danceCode = new int[N];

        for (int i = 0; i < N; i++) {
            danceCode[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        endingPosition = new int[N];
        for (int i = 0; i < N; i++) {
            endingPosition[i] = Integer.parseInt(st.nextToken());
        }

        out.println(printArr(getStartingPosition()));

        in.close();
        out.close();

    }
}
