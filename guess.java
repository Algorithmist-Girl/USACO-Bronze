import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class guess {

    private static HashMap<String, Integer> mapCharacteristicToCount;
    private static int N;
    private static ArrayList<ArrayList<String>> list;

    public static int findCommonBetweenPairs(ArrayList<String> list1, ArrayList<String> list2) {
        int ct = 0;
        for (int i = 0; i < list2.size(); i++) {
            if (list1.contains(list2.get(i)))
                ct++;
        }
        return ct;
    }


    public static int compute() {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> currList = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    ans = Math.max(findCommonBetweenPairs(currList, list.get(j)) + 1, ans);
                }
            }
        }
        return ans;
    }

    public static void main(String[] DEEPANSHA_IS_AWESOME) throws IOException {

        // read standard input
        BufferedReader in = new BufferedReader(new FileReader("guess.in"));
        PrintWriter out = new PrintWriter(new File("guess.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        mapCharacteristicToCount = new HashMap<>();
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            String currAnimal = st.nextToken();
//            System.out.println(currAnimal);

            int numChar = Integer.parseInt(st.nextToken());
//            System.out.println(numChar);
            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j < numChar; j++) {
                String currChar = st.nextToken();
                temp.add(currChar);
                if (mapCharacteristicToCount.containsKey(currChar))
                    mapCharacteristicToCount.put(currChar, mapCharacteristicToCount.get(currChar) + 1);
                else
                    mapCharacteristicToCount.put(currChar, 1);
            }
            list.add(temp);
        }

        System.out.println(list);
        System.out.println(mapCharacteristicToCount);

        out.println(compute());
        in.close();
        out.close();
    }
}
