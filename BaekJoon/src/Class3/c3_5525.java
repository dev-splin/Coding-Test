package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c3_5525 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			int memo[] = new int[m];
			
			String s = br.readLine();
			
			int count = 0;
			
			for (int i = 2; i < m; i++) {
				if(s.charAt(i) == 'I' && s.charAt(i-1) == 'O') {
					memo[i] = memo[i-2] + 1;
					
					if(memo[i] >= n && s.charAt(i-2*n) == 'I')
						  ++count;
				}
			}
			
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
