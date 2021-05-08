package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class c3_7569 {
	static int arr[][][];
	static int m;
	static int n;
	static int h;
	static Queue<Tomato> queue;
	static boolean visit[][][];
	
	public static class Tomato {
		int height;
		int row;
		int col;
		
		public Tomato() {
		}
		
		public Tomato(int height, int row, int col) {
			this.height = height;
			this.row = row;
			this.col = col;
		}
	}
	
	public static int BFS() {
		int dirHeight[] = {1,-1,0,0,0,0};
		int dirRow[] = {0,0,1,-1,0,0};
		int dirCol[] = {0,0,0,0,-1,1};
		
		while(!queue.isEmpty()) {
			Tomato cur = queue.poll();
			
			for (int i = 0; i < 6; i++) {
				int height = cur.height + dirHeight[i];
				int row = cur.row + dirRow[i];
				int col = cur.col + dirCol[i];
				
				if(height >= 0 && height < h &&
						row >= 0 && row < n &&
						col >= 0 && col < m && 
						!visit[height][row][col] &&
						arr[height][row][col] == 0) {
					visit[height][row][col] = true;
					arr[height][row][col] = arr[cur.height][cur.row][cur.col] + 1;
					queue.add(new Tomato(height, row, col));
				}
			}
		}
		
		return check();
	}
	
	public static int check() {
		
		int max = 0;
		
		for (int i = 0; i < h; i++) 
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if(arr[i][j][k] == 0)
						return -1;
					else
						max = Math.max(max, arr[i][j][k]);
				}
			}
		
		return max - 1;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(stk.nextToken());
			n = Integer.parseInt(stk.nextToken());
			h = Integer.parseInt(stk.nextToken());
			
			arr = new int[h][n][m];
			visit = new boolean[h][n][m];
			queue = new LinkedList<>();
			
			boolean isPossible = true;
			
			for (int i = 0; i < h; i++) 
				for (int j = 0; j < n; j++) {
					stk = new StringTokenizer(br.readLine());
					for (int k = 0; k < m; k++) {
						arr[i][j][k] = Integer.parseInt(stk.nextToken());
						
						if(arr[i][j][k] == 1) {
							visit[i][j][k] = true;
							Tomato t = new Tomato(i,j,k);
							queue.add(t);
						} else if (arr[i][j][k] == 0)
							isPossible = false;
					}
				}
			
			int ans = 0;
			
			if(!isPossible)
				ans = BFS();
				
			System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}