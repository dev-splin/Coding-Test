package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class d14501 {
	static int t[];
	static int p[];
	static int memo[];
	static int n;
	
	public static int dp(int day) {
		if(day > n)
			return 0;
		
		if(memo[day] == 0) {
			
			// "���� �� �� + ��㿡 �ɸ��� �Ⱓ - 1"�� �ؼ� ������ ���� ���մϴ�. (������ �� �������� ��㰡��)
			int possibleDay = day + t[day] - 1;
			
			// ����� ���(n) ���� �����ٸ� (���� �ݾ� + ����� ������ �������� ��츦 üũ) �� 
			// ������ üũ(�� ū��찡 ���� �� �ֱ� ����)�� �ؼ� �ִ� ���� �־� �ݴϴ�.
			if(possibleDay <= n) 
				memo[day] = Math.max(p[day] + dp(day + t[day]),dp(day+1));
			// ���� ���� ��� ���� ������ ������ �ٽ� ������ (dp(day+1))�� ȣ���ϱ� ������ �ٸ� ����� ������ ���� �� �ֽ��ϴ�.
			else
				return dp(day+1);
		}
		
		return memo[day];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			n = Integer.parseInt(br.readLine().trim());
			
			t = new int[n+1];
			p = new int[n+1];
			memo = new int[n+1];
			
			for (int i = 1; i <= n; i++) {
				String nums = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(nums);
				
				t[i] = Integer.parseInt(stk.nextToken());
				p[i] = Integer.parseInt(stk.nextToken());
			}
			
			int max = 0;
			// �ش��ϴ� ������ ���� �� �ִ� �ִ� ������ ���� ���� ���� ū ������ ����մϴ�.
			for (int i = 1; i <= n; i++) {
				int pay = dp(i);
				if(max < pay)
					max = pay;
			}
			
			bw.write(Integer.toString(max));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}