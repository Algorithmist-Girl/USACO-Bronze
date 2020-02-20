import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class tttt {
    private static char[][] input;
    private static HashSet<String> individualWins;
    private static HashSet<String> groupWins;

    public static void compute() {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(input[i][0]);
        }
        update(set);

        set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(input[i][1]);
        }
        update(set);

        set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(input[i][2]);
        }
        update(set);


        set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(input[0][i]);
        }
        update(set);

        set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(input[1][i]);
        }
//        System.out.println("HI" + set.toString());
        update(set);

        set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(input[2][i]);
        }
        update(set);

        set = new HashSet<>();
        set.add(input[0][0]);
        set.add(input[1][1]);
        set.add(input[2][2]);
        update(set);

        set = new HashSet<>();
        set.add(input[2][0]);
        set.add(input[1][1]);
        set.add(input[0][2]);
        update(set);
    }


    public static void update(HashSet<Character> set) {
        Iterator<Character> iterator = set.iterator();
        if (set.size() == 1) {
            char next = iterator.next();
            individualWins.add(next + "");
        } else if (set.size() == 2) {
            char next = iterator.next();
            char next1 = iterator.next();

            if (!groupWins.contains(next + next1 + "") ||
                    !groupWins.contains(next1 + next + ""))
                groupWins.add(next + next1 + "");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter out = new PrintWriter("tttt.out");
        StringTokenizer st;

        input = new char[3][3];
        individualWins = new HashSet<>();
        groupWins = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(in.readLine());
            String curr = st.nextToken();
            for (int j = 0; j < 3; j++) {
                input[i][j] = curr.charAt(j);
            }
        }

        compute();

        out.println(individualWins.size() + "\n" + groupWins.size());
        in.close();
        out.close();
    }
}
