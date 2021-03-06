package Navigation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n7576 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	static int tomato[][];
	static boolean check[][];
	static int n,m;
	
	// n,m을 입력받고 n과m으로 토마토 배열을 만듭니다. 
	// 이 때, 전부다 익어있는 상태 즉, 0이 없는 토마토배열인지 체크해주고 boolean을 리턴합니다.  
	public static boolean makeTomatoBox() throws Exception{
		String nums = br.readLine().trim();
		StringTokenizer stk = new StringTokenizer(nums);
		
		m = Integer.parseInt(stk.nextToken());
		n = Integer.parseInt(stk.nextToken());
		
		tomato = new int[n][m];
		check = new boolean[n][m];
		
		boolean checkZero = false;
		
		// 행(n)만큼 반복하고 열(m)만큼 입력합니다. 이때 0이 하나라도 있으면 checkZero는 true가 됩니다.
		for (int i = 0; i < tomato.length; i++) {
			nums = br.readLine().trim();
			stk = new StringTokenizer(nums);
			
			int j = 0;
			while(stk.hasMoreTokens()) {
				tomato[i][j] = Integer.parseInt(stk.nextToken());
				
				if(tomato[i][j] == 0)
					checkZero = true;
				
				++j;
			}
		}
		return checkZero;
	}
	
	// BFS를 이용해 레벨이 올라가면 해당 행,열의 값을 현재 레벨 행,열의 값 + 1을 해줍니다.
	// 예를 들어, 처음 익은 토마토 다음 레벨의 토마토들은 값이 2가 되는 것입니다.
	// 이렇게 되면 해당 행열의 값으로 몇 일이 지나야 익을 수 있는지를 나타낼 수 있습니다.
	// 이 때, 처음부터 익어있는 토마토가 여러 개 있을 수 있기 때문에 처음 큐에 익어있는 토마토 전부를 넣고 시작합니다.
	public static void BFS() {
		// 상,하,좌,우
		int dirRow[] = {-1, 1, 0, 0};
		int dirCol[] = {0, 0, -1, 1};
		
		Queue<Integer> rowQueue = new LinkedList<>();
		Queue<Integer> colQueue = new LinkedList<>();
		
		// 1(익어있는 토마트)위치를 모두 찾아 큐에 넣어줍니다.
		for (int i = 0; i < tomato.length; i++) {
			for (int j = 0; j < tomato[i].length; j++) {
				if(tomato[i][j] == 1) {
					rowQueue.add(i);
					colQueue.add(j);
					check[i][j] = true;
				}
			}
		}
		
		while(!rowQueue.isEmpty()) {
			int row = rowQueue.poll();
			int col = colQueue.poll();
			
			for (int i = 0; i < dirRow.length; i++) {
				int tmpRow = row + dirRow[i];
				int tmpCol = col + dirCol[i];
				
				if(tmpRow >= 0 && tmpCol >= 0
					&& tmpRow < n && tmpCol <m)
					if(!check[tmpRow][tmpCol] && tomato[tmpRow][tmpCol] != -1) {
						rowQueue.add(tmpRow);
						colQueue.add(tmpCol);
						
						tomato[tmpRow][tmpCol] = tomato[row][col] + 1;
						check[tmpRow][tmpCol] = true;
					}
			}
		}
	}
	
	public static void main(String[] args) {
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			boolean checkZero = makeTomatoBox();
			
			// 처음 부터 전부 익어있는 상태 (0이 없으면) 0을 출력해주고 프로그램 종료합니다.
			if(!checkZero) {
				bw.write("0");
				bw.flush();
				bw.close();
				return;
			}
			
			BFS();
			
			int day = 0;
			checkZero = false;
			
			// BFS를 마치고 토마토를 전부 검사해 하나라도 0(익지 않은 토마토)이 나오게 되면 -1을 출력하고
			// 아니면 해당 행,열의 값(익은 날)을 출력하는데, 처음 시작이 1이므로 -1 해줍니다.
			// (문제에서는 처음 익은 토마토 다음 부터 1로 표현하기 때문)
			for (int i = 0; i < tomato.length; i++) {
				for (int j = 0; j < tomato[i].length; j++) {
					if(tomato[i][j] == 0)
						checkZero = true;
					
					else if(tomato[i][j] > day)
						day = tomato[i][j];
				}
			}
			
			if(checkZero)
				bw.write("-1");
			else
				bw.write(Integer.toString(day-1));
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
