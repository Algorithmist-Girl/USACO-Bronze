import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swap {

    private static int N, K;
    private static int A1, A2; // make sure to subtract A1 and A2
    private static int B1, B2;  // make sure to subtract B1 and B2
    private static ArrayList<Integer> list;
//    private static int[] arr;

//    public static void iteration() {
//        for (int i = A1; i <= A2 / 2; i++) {
//            Integer temp = arr[i];
//            arr[i] = arr[A2 - (i - A1)];
//            arr[A2 - (i - A1)] = temp;
//        }
//
//        for (int i = B1; i <= B2 / 2; i++) {
//            Integer temp = arr[i];
//            arr[i] = arr[B2 - (i - B1)];
//            arr[B2 - (i - B1)] = temp;
//        }
//
//    }


    public static boolean equals(ArrayList<Integer> one, ArrayList<Integer> two) {
        for (int i = 0; i < one.size(); i++)
            if (one.get(i) != two.get(i))
                return false;
        return true;
    }

    public static boolean iterationOne() {
        ArrayList<Integer> copy = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
            copy.add(list.get(i));

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = A2; i >= A1; i--) {
            temp.add(list.get(i));
        }
        for (int i = 0; i < temp.size(); i++) {
            list.set(A1 + i, temp.get(i));
        }


        temp = new ArrayList<>();
        for (int i = B2; i >= B1; i--) {
            temp.add(list.get(i));
        }
        for (int i = 0; i < temp.size(); i++) {
            list.set(B1 + i, temp.get(i));
        }

        if (equals(copy, list))
            return true;
        return false;
    }

    public static void compute() {

        for (int i = 0; i < K; i++) {
            boolean x = iterationOne();
            if (x)
                break;
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("swap.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("swap.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
//        arr = new int[7];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i + 1;
//        }

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        st = new StringTokenizer(in.readLine());
        A1 = Integer.parseInt(st.nextToken());
        A2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        B1 = Integer.parseInt(st.nextToken());
        B2 = Integer.parseInt(st.nextToken());

        A1 = A1 - 1;
        A2 = A2 - 1;
        B1 = B1 - 1;
        B2 = B2 - 1;

        compute();

        for (int i = 0; i < list.size(); i++)
            if (i != list.size() - 1)
                out.write(String.valueOf(list.get(i)) + "\n");
            else
                out.write(String.valueOf(list.get(i)));


        in.close();

        out.flush();
        out.close();
    }
}
