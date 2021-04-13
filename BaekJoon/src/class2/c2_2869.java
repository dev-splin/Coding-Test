package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c2_2869 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			
			int day = (v-a) / (a-b);
			++day;
			
			if((v-a) % (a-b) != 0)
				++day;
			
			System.out.println(day);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
