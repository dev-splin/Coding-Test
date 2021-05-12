package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class c3_16236 {
	static Shark shark;
	static int arr[][];
	static int dirRow[] = {-1,1,0,0};
	static int dirCol[] = {0,0,-1,1};
	static int time = 0;
	static int n;

	public static class Shark {
		int row;
		int col;
		int size;
		int eat;
	}
	
	public static boolean BFS() {
		
		Queue<Integer> rowQ = new LinkedList<>();
		Queue<Integer> colQ = new LinkedList<>();
		Queue<Integer> countQ = new LinkedList<>();
		
		boolean visit[][] = new boolean[n][n];
		
		rowQ.add(shark.row);
		colQ.add(shark.col);
		countQ.add(0);
		visit[shark.row][shark.col] = true;
		
		int dstRow = -1;
		int dstCol = -1;
		int dstDist = -1;
		
		
		while(!rowQ.isEmpty()) {
			int curRow = rowQ.poll();
			int curCol = colQ.poll();
			int curCount = countQ.poll();
			
			if(dstDist != -1 && dstDist <= curCount)
				break;
			
			for (int i = 0; i < 4; i++) {
				int nextRow = curRow + dirRow[i];
				int nextCol = curCol + dirCol[i];
				
				if(nextRow >= 0 && nextRow < n &&
						nextCol >= 0 && nextCol < n && !visit[nextRow][nextCol]) {
					visit[nextRow][nextCol] = true;
					
					if(arr[nextRow][nextCol] != 0 && arr[nextRow][nextCol] < shark.size) {
						if(dstRow == -1) {
							dstRow = nextRow;
							dstCol = nextCol;
							dstDist = curCount + 1;
						} else {
							if(dstRow > nextRow ||
									(dstRow == nextRow && dstCol > nextCol)) {
								dstRow = nextRow;
								dstCol = nextCol;
							}
						}
					} else if(arr[nextRow][nextCol] == 0 || arr[nextRow][nextCol] == shark.size) {
						rowQ.add(nextRow);
						colQ.add(nextCol);
						countQ.add(curCount+1);
					}
				}
			}
		}
		
		if(dstCol != -1) {
			arr[shark.row][shark.col] = 0;
			arr[dstRow][dstCol] = 0;
			time += dstDist;
			
			shark.row = dstRow;
			shark.col = dstCol;
			shark.eat += 1;
			
			if(shark.eat == shark.size) {
				++shark.size;
				shark.eat = 0;
			}
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(stk.nextToken());
					if(arr[i][j] == 9) {
						shark = new Shark();
						shark.row = i;
						shark.col = j;
						shark.size = 2;
						shark.eat = 0;
					}
				}
			}
			
			while(true) {
				if(!BFS())
					break;
			}
			
			System.out.println(time);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
