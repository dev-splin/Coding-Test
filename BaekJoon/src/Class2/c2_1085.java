package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class c2_1085 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			int h = Integer.parseInt(stk.nextToken());
			
			int min = Math.min(Math.abs(w-x), Math.abs(h-y));
			int finalMin = Math.min(x,Math.min(y, min));
			
			System.out.println(finalMin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}