package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d_1753 {
	
	public static class Point implements Comparable<Point>{
		int v;
		int w;
		
		public Point() {
		}
		
		public Point(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		final int INF = 10000000;
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(br.readLine());
			
			List<Point> list[] = new ArrayList[v+1];
			
			// 인접 노드를 리스트에 저장합니다.
			for (int i = 0; i < e; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(stk.nextToken());
				if(list[u] == null)
					list[u] = new ArrayList<>();
				
				Point point = new Point();
				point.v = Integer.parseInt(stk.nextToken());
				point.w = Integer.parseInt(stk.nextToken());
				
				list[u].add(point);
			}
			
			// 다익스트라는 가중치가 가장 적은 노드부터 방문하기 때문에 우선 순위 큐를 만드는데,
			// compareTo를 정의하여 가중치 기준 오름차순으로 해주었습니다.
			PriorityQueue<Point> pq = new PriorityQueue<>();
			
			// 시작노드를 만들고 큐에 넣습니다.
			Point point = new Point(k,0);
			pq.add(point);
			
			// 인덱스의 값이 "시작 노드 -> 해당 인덱스 노드로 갈 수있는 가중치 최소값"을 의미합니다.
			// 최소값이 새로 생기면 계속 갱신해줍니다.
			int d[] = new int[v+1];
			for (int i = 1; i <= v; i++)
				d[i] = INF;
			
			d[k] = 0;
			
			while(!pq.isEmpty()) {
				point = pq.poll();
				
				// 해당 노드로 이동하는 값이 최소값 보다 크거나 인접 리스트가 없다면 검사하지 않습니다.
				if(d[point.v] < point.w || list[point.v] == null)
					continue;
				
				for (int i = 0; i < list[point.v].size(); i++) {
					
					Point cmpPoint = list[point.v].get(i);
					
					int dist = point.w + cmpPoint.w;
					
					// point를 거쳐 cmpPoint에 도착할 때의 가중치(dist)가 최소값보다 작다면 갱신해주고 큐에 넣습니다.
					
					// 그리고 cmpPoint까지의 가중치 값을 dist로 바꿔줍니다. 
					// 그 이유는 해당 객체가 큐에서 나오게 될 때 해당 객체가 point가 될 것이고 해당 객체의 인접 리스트들이 cmpPoint가 되는데,
					// 이 때, 해당 객체까지 도달한 경로의 가중치 + cmpPoint의 가중치로 dist를 구하기 때문입니다.
					// "해당 객체 노드 번호"를 a라고 했을 때, d[a]와 point.w는 다릅니다.
					// d[a]는 모든 경로 중에서 a까지의 최소 경로의 가중치가 들어가게 되고,
					// point.w는 시작노드에서 point객체의 노드까지 도달한 경로의 가중치 값이기 때문입니다.  
					
					// dist가 최소값보다 크다면 굳이 큐에 넣어서 검사하지 않아도 됩니다.
					if(dist < d[cmpPoint.v]) {
						d[cmpPoint.v] = dist;
						cmpPoint.w = dist;
						pq.add(cmpPoint);		
					}
				}
			}
			
			for (int i = 1; i <= v; i++) {
				if(d[i] == INF)
					sb.append("INF\n");
				else
					sb.append(d[i]+"\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
