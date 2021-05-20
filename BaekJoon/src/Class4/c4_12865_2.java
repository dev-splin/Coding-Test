package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_12865_2 {
	static int memo[][];
	static int w[];
	static int v[];
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			w = new int[n+1];
			v = new int[n+1];
			memo = new int[n+1][k+1];
			
			for (int i = 1; i <= n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				w[i] = Integer.parseInt(stk.nextToken());
				v[i] = Integer.parseInt(stk.nextToken());
			}
			
			// ó�� ���� ��ȸ�ϸ鼭 memo�� ���� �־��ݴϴ�.
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= k; j++) {
					// j�� i���� ������ ���Ժ��� ������ i ������ ���� �� �ִ밪�� memo[i-1][j]�� ���� �˴ϴ�.
					if(w[i] > j)
						memo[i][j] = memo[i-1][j];
					// j�� i���� ������ ���Ժ��� ũ�ų� ������ i ������ ���� �� �ִ밪�� memo[i-1][j]��
					// j���� ������ ����(w)�� �� i ������ ���� �� �ִ밪�� memo[i-1][j-w[i]], ������ ��ġ v[i]�� ���� �� �� ū ���� �ֽ��ϴ�.
					else
						memo[i][j] = Math.max(memo[i-1][j], memo[i-1][j-w[i]] + v[i]);
				}
			}
			
			System.out.println(memo[n][k]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
