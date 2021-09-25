package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class d14675 {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            int n = Integer.parseInt(br.readLine());

            int adjacents[] = new int[n+1];

            StringTokenizer stk;

            for (int i = 1; i <= n-1; i++) {
                stk = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());

                ++adjacents[a];
                ++adjacents[b];
            }

            StringBuilder sb = new StringBuilder();

            int q = Integer.parseInt(br.readLine());

            for (int i = 0; i < q; i++) {
                stk = new StringTokenizer(br.readLine());

                int t = Integer.parseInt(stk.nextToken());
                int k = Integer.parseInt(stk.nextToken());

                if(t == 1 && adjacents[k] == 1)
                    sb.append("no").append('\n');
                else
                    sb.append("yes").append('\n');
            }

            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
