package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c2_2609 {
	
	public static int GCD(int a, int b) {
		
		if(a % b == 0)
			return b;
		
		return GCD(b, a%b);
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int gcd = GCD(a,b);
			
			System.out.println(gcd);
			System.out.println(a*b / gcd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

