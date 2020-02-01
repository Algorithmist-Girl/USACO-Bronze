import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class lineup {

    private static int N;
    private static ArrayList<String> input;
    private static ArrayList<ArrayList<String>> cowPairs;

    private static boolean checkIfValid(ArrayList<String> list) {
        for (int i = 0; i < cowPairs.size(); i++) {
            ArrayList<String> currList = cowPairs.get(i);
            String cowOne = currList.get(0);
            String cowTwo = currList.get(1);
            if (Math.abs(list.indexOf(cowOne) - list.indexOf(cowTwo)) > 1) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<ArrayList<String>> generatePerm(ArrayList<String> original) {
        if (original.isEmpty()) {
            ArrayList<ArrayList<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        String first = original.remove(0);
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<ArrayList<String>> perms = generatePerm(original);

        for (ArrayList<String> smallerPermutated : perms) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                ArrayList<String> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, first);
                ans.add(temp);
            }
        }
        return ans;
    }


    private static ArrayList<String> compute() {
        ArrayList<ArrayList<String>> permutations = generatePerm(input);
        Collections.sort(permutations, new Comparator<ArrayList<String>>() {
            public int compare(ArrayList<String> one, ArrayList<String> two) {
                for (int i = 0; i < one.size(); i++) {
                    if (one.get(i).compareTo(two.get(i)) != 0)
                        return one.get(i).compareTo(two.get(i));
                }
                return 0;
            }
        });


        for (int i = 0; i < permutations.size(); i++)
            if (checkIfValid(permutations.get(i)))
                return permutations.get(i);
        return null;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter out = new PrintWriter(new File("lineup.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        cowPairs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());

            String cowOne = st.nextToken();
            String cowTwo = "";
            while (st.hasMoreTokens()) {
                cowTwo = st.nextToken();
            }

            ArrayList<String> temp = new ArrayList<>();
            temp.add(cowOne);
            temp.add(cowTwo);
            cowPairs.add(temp);
        }

        input = new ArrayList<>();
        input.add("Beatrice");
        input.add("Belinda");
        input.add("Bella");
        input.add("Bessie");
        input.add("Betsy");
        input.add("Buttercup");
        input.add("Sue");
        input.add("Blue");

        ArrayList<String> answer = compute();
        for (int i = 0; i < answer.size(); i++)
            out.println(answer.get(i));

        in.close();
        out.close();
    }
}
