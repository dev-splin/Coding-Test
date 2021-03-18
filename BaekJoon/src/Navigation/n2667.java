package Navigation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class n2667 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	static int map[][];
	static boolean check[][];
	static int n;
	
	// 맵을 입력받고 아스키코드를 이용해 맵을 만들어 줍니다.
	public static void makeMap() throws Exception{
		map = new int[n][n];
		check = new boolean[n][n];
		
		for (int i = 0; i < map.length; i++) {
			char houses[] = br.readLine().trim().toCharArray();
			
			for (int j = 0; j < houses.length; j++) {
				map[i][j] = houses[j] - 48;
			}
		}
	}
	
	// 인자로 받은 행과열을 이용해 BFS를 진행하고 해당 BFS 결과의 개수를 반환합니다.
	// 이 때, 인자로 받은 행렬이 이미 체크되었거나 빈 땅이면 0을 반환합니다.
	public static int BFS(int startRow, int startCol) {
		
		int count = 0;
		
		if(check[startRow][startCol] || map[startRow][startCol] != 1)
			return count;
		
		// 상하좌우 체크를 위한 배열
		int dirRow[] = {-1, 1, 0, 0};
		int dirCol[] = {0, 0, -1, 1};
		
		Queue<Integer> rowQueue = new LinkedList<>();
		Queue<Integer> colQueue = new LinkedList<>();
		rowQueue.add(startRow);
		colQueue.add(startCol);
		
		check[startRow][startCol] = true;
		++count;
		
		while(!rowQueue.isEmpty()) {
			int row = rowQueue.poll();
			int col = colQueue.poll();
			
			for (int i = 0; i < dirRow.length; i++) {
				
				int tmpRow = row + dirRow[i];
				int tmpCol = col + dirCol[i];
				
				// 상하좌우를 체크하기 때문에 맵의 범위를 벗어나지 않았는 지 체크해야합니다.
				if(tmpRow >= 0 && tmpCol >= 0
					&& tmpRow < n && tmpCol < n)
					if(!check[tmpRow][tmpCol] && map[tmpRow][tmpCol] == 1) {
						
						rowQueue.add(tmpRow);
						colQueue.add(tmpCol);
						
						check[tmpRow][tmpCol] = true;
						++count;
					}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			n = Integer.parseInt(br.readLine().trim());
			
			makeMap();
			
            // 단지 내의 집(아파트)수를 저장할 리스트
			List<Integer> countApartment = new ArrayList<>();
			
			// 맵 전체를 순회하면서 BFS를 진행합니다.
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					
					int count = BFS(i,j);
					
					if(count != 0)
						countApartment.add(count);
				}
			}
			
			Collections.sort(countApartment);
			
			bw.write(Integer.toString(countApartment.size()));
			bw.newLine();
			
			for(int count : countApartment) {
				bw.write(Integer.toString(count));
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
