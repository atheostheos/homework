import java.util.Arrays;

public class SinusGraph {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        char[][] graph = new char[n][n];
        final double EPS = 0.1;

        for (int x = 0; x < n; x++) {
            //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
            for (int y = 0; y < n; y++) {
                //System.out.println(x+ " " + (y-n/2));
                if (Math.abs(func(x) - (n/2-y)*1.0/(n/2)) < EPS) {
                    graph[y][x] = '*';
                } else {
                    graph[y][x] = ' ';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }

    public static double func(double x) {
        return Math.cos(x/3);
    }
}
