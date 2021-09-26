package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d17073 {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stk.nextToken());
            double w = Double.parseDouble(stk.nextToken());

            int arr[] = new int[n+1];

            for (int i = 0; i < n-1; i++) {
                stk = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(stk.nextToken());
                int v = Integer.parseInt(stk.nextToken());

                ++arr[u];
                ++arr[v];
            }

            double count = 0;

            for (int i = 2; i <= n ; i++)
                if(arr[i] == 1)
                    ++count;

            System.out.println(w/count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
