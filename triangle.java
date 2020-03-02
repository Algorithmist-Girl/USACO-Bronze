import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class triangle {

    private static int N;
    private static ArrayList<Coordinate> list;

    public static int getArea(Coordinate one, Coordinate two, Coordinate three) {

        if (one.yCoord == two.yCoord && two.xCoord == three.xCoord) {
            return (Math.abs(one.xCoord - two.xCoord) * Math.abs(two.yCoord - three.yCoord));
        } else if (one.yCoord == three.yCoord && three.xCoord == two.xCoord) {
            return Math.abs(one.xCoord - three.xCoord) * Math.abs(three.yCoord - two.yCoord);
        } else if (two.yCoord == one.yCoord && one.xCoord == three.xCoord) {
            return Math.abs(two.xCoord - one.xCoord) * Math.abs(one.yCoord - three.yCoord);
        } else if (two.yCoord == three.yCoord && three.xCoord == one.xCoord) {
            return Math.abs(two.xCoord - three.xCoord) * Math.abs(three.yCoord - one.yCoord);
        } else if (three.yCoord == one.yCoord && one.xCoord == two.xCoord) {
            return Math.abs(three.xCoord - one.xCoord) * Math.abs(one.yCoord - two.yCoord);
        } else if (three.yCoord == two.yCoord && two.xCoord == one.xCoord) {
            return Math.abs(three.xCoord - two.xCoord) * Math.abs(two.yCoord - one.yCoord);
        }
        return -1;
    }

    public static int compute() {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < list.size() - 2; i++) {
            for (int j = i + 1; j < list.size() - 1; j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    Coordinate one = list.get(i);
                    Coordinate two = list.get(j);
                    Coordinate three = list.get(k);
                    if (getArea(one, two, three) != -1)
                        maxArea = Math.max(maxArea, (getArea(one, two, three)));
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter out = new PrintWriter(new File("triangles.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int xCoord = Integer.parseInt(st.nextToken());
            int yCoord = Integer.parseInt(st.nextToken());
            list.add(new Coordinate(xCoord, yCoord));
        }
        out.println(compute());

        in.close();
        out.close();
    }
}


class Coordinate {
    int xCoord;
    int yCoord;

    Coordinate(int x, int y) {
        xCoord = x;
        yCoord = y;
    }
}
