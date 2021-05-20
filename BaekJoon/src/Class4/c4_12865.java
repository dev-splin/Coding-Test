package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class c4_12865 {
	static Integer memo[][];
	static int w[];
	static int v[];
	
	// ��͸� �̿��� �����
	public static int dp(int i, int k) {
		if(i < 0)
			return 0;
		
		if(memo[i][k] == null) {
			// k�� i���� ������ ���Ժ��� ������ i ������ ���� �� �ִ밪�� dp(i-1,k)�� ���� �˴ϴ�.
			if(w[i] > k)
				memo[i][k] = dp(i-1,k);
			// k�� i���� ������ ���Ժ��� ũ�ų� ������ i ������ ���� �� �ִ밪�� dp(i-1,k)��
			// k���� ������ ����(w)�� �� i ������ ���� �� �ִ밪�� dp(i-1, k-w[i])�� ������ ��ġ v[i]�� ���� �� �� ū ���� �ֽ��ϴ�.
			else
				memo[i][k] = Math.max(dp(i-1, k), dp(i-1, k-w[i]) + v[i]);
		}
		
		return memo[i][k];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			w = new int[n+1];
			v = new int[n+1];
			memo = new Integer[n+1][k+1];
			
			for (int i = 1; i <= n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				w[i] = Integer.parseInt(stk.nextToken());
				v[i] = Integer.parseInt(stk.nextToken());
			}
			
			System.out.println(dp(n,k));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
