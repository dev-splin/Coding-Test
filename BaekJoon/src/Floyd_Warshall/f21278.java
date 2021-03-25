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
	
	// ���� Ŭ���� ���� �ǹ���ȣ�� ����Ʈ�� ������ �ֽ��ϴ�.
	public static class Building {
		List<Integer> adjacentNums = new ArrayList<>();
	}
	
	// �������� ������ֱ� ���� ġŲ Ŭ����
	public static class Chicken {
		int count;
		int minNumChicken;
		int maxNumChicken;
		
		@Override
		public String toString() {
			return minNumChicken + " " + maxNumChicken + " " + (count * 2);
		}
	}
	
	// �ΰ��� �ǹ���ȣ�� �޾� BFS�� �����ϰ� 
	// ���̵��� �� �� �Է¹��� �� �ǹ��� ��� �ǹ������ �Ÿ� ������ ��ȯ�մϴ�.  
	public static int BFS(int building1, int building2) {
		
		int length = buildings.length;
		boolean check[] = new boolean[length];
		
		Queue<Building> queue = new LinkedList<>();
		
		int depth = 1;
		// �Է¹��� �� �ǹ��� ��� �ǹ������ �Ÿ� ������ ������ ����
		int count = 0;
		
		// ó���� ��Ʈ ���(�Է¹��� �� ���� �ǹ���ȣ)�� ť�� �־�����ϴ�.
		queue.add(buildings[building1]);
		queue.add(buildings[building2]);
		check[building1] = true;
		check[building2] = true;
		// ���� ������ üũ���� ������ ����� ���� ����
		int countInLevel = 2;
		// ���� ������ ���� ����Ʈ ��, ���� ������ ��� ������ ������ ����
		int countAdjacent = 0;
		
		// ť���� ��带 �ϳ��� ���鼭 üũ�ؼ� �Ÿ� ������ ���մϴ�.
		while(!queue.isEmpty()) {
			Building building = queue.poll();
			
			--countInLevel;
						
			// ����� üũ���� ���� ��������Ʈ���� ť�� �־��ݴϴ�.
			// ť�� ���� ������ countAdjacent�� 1�� �����մϴ�.(���� ������ üũ�� ���� ���� countAdjacent���� ���� ���� ����� ������ �˴ϴ�.)
			// �Ÿ� ������ ���ؾ� �Ǳ� ������ ����(��Ʈ ������ �Ÿ�)�� count�� �������ݴϴ�.
			for(int adjacentNum : building.adjacentNums) {
				
				if(!check[adjacentNum]) {
					queue.add(buildings[adjacentNum]);
					check[adjacentNum] = true;
					count += depth;
					++countAdjacent;
				}
			}
			
			// ���� ���� üũ�� �������� countInLevel�� countAdjacent(���� ������ ����)�� �־��ְ�
			// countAdjacent�� �ʱ�ȭ �� ���̸� �÷��ݴϴ�.	 	
			if(countInLevel == 0) {
				countInLevel = countAdjacent;
				countAdjacent = 0;
				++depth;
			}
		}
		
		return count;
	}
	
	// ġŲ���� ã�� ������ִ� �޼��� �Դϴ�.
	public static void findChicken() {
		
		Chicken chicken = null;
		
		int minCount = Integer.MAX_VALUE;
		
		// 1,2�� -> 1,3�� -> 1,4�� ������ ġŲ���� �����ϰ� �ڸ��� ã�� ������ ���� �������� ������ ���� �ʾƵ� �˴ϴ�.
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
			// �Է� ����
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
			// �Է� ��
			
			findChicken();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
