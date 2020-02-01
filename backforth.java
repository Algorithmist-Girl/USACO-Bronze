import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class backforth {

    // private variables
    private static ArrayList<Integer> tank1buckets;
    private static ArrayList<Integer> tank2buckets;

    private static ArrayList<Integer> poss1;

    private static void Tuesday(int tank1, ArrayList<Integer> LISTONE, ArrayList<Integer> LISTTWO) {
        for (int i = 0; i < LISTONE.size(); i++) {
            int moveMilk = LISTONE.get(i);
//            tank1 -= moveMilk;

            ArrayList<Integer> newTank1 = (ArrayList) LISTONE.clone();
            ArrayList<Integer> newTank2 = (ArrayList) LISTTWO.clone();

            newTank1.remove(i);
            newTank2.add(moveMilk);

//            tank2 += moveMilk;
            Wednesday(tank1 - moveMilk, newTank1, newTank2);
        }
    }

    private static void Wednesday(int tank1, ArrayList<Integer> LISTONE, ArrayList<Integer> LISTTWO) {
        for (int i = 0; i < LISTTWO.size(); i++) {
            int moveMilk = LISTTWO.get(i);

//            tank2 -= moveMilk;
            ArrayList<Integer> newTank1 = (ArrayList) LISTONE.clone();
            ArrayList<Integer> newTank2 = (ArrayList) LISTTWO.clone();

            newTank2.remove(i);
            newTank1.add(moveMilk);

//            tank1 += moveMilk;


            Thursday(tank1 + moveMilk, newTank1, newTank2);
        }
    }

    private static void Thursday(int tank1, ArrayList<Integer> NEWTANK1, ArrayList<Integer> NEWTANK2) {
        for (int i = 0; i < NEWTANK1.size(); i++) {
            int moveMilk = NEWTANK1.get(i);

//            tank1 -= moveMilk;
            ArrayList<Integer> newTank1 = (ArrayList) NEWTANK1.clone();
            ArrayList<Integer> newTank2 = (ArrayList) NEWTANK2.clone();

            newTank1.remove(i);
            newTank2.add(moveMilk);

//            tank2 += moveMilk;

            Friday(tank1 - moveMilk, newTank1, newTank2);
        }

    }

    private static void Friday(int tank1, ArrayList<Integer> NEWTANK1, ArrayList<Integer> NEWTANK2) {
        for (int i = 0; i < NEWTANK2.size(); i++) {
            int moveMilk = NEWTANK2.get(i);

            if (!poss1.contains(tank1 + moveMilk))
                poss1.add(tank1 + moveMilk);
        }

    }


    public static void main(String[] DEEPANSHA_IS_AWESOME) throws IOException {

        // read standard input
        BufferedReader in = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter out = new PrintWriter(new File("backforth.out"));
        StringTokenizer st;

        tank1buckets = new ArrayList<>();
        tank2buckets = new ArrayList<>();
        poss1 = new ArrayList<>();


        // read in input
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 10; i++) {
            int currMilk = Integer.parseInt(st.nextToken());
            tank1buckets.add(currMilk);
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 10; i++) {
            int currMilk = Integer.parseInt(st.nextToken());
            tank2buckets.add(currMilk);
        }

        Tuesday(1000, tank1buckets, tank2buckets);

        out.println(poss1.size());
        in.close();
        out.close();
    }
}
