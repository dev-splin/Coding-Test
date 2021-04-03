package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class d9251_2 {
	static Integer memo[][];
	static String a,b;
	
	public static int dp(int n, int m) {
		if(n <= 0 || m <= 0)
			return 0;
		
		if(memo[n][m] == null) {
						
			// ��� �� ��, ���ڵ��� ������ ���� �밢���� ������ ���� +1�� ���ݴϴ�.
			if(a.charAt(n-1) == b.charAt(m-1))
				memo[n][m] = dp(n-1,m-1) + 1;
			// ���ڵ��� ���� ������ ���ʰ� ���� �� �ִ밪�� �־��ݴϴ�.
			else
				memo[n][m] = Math.max(dp(n-1,m),dp(n,m-1));
		}
		
		return memo[n][m];
		
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			a = br.readLine();
			b = br.readLine();
			
			int n = a.length();
			int m = b.length();

			memo = new Integer[n+1][m+1];
			
			System.out.println(dp(n,m));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
