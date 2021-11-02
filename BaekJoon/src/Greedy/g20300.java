package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class g20300 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			TreeSet<Long> ts = new TreeSet<>();
			
			for (int i = 0; i < n; i++)
				ts.add(Long.parseLong(stk.nextToken()));
			
			long max = ts.last();
			long sum = 0;
			
			if(ts.size() % 2 == 1)
				max = ts.pollLast();
			
			while(!ts.isEmpty()) {
				sum = ts.pollLast() + ts.pollFirst();
				max = Math.max(max, sum);
			}
			
			System.out.println(max);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
