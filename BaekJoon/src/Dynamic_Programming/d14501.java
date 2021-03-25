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
			
			// "현재 일 수 + 상담에 걸리는 기간 - 1"을 해서 끝나는 날을 구합니다. (끝나는 날 다음부터 상담가능)
			int possibleDay = day + t[day] - 1;
			
			// 상담이 퇴사(n) 전에 끝난다면 (현재 금액 + 상담이 끝나는 다음날의 경우를 체크) 와 
			// 다음날 체크(더 큰경우가 있을 수 있기 때문)를 해서 최대 값을 넣어 줍니다.
			if(possibleDay <= n) 
				memo[day] = Math.max(p[day] + dp(day + t[day]),dp(day+1));
			// 다음 날이 퇴사 전에 끝나지 않으면 다시 다음날 (dp(day+1))을 호출하기 때문에 다른 경우의 수들을 구할 수 있습니다.
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
			// 해당하는 날에서 나올 수 있는 최대 이익을 비교한 다음 제일 큰 이익을 출력합니다.
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