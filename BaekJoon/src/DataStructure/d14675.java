package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class d14675 {
    static ArrayList<Integer> parents[];
    static ArrayList<Integer> childs[];
    static HashMap<Integer, int[]> map;

    public static String solve(int t, int k) {

        if(t == 1)
    }

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            int n = Integer.parseInt(br.readLine());

            parents = new ArrayList[n+1];
            childs = new ArrayList[n+1];
            map = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                parents[i] = new ArrayList<>();
                childs[i] = new ArrayList<>();
            }

            StringTokenizer stk;

            for (int i = 1; i <= n; i++) {
                stk = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());

                int arr[] = {a, b};

                map.put(i, arr);

                childs[a].add(b);
                parents[b].add(a);
            }

            StringBuilder sb = new StringBuilder();

            int q = Integer.parseInt(br.readLine());

            for (int i = 0; i < q; i++) {
                stk = new StringTokenizer(br.readLine());

                int t = Integer.parseInt(stk.nextToken());
                int k = Integer.parseInt(stk.nextToken());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
