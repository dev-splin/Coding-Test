package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class c4_1865_2 {
	static final int INF = 1000000000;
	static List<Edge> edges;
	
	public static class Edge {
		int start;
		int end;
		int time;
		
		public Edge(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			// 테스트 케이스 입력
			int tc= Integer.parseInt(br.readLine());
			
			// 입력 시작
			for (int i = 0; i < tc; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(stk.nextToken());
				int m = Integer.parseInt(stk.nextToken());
				int w = Integer.parseInt(stk.nextToken());
				
				edges = new ArrayList<>();
				
				// 도로
				for (int j = 0; j < m; j++) {
					stk = new StringTokenizer(br.readLine());
					
					int node1 = Integer.parseInt(stk.nextToken());
					int node2 = Integer.parseInt(stk.nextToken());
					int time = Integer.parseInt(stk.nextToken());
					
					// 모든 간선을 저장
					edges.add(new Edge(node1, node2, time));
					edges.add(new Edge(node2, node1, time));
				}
				
				// 웜홀은 시간이 줄어들기 때문에 -로 넣어줍니다.
				for (int j = 0; j < w; j++) {
					stk = new StringTokenizer(br.readLine());
					
					int node1 = Integer.parseInt(stk.nextToken());
					int node2 = Integer.parseInt(stk.nextToken());
					int time = Integer.parseInt(stk.nextToken());
					
					edges.add(new Edge(node1, node2, -time));
				}
				
				// 최단 거리를 저장할 배열
				int d[] = new int[n+1];
				
				Arrays.fill(d, INF);
				
				// 최단 거리 구하기
				for (int j = 1; j <= n; j++)
					for(Edge e : edges)
						d[e.end] = Math.min(d[e.end], d[e.start] + e.time);
				
				boolean isPossible = false;
				
				// 현재 d에 최단 거리가 들어가 있지만, 간선을 순회하면서
				// 간선의 도착 정점까지의 최단거리(d[end])가 
				// 간선의 시작 정점까지의 최단거리(d[start]) + 간선의 가중치 보다 작다면,
				// 즉 업데이트가 된다면, 음의 사이클을 가지게 됩니다.(시간이 되돌아가는 경우가 있다는 것)
				for(Edge e : edges)
					if(d[e.end] > d[e.start] + e.time) {
						isPossible = true;
						break;
					}
				
				if(isPossible)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
