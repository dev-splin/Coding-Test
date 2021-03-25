package Floyd_Warshall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class f21278 {
	static Building buildings[];
	
	// 빌딩 클래스 인접 건물번호를 리스트로 가지고 있습니다.
	public static class Building {
		List<Integer> adjacentNums = new ArrayList<>();
	}
	
	// 마지막에 출력해주기 위한 치킨 클래스
	public static class Chicken {
		int count;
		int minNumChicken;
		int maxNumChicken;
		
		@Override
		public String toString() {
			return minNumChicken + " " + maxNumChicken + " " + (count * 2);
		}
	}
	
	// 두개의 건물번호를 받아 BFS를 실행하고 
	// 깊이들을 더 해 입력받은 두 건물과 모든 건물들과의 거리 총합을 반환합니다.  
	public static int BFS(int building1, int building2) {
		
		int length = buildings.length;
		boolean check[] = new boolean[length];
		
		Queue<Building> queue = new LinkedList<>();
		
		int depth = 1;
		// 입력받은 두 건물과 모든 건물들과의 거리 총합을 저장할 변수
		int count = 0;
		
		// 처음에 루트 노드(입력받은 두 개의 건물번호)를 큐에 넣어놓습니다.
		queue.add(buildings[building1]);
		queue.add(buildings[building2]);
		check[building1] = true;
		check[building2] = true;
		// 현재 레벨에 체크안한 개수가 몇개인지 담을 변수
		int countInLevel = 2;
		// 같은 레벨의 인접 리스트 즉, 다음 레벨의 노드 개수를 저장할 변수
		int countAdjacent = 0;
		
		// 큐에서 노드를 하나씩 빼면서 체크해서 거리 총합을 구합니다.
		while(!queue.isEmpty()) {
			Building building = queue.poll();
			
			--countInLevel;
						
			// 노드의 체크하지 않은 인접리스트들을 큐에 넣어줍니다.
			// 큐에 넣을 때마다 countAdjacent을 1씩 누적합니다.(현재 레벨의 체크가 끝날 때의 countAdjacent값이 다음 레벨 노드의 개수가 됩니다.)
			// 거리 총합을 구해야 되기 때문에 깊이(루트 노드와의 거리)를 count에 누적해줍니다.
			for(int adjacentNum : building.adjacentNums) {
				
				if(!check[adjacentNum]) {
					queue.add(buildings[adjacentNum]);
					check[adjacentNum] = true;
					count += depth;
					++countAdjacent;
				}
			}
			
			// 현재 레벨 체크가 끝났으면 countInLevel에 countAdjacent(다음 레벨의 노드들)를 넣어주고
			// countAdjacent를 초기화 후 깊이를 늘려줍니다.	 	
			if(countInLevel == 0) {
				countInLevel = countAdjacent;
				countAdjacent = 0;
				++depth;
			}
		}
		
		return count;
	}
	
	// 치킨집을 찾아 출력해주는 메서드 입니다.
	public static void findChicken() {
		
		Chicken chicken = null;
		
		int minCount = Integer.MAX_VALUE;
		
		// 1,2번 -> 1,3번 -> 1,4번 순으로 치킨집을 가정하고 자리를 찾기 때문에 따로 오름차순 정렬은 하지 않아도 됩니다.
		for (int i = 1; i < buildings.length; i++) {
			for (int j = i + 1; j < buildings.length; j++) {
				
				int count = BFS(i,j);
				
				if(count < minCount) { 
					minCount = count;
					
					chicken = new Chicken();
					chicken.count = count;
					chicken.minNumChicken = i;
					chicken.maxNumChicken = j;
					}
				}
			}
		
		System.out.println(chicken);
	}

	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		
		try {
			// 입력 시작
			String nums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(nums);
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			buildings = new Building[n + 1];
			
			for (int i = 1; i < buildings.length; i++) 
				buildings[i] = new Building();
			
			
			for (int i = 1; i <= m; i++) {
				nums = br.readLine().trim();
				stk = new StringTokenizer(nums);
				
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				
				buildings[a].adjacentNums.add(b);
				buildings[b].adjacentNums.add(a);
			}
			// 입력 끝
			
			findChicken();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
