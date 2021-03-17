package Navigation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n2178_2 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	// static 함수에서 사용할 수 있게 static으로 정의하였습니다.
	static int maze[][];
	static boolean check[][];
	static int n,m;
		
	// 미로를 입력 받고 만들어줄 함수
	public static void MakeMaze() throws Exception {
		maze = new int[n][m];
		check = new boolean[n][m];
		
		for (int i = 0; i < maze.length; i++) {
			char wallsOrRoads[] = br.readLine().trim().toCharArray();  
			
			for (int j = 0; j < wallsOrRoads.length; j++) {
					maze[i][j] = wallsOrRoads[j] - 48;
			}
		}
	}
	
	// BFS 함수. 찾는 행열의 레벨(최단 거리)를 반환해줍니다. 
	// 다음 레벨로 가면 미로안의 숫자를 +1 해서 레벨 표시를 해주는 방식입니다.
	// 예를들어 (0,0)부터 시작하고 (1,0)이 갈수 있는 미로(1)이면
	//  maze[1][0] = maze[0][0] + 1 을 해주어서 레벨 2라고 표현해 주는 것입니다.
	public static int BFS(int findRow, int findCol) {
		// 미로의 상하좌우를 체크할 때 사용할 배열 입니다.
		int dirRow[] = {-1, 1, 0, 0};
		int dirCol[] = {0, 0, -1, 1};
		
		Queue<Integer> rowQueue = new LinkedList<>();
		Queue<Integer> colQueue = new LinkedList<>();
		
		rowQueue.add(0);
		colQueue.add(0);
		check[0][0] = true;
		
		while(!rowQueue.isEmpty()) {
			
			int row = rowQueue.poll();
			int col = colQueue.poll();
			
			// 상하좌우를 체크해줍니다.
			for (int i = 0; i < dirRow.length; i++) {
				
				int tmpRow = row + dirRow[i];
				int tmpCol = col + dirCol[i];
				
				// 범위 안의 미로만 체크할 수 있게 하는 것입니다. 
				// 예를 들어, (-1,0) 이나 행이나 열의 값이 n,m을 넘지 않게 하는 것입니다.
				if(tmpRow >= 0 && tmpCol >= 0
						&& tmpRow < n && tmpCol < m) {
					// 아직 체크되지 않는 행열이고 갈 수 있는 미로면 큐에 넣어주고 체크 후, 레벨을 올려줍니다.
					if(!check[tmpRow][tmpCol] && maze[tmpRow][tmpCol] == 1) {
						
						rowQueue.add(tmpRow);
						colQueue.add(tmpCol);
						
						check[tmpRow][tmpCol] = true;
						maze[tmpRow][tmpCol] = maze[row][col] + 1;
					}
				}
				
			}
		}
		return maze[findRow][findCol];
	}
	
	public static void main(String[] args) {
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String mazeSize = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(mazeSize);
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			MakeMaze();
			
			int result = BFS(n-1,m-1);
			
			bw.write(Integer.toString(result));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
