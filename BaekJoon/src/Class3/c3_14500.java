package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c3_14500 {
	static int n;
	static int m;
	
	static int map[][];
	static boolean visit[][];
	static int max = 0;
	
	// 상하좌우
	static int dirRow[] = {-1,1,0,0};
	static int dirCol[] = {0,0,-1,1};
	
	// 'ㅗ', 'ㅜ', 'ㅓ', 'ㅏ' 모양 순
	static int exRow[][] = {{1,1,1,0}, {0,0,0,1}, {0,1,2,1}, {0,1,2,1}};
	static int exCol[][] = {{0,1,2,1}, {0,1,2,1}, {1,1,1,0}, {0,0,0,1}};
	
	// 상하좌우 방향으로 DFS를 돌다가 깊이가 4가 되면 4가 될 때까지 들린 곳의 합을 이용해 최댓값을 갱신합니다.
	public static void DFS(int row, int col, int sum, int depth) {
		if(depth == 4) {
			max = Math.max(sum, max);
			return;
		} 
		
		for (int i = 0; i < 4; i++) {
			int curRow = row + dirRow[i];
			int curCol = col + dirCol[i];
			
			// 상하좌우방향에서 범위를 벗어나지 않고 지나왔던 길이 아니면 DFS를 진행합니다.
			if(curRow >= 0 && curRow < n &&
					curCol >= 0 && curCol < m && !visit[curRow][curCol]) {
				visit[curRow][curCol] = true;
				DFS(curRow, curCol, sum + map[curRow][curCol], depth + 1);
				visit[curRow][curCol] = false;
			}
		}
	}
	
	// 'ㅗ', 'ㅜ', 'ㅓ', 'ㅏ' 모양을 구해줍니다.
	public static void exception(int row, int col) {
		
		for (int i = 0; i < 4; i++) {
			int sum = 0;
			
			for (int j = 0; j < 4; j++) {
				int curRow = row + exRow[i][j];
				int curCol = col + exCol[i][j];
				
				if(curRow >= 0 && curRow < n &&
						curCol >= 0 && curCol < m && !visit[curRow][curCol]) {
					sum += map[curRow][curCol];
				}
			}
			max = Math.max(max, sum);
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			map = new int[n][m];
			visit = new boolean[n][m];
			
			// 종이 만들기
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++)
					map[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			// 종이의 모든 부분을 순회하면서 도형을 찾아 제일 최대 값이 나오는 경우를 찾습니다.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					visit[i][j] = true;
					DFS(i,j,map[i][j],1);
					visit[i][j] = false;
					exception(i, j);
				}
			}
			
			System.out.println(max);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
