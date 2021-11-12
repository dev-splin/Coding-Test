package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g20365 {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();

            StringTokenizer stkB = new StringTokenizer(str, "R");
            StringTokenizer stkR = new StringTokenizer(str, "B");

            int result = 1 + Math.min(stkB.countTokens(), stkR.countTokens());

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
