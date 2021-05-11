package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class c3_9019_2 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(stk.nextToken());
				int end = Integer.parseInt(stk.nextToken());
				
				Queue<Integer> q = new LinkedList<>();
				Queue<String> cmdQ = new LinkedList<>(); 
				boolean check[] = new boolean[10001];
				
				q.add(start);
				cmdQ.add("");
				check[start] = true;
				
				while(!q.isEmpty() && !check[end]) {
					int cur = q.poll();
					String curCmd = cmdQ.poll();
					
					int D = (cur * 2) % 10000;
					int S = (cur == 0) ? 9999 : cur - 1;
					int L = (cur % 1000) * 10 + cur / 1000;
					int R = (cur % 10) * 1000 + cur / 10; 
					
					if(!check[D]) {
						q.add(D);
						cmdQ.add(curCmd + "D");
						check[D] = true;
						if(D == end)
							sb.append(curCmd + "D").append("\n");
					}
					
					if(!check[S]) {
						q.add(S);
						cmdQ.add(curCmd + "S");
						check[S] = true;
						if(S == end)
							sb.append(curCmd + "S").append("\n");
					}
					
					if(!check[L]) {
						q.add(L);
						cmdQ.add(curCmd + "L");
						check[L] = true;
						if(L == end)
							sb.append(curCmd + "L").append("\n");
					}
					
					if(!check[R]) {
						q.add(R);
						cmdQ.add(curCmd + "R");
						check[R] = true;
						if(R == end)
							sb.append(curCmd + "R").append("\n");
					}
				}
			}
			
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
