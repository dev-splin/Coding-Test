package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c2_1929 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			
			int num[] = new int[n+1];
			
			for (int i = 2; i <= n; i++) {
				
				if(num[i] != 1) {
					for (int j = i+i; j <= n; j+=i)
						num[j] = 1;
				}
			}
			
			for (int i = m; i <= n; i++) {
				if(i != 1 &&  num[i] != 1)
					sb.append(i+"\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
