import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class measurement {

    private static ArrayList<CowPackage> input;
    private static int N;

    public static ArrayList<String> getWinner(int oB, int oE, int oM) {
        // get old winner
        ArrayList<String> oldWinners = new ArrayList<>();
        int oldWinner = Math.max(Math.max(oB, oE), oM);
        if (oldWinner == oB && oldWinner == oM && oldWinner == oE) {
            oldWinners.add("Bessie");
            oldWinners.add("Elsie");
            oldWinners.add("Mildred");
        } else if (oldWinner == oB && oldWinner == oE) {
            oldWinners.add("Bessie");
            oldWinners.add("Elsie");
        } else if (oldWinner == oB && oldWinner == oM) {
            oldWinners.add("Bessie");
            oldWinners.add("Mildred");
        } else if (oldWinner == oE && oldWinner == oM) {
            oldWinners.add("Elsie");
            oldWinners.add("Mildred");
        } else if (oldWinner == oB)
            oldWinners.add("Bessie");
        else if (oldWinner == oE)
            oldWinners.add("Elsie");
        else
            oldWinners.add("Mildred");

        return oldWinners;
    }

    public static boolean determineIfIncreaseCount(int oB, int oE, int oM, int nB, int nE, int nM) {
        ArrayList<String> one = getWinner(oB, oE, oM);
        ArrayList<String> two = getWinner(nB, nE, nM);
//        System.out.println(one + " " + two);

        for (int i = 0; i < one.size(); i++) {
            if (!two.contains(one.get(i)))
                return true;
        }
        for (int i = 0; i < two.size(); i++) {
            if (!one.contains(two.get(i)))
                return true;
        }
        return false;
    }

    public static int compute() {
        int ct = 0;
        int bessie = 7;
        int elsie = 7;
        int mildred = 7;
        int bessieNew = 7, elsieNew = 7, mildredNew = 7;

        String currMax = "";
        for (int i = 0; i < input.size(); i++) {

            CowPackage curr = input.get(i);
            String currCow = curr.getName();
            if (currCow.equals("Bessie"))
                bessieNew = bessie + curr.getChange();
            else if (currCow.equals("Elsie"))
                elsieNew = elsie + curr.getChange();
            else
                mildredNew = mildred + curr.getChange();

            // determine whether to increment count
            if (determineIfIncreaseCount(bessie, elsie, mildred, bessieNew, elsieNew, mildredNew)) {
//                System.out.println("\n" + bessie + " " + bessieNew + " \n" + elsie + " " + elsieNew + "\n" + mildred + " " + mildredNew);
                ct++;
            }

            bessie = bessieNew;
            elsie = elsieNew;
            mildred = mildredNew;
        }
        return ct;
    }

    public static void main(String[] args) throws IOException {

        // read standard input
        BufferedReader in = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter out = new PrintWriter(new File("measurement.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());

        input = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int day = Integer.parseInt(st.nextToken());
            String cow = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            CowPackage temp = new CowPackage(day, cow, num);
            input.add(temp);
        }
        Collections.sort(input);
//        System.out.println(determineIfIncreaseCount(9, 7, 7, 9, 6, 7));
//        System.out.println(getWinner(9, 6, 7));

//        System.out.println(input);
        out.println(compute());
        in.close();
        out.close();
    }

}

class CowPackage implements Comparable<CowPackage> {
    int day;
    String cowName;
    int change;

    CowPackage(int d, String name, int ch) {
        day = d;
        cowName = name;
        change = ch;
    }

    public int getDay() {
        return day;
    }

    public String getName() {
        return cowName;
    }

    public int getChange() {
        return change;
    }

    public String toString() {
        return getDay() + " " + getName() + " " + getChange();
    }

    @Override
    public int compareTo(CowPackage o) {
        if (this.getDay() > o.getDay())
            return 1;
        else if (this.getDay() == o.getDay())
            return 0;
        else
            return -1;
    }
}

