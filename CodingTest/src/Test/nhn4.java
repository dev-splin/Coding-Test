package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class nhn4 {
	final static long INF = 2000000000; 
	static int n;
	static int m;
	static int g;
	static ArrayList<Integer> list[][];
	
	static int x;
	static int s;
	static int t;
	static long arr[][];
		
	public static void setInDist(int index, long dist) {
		for(Integer next : list[index][0]) {
			
			long nextDist = 0;
			
			if(dist + 1 >= g) {
				nextDist = g;
			}
			else
				nextDist = dist + 1;
			
			if(arr[next][index] == INF)
				arr[next][index] = nextDist;
			else
				arr[next][index] = Math.min(arr[next][index], nextDist);
				
				
			setInDist(next, nextDist);
		}
	}
	
	public static void setOutDist(int index, long dist) {
		for(Integer next : list[index][1]) {
			long nextDist = 0;
			
			if(dist - 1 <= 0) {
				nextDist = 1;
			}
			else
				nextDist = dist - 1;
			if(arr[index][next] == INF)
				arr[index][next] = nextDist;
			else
				arr[index][next] = Math.min(arr[index][next], nextDist);
				
			setInDist(next, nextDist);
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			g = Integer.parseInt(stk.nextToken());
			
			arr = new long[n+1][n+1];
			
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					arr[i][j] = INF;
			
			// 0 : µé¾î¿È, 1 : ³ª°¨
			list = new ArrayList[n+1][2];
			
			for (int i = 1; i <= n; i++) {
				list[i][0] = new ArrayList<>();	
				list[i][1] = new ArrayList<>();
			}
			
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				
				list[a][1].add(b);
				list[b][0].add(a);
			}
			
			stk = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(stk.nextToken());
			s = Integer.parseInt(stk.nextToken());
			t = Integer.parseInt(stk.nextToken());
			
			setInDist(x, 0);
			setOutDist(x, g+1);
			
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if(arr[i][j] > arr[i][k] + arr[k][j])
							arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
			
			if(arr[s][t] == INF)
				System.out.println(-1);
			else
				System.out.println(arr[s][t]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
