package Tree_Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class t1949 {
	static Integer memo[][];
	static List<Integer> childs[];
	
	// dfs를 이용해 리프노드부터 체크합니다.
	public static void dfs(int cur, int parent) {
		
		for(int child : childs[cur]) {
			// 리스트의 인접 노드중 부모노드가 나오면 건너뜁니다.
			if(child == parent)
				continue;
			
			dfs(child, cur);
			
			// 현재 노드가 우수마을이 아닌 경우에는 자식 노드 중 더 큰 값을 더해줍니다.
			memo[cur][0] += Math.max(memo[child][0], memo[child][1]);
			// 현재 노드가 우수마을인 경우는 자식 노드 중 우수마을이 아닌 경우만 더해줍니다.
			memo[cur][1] += memo[child][0];
		}
	}
		
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			memo = new Integer[n+1][2];
			childs = new ArrayList[n+1];
			
			// 인접노드를 저장할 리스트를 초기화하면서 memo[][1] 즉, 우수마을인 경우에는 그 마을의 주민수를 넣어놓습니다.
			for (int i = 1; i <= n; i++) {
				memo[i][0] = 0;
				memo[i][1] = Integer.parseInt(stk.nextToken());
				childs[i] = new ArrayList<>();
			}
			
			// 리스트에 노드 추가
			for (int i = 0; i < n-1; i++) {
				stk = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(stk.nextToken());
				int node2 = Integer.parseInt(stk.nextToken());
				childs[node1].add(node2);
				childs[node2].add(node1);
			}
			
			dfs(1,0);
			
			System.out.println(Math.max(memo[1][0], memo[1][1]));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}