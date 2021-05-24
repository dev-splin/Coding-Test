package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class c4_1043 {
	static int n;
	static Set<Integer> lieCases[];
	static int know[];
	
	public static void DFS (int num) {
		know[num] = 1;
		for(Integer caseNum : lieCases[num]) {
			
			for (int j = 1; j <= n; j++) {
				if(j == num)
					continue;
				
				if(lieCases[j].contains(caseNum)) {
					lieCases[j].remove(caseNum);
					DFS(j);
				}
			}
		}
		lieCases[num].clear();
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			lieCases = new HashSet[51];
			know = new int[51];
			
			for (int i = 1; i <= n; i++)
				lieCases[i] = new HashSet<>();
			
			stk = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(stk.nextToken());
			
			for (int i = 0; i < k; i++)
				know[Integer.parseInt(stk.nextToken())] = 1;
			
			int ans = 0;
			
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				int count = Integer.parseInt(stk.nextToken());
				if(count == 0)
					++ans;
				boolean isLie = true;
				
				Queue<Integer> q = new LinkedList<>();
				
				for (int j = 0; j < count; j++) {
					int num = Integer.parseInt(stk.nextToken());
					
					q.add(num);
					
					if(know[num] == 1)
						isLie = false;
				}
				
				while(!q.isEmpty()) {
					int num = q.poll();
					
					if(isLie)
						lieCases[num].add(i);
					else
						DFS(num);
				}
			}
			
			boolean checkCase[] = new boolean[51];
			
			for (int j = 1; j <= n; j++)
				for(Integer caseNum : lieCases[j])
					if(!checkCase[caseNum]) {
						++ans;
						checkCase[caseNum] = true;
					}
			
			System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
