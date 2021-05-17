package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_16953_2 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			int ans = 1;
			
			while(b > a) {
				String tmp = "" + b;
				
				if(tmp.charAt(tmp.length()-1) == '1') {
					b = Integer.parseInt(tmp.substring(0, tmp.length()-1));
					++ans;
				} else if(b % 2 == 0) {
					b >>= 1;
					++ans;
				} else
					break;
			}
			
			if(b != a)
				ans = -1;
			
			System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
