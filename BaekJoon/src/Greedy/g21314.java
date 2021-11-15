package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class g21314 {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);

        try {
            String str = br.readLine();

            String max = "";
            String min = "";

            String maxTmp = "";
            String minTmp = "";

            for (int i = str.length() - 1; i >= 0; --i) {
                char ch = str.charAt(i);

                if(ch == 'M') {
                    if(maxTmp.equals("")) {
                        max = "1" + max;
                    } else {
                        maxTmp += "0";
                    }

                    if(minTmp.equals("")) {
                        minTmp = "1";
                    } else {
                        minTmp += "0";
                    }
                }
                if(ch == 'K') {
                    if(!maxTmp.equals("")) {
                        max = maxTmp + max;
                    }
                    maxTmp = "5";

                    if(!minTmp.equals("")) {
                        min = minTmp + min;
                    }
                    minTmp = "";
                    min = "5" + min;
                }
            }

            max = maxTmp + max;
            min = minTmp + min;

            System.out.println(max);
            System.out.println(min);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
