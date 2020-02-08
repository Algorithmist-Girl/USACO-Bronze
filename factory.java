import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class factory {

    private static int N;
    private static HashMap<Integer, Integer> input;

    public static boolean helper(int stationI, int startingStation) {
        if (input.get(startingStation) == null)
            return false;

//        System.out.println("hi" + startingStation);
        while (input.get(startingStation) != stationI) {
//            System.out.println("startingStation = " + startingStation);
            if (input.get(startingStation) == stationI)
                return true;
            if (!input.containsKey(input.get(startingStation)))
                break;
            startingStation = input.get(startingStation);
        }

        if (input.get(startingStation) == stationI) {
            return true;
        } else
            return false;
    }

    public static boolean isItStationI(int stationI) {
        int ct = 0;
        Iterator iter = input.keySet().iterator();
        while (iter.hasNext()) {
            Integer curr = (Integer) iter.next();
            int secondStation = input.get(curr);
            if (secondStation == stationI)
                ct++;
            else {
                if (helper(stationI, curr))
                    ct++;
            }
        }

//        System.out.println("ct = " + ct);
        return (ct == (N - 1));
    }

    public static int compute() {
        for (int i = 1; i <= N; i++)
            if (isItStationI(i))
                return i;
        return -1;
    }

    public static void main(String[] args) throws IOException {

        // read standard input
        BufferedReader in = new BufferedReader(new FileReader("factory.in"));
        PrintWriter out = new PrintWriter(new File("factory.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        input = new HashMap<>();
        for (int i = 0; i < (N - 1); i++) {
            st = new StringTokenizer(in.readLine());
            input.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

//        System.out.println(isItStationI(2));
        out.println(compute());
        in.close();
        out.close();
    }
}
