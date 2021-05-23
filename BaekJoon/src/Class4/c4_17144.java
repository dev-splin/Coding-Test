package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_17144 {
	static int r;
	static int c;
	static int arr[][];
	static int tmpArr[][];
	static int airRow;
	
	// 먼지 확산
	public static void spreadDust() {
		
		int dirRow[] = {-1,1,0,0};
		int dirCol[] = {0,0,-1,1};
		
		tmpArr = new int[r+1][c+1];
		
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				tmpArr[i][j] += arr[i][j];
				
				// 먼지의 크기가 5이상일 때만 확산
				if(arr[i][j] >= 5) {
					
					int spread = arr[i][j] / 5;
					int count = 0;
					
					for (int k = 0; k < 4; k++) {
						int nextRow = i + dirRow[k];
						int nextCol = j + dirCol[k];
						
						if(nextRow >= 1 && nextRow <= r &&
								nextCol >= 1 && nextCol <= c && arr[nextRow][nextCol] != -1) {
							tmpArr[nextRow][nextCol] += spread;
							++count;
						}
					}
					
					tmpArr[i][j] -= spread * count;
				} 
			}
		}
		
		arr = tmpArr;
	}
	
	public static void moveArr() {
		
		tmpArr = new int[r+1][c+1];
		
		// 공기 청정기 윗 부분
		for (int i = airRow-1; i >= 1; --i) {
			for (int j = 1; j <= c; ++j) {
				if(arr[i][j] == -1) {
					tmpArr[i][j] = -1;
					continue;
				}
				
				if(j == c && i - 1 >= 1) {
					tmpArr[i-1][j] = arr[i][j];
					continue;
				} else if(j == 1 && i + 1 != airRow - 1) {
					tmpArr[i+1][j] = arr[i][j];
					continue;
				}
				
				if(i == airRow - 1)
						tmpArr[i][j+1] = arr[i][j];
				else if(i == 1)
						tmpArr[i][j-1] = arr[i][j];
				else
					tmpArr[i][j] = arr[i][j];
			}
		}
		
		// 공기 청정기 아랫 부분
		for (int i = airRow; i <= r; i++) {
			for (int j = 1; j <= c; ++j) {
				if(arr[i][j] == -1) {
					tmpArr[i][j] = -1;
					continue;
				}
				
				if(j == c && i + 1 <= r) {
					tmpArr[i+1][j] = arr[i][j];
					continue;
				} else if(j == 1 && i - 1 != airRow) {
					tmpArr[i-1][j] = arr[i][j];
					continue;
				}
				
				if(i == airRow)
					tmpArr[i][j+1] = arr[i][j];
				else if(i == r)
					tmpArr[i][j-1] = arr[i][j];
				else
					tmpArr[i][j] = arr[i][j];
			}
		}
		
		arr = tmpArr;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			r = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());
			
			arr = new int[r+1][c+1];
			
			for (int i = 1; i <= r; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 1; j <= c; j++) {
					arr[i][j] = Integer.parseInt(stk.nextToken());
					
					if(arr[i][j] == -1)
						airRow = i;
				}
			}
			
			for (int i = 0; i < t; i++) {
				spreadDust();
				moveArr();
			}
			
			int ans = 0;
			
			for (int i = 1; i <= r; i++)
				for (int j = 1; j <= c; j++)
					if(arr[i][j] > 0)
						ans += arr[i][j];
			
			System.out.println(ans);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
