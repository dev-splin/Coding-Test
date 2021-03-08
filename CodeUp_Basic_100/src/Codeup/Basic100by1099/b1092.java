package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1092 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine().trim();
			
			StringTokenizer stk = new StringTokenizer(nums);
			
			if(stk.countTokens() != 3)
				return;
			
			int a = Integer.parseInt(stk.nextToken());
			if(a < 1 || a > 100)
				return;
			
			int b = Integer.parseInt(stk.nextToken());
			if(b < 1 || b > 100)
				return;
			
			int c = Integer.parseInt(stk.nextToken());
			if(c < 1 || c > 100)
				return;
			
			int day = 1;
			
			while(day % a != 0 ||
					day % b != 0 ||
					day % c != 0) {
				++day;
			}
			
			bw.write(Integer.toString(day));
			
		
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

