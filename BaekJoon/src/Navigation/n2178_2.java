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
	// static �Լ����� ����� �� �ְ� static���� �����Ͽ����ϴ�.
	static int maze[][];
	static boolean check[][];
	static int n,m;
		
	// �̷θ� �Է� �ް� ������� �Լ�
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
	
	// BFS �Լ�. ã�� �࿭�� ����(�ִ� �Ÿ�)�� ��ȯ���ݴϴ�. 
	// ���� ������ ���� �̷ξ��� ���ڸ� +1 �ؼ� ���� ǥ�ø� ���ִ� ����Դϴ�.
	// ������� (0,0)���� �����ϰ� (1,0)�� ���� �ִ� �̷�(1)�̸�
	//  maze[1][0] = maze[0][0] + 1 �� ���־ ���� 2��� ǥ���� �ִ� ���Դϴ�.
	public static int BFS(int findRow, int findCol) {
		// �̷��� �����¿츦 üũ�� �� ����� �迭 �Դϴ�.
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
			
			// �����¿츦 üũ���ݴϴ�.
			for (int i = 0; i < dirRow.length; i++) {
				
				int tmpRow = row + dirRow[i];
				int tmpCol = col + dirCol[i];
				
				// ���� ���� �̷θ� üũ�� �� �ְ� �ϴ� ���Դϴ�. 
				// ���� ���, (-1,0) �̳� ���̳� ���� ���� n,m�� ���� �ʰ� �ϴ� ���Դϴ�.
				if(tmpRow >= 0 && tmpCol >= 0
						&& tmpRow < n && tmpCol < m) {
					// ���� üũ���� �ʴ� �࿭�̰� �� �� �ִ� �̷θ� ť�� �־��ְ� üũ ��, ������ �÷��ݴϴ�.
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
