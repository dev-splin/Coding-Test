package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class c4_13549 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			int count[] = new int[100001];
			
			Queue<Integer> q = new LinkedList<>();
			
			q.add(n);
			count[n] = 1;
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				if(cur == k)
					break;
				
				int nexts[] = {cur-1, cur+1, cur*2};
				
				for(int next : nexts) {
					
					if(next < 0 || next > 100000)
						continue;
					
					if(count[next] == 0) {
						q.add(next);
						count[next] = count[cur] + 1;
						
						if(next == cur * 2)
							--count[next];
					} else if(count[next] > count[cur])
						count[next] = count[cur] + 1;
				}
			}
			
			System.out.println(count[k]-1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
