package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class c4_13172 {
	final static long MOD = 1000000007;
	
	public static long xGCD(long a, long b) {
		List<Long> s = new ArrayList<>();
		s.add(1L);
		s.add(0L);
		
		List<Long> t = new ArrayList<>();
		t.add(0L);
		t.add(1L);
		
		List<Long> r = new ArrayList<>();
		r.add(a);
		r.add(b);
		
		List<Long> q = new ArrayList<>();
		
		while(true) {
			long r2 = r.get(r.size() - 2);
			long r1 = r.get(r.size() - 1);
			q.add(r2 / r1);
			r.add(r2 % r1);
			
			if(r.get(r.size() - 1) == 0)
				break;
			
			long s2 = s.get(s.size() - 2);
			long s1 = s.get(s.size() - 1);
			
			long t2 = t.get(t.size() - 2);
			long t1 = t.get(t.size() - 1);
			
			long q1 = q.get(q.size() - 1);
			s.add(s2 - s1 * q1);
			t.add(t2 - t1 * q1);
		}
		
		long result = t.get(t.size() - 1);
		
		if(result < 0)
			result += MOD;
		
		return result;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int m = Integer.parseInt(br.readLine());
			
			long ans = 0;
			for (int i = 0; i < m; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				long n = Integer.parseInt(stk.nextToken());
				long s = Integer.parseInt(stk.nextToken());
				
				long result = xGCD(MOD, n % MOD) * (s % MOD);
				
				ans += result % MOD;
			}
			
			System.out.println(ans % MOD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
