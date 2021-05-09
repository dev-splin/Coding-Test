package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class c3_16928 {
	static int arr[];
	
	public static int solve() {
		boolean[] check = new boolean[101];
		
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> countQ = new LinkedList<>();
		
		q.add(1);
		countQ.add(0);
		check[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int curCount = countQ.poll();
			
			for (int i = 1; i <= 6; i++) {
				int nextPosition = cur + i;
				
				if(nextPosition == 100)
					return curCount + 1;
				
				if(!check[nextPosition]) {
					check[nextPosition] = true;
					if(arr[nextPosition] != 0)
						q.add(arr[nextPosition]);
					else
						q.add(nextPosition);
					countQ.add(curCount+1);
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			arr = new int[101];
			
			for (int i = 0; i < n + m ; i++) {
				stk = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(stk.nextToken());
				int end = Integer.parseInt(stk.nextToken());
				
				arr[start] = end;
			}
			
			System.out.println(solve());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
