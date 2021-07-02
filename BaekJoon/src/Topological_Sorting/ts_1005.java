package Topological_Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ts_1005 {
	
	public static class Building {
		int num;
		int time;
		
		public Building(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			StringBuilder sb = new StringBuilder();
			
			// �Է� ����
			for (int i = 0; i < t; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(stk.nextToken());
				int k = Integer.parseInt(stk.nextToken());
				
				// �Ǽ� �ð�
				int times[] = new int[n+1];
				// �ε����� �ش��ϴ� �ǹ��� ����� ���� ���� �ǹ� ��
				// ex) edges[4]�� 2���, edges[4]�� 0�� �Ǿ�� 4�� �ǹ��� �Ǽ��� �� ����
				int edges[] = new int[n+1];
				
				stk = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++)
					times[j] = Integer.parseInt(stk.nextToken());
				
				// �ش� �ε����� �Ǽ��� ���� �Ǽ��� �� �ִ� �ǹ��� ����
				List<Integer> list[] = new ArrayList[n+1];
				
				for (int j = 1; j <= n; j++)
					list[j] = new ArrayList<>();
				
				for (int j = 0; j < k; j++) {
					stk = new StringTokenizer(br.readLine());
					
					int x = Integer.parseInt(stk.nextToken());
					int y = Integer.parseInt(stk.nextToken());
					
					list[x].add(y);
					++edges[y];
				}
				
				// ��ǥ �ǹ� ����
				int dst = Integer.parseInt(br.readLine());
				// �Է� ����
				
				// �Ǽ��� �� �ִ�(edges�� 0��) �ǹ����� ���� ť
				Queue<Integer> q = new LinkedList<>();
				// �ش� �ε����� �ǹ��� �Ǽ��ϴµ� ���� �ɸ� �ð�
				int arrivalTime[] = new int[n+1];
				
				// �ش� �ε��� �ǹ��� �Ǽ��ð��� �̸� �־��ְ�, ó���� �Ǽ��� �� �ִ�(edges�� 0��)�ǹ��� ť�� ����
				for (int j = 1; j <= n; j++) {
					arrivalTime[j] = times[j];
				
					if(edges[j] == 0) {
						q.add(j);
					}
				}
				
				while(!q.isEmpty()) {
					int curNum = q.poll();
					
					for(Integer num : list[curNum]) {
						// num�� �ش��ϴ� �ǹ��� curNum�� �ش��ϴ� �ǹ��� �Ǽ��� �� �Ǽ��� �� �ֱ� ������
						// curNum�� �Ǽ��ϱ� ������ �ð�(arrivalTime[curNum) + ���� num�� �Ǽ��ϴ� �ð�(times[num])
						// �� ���� num�� �Ǽ��ϱ� ����(arrivalTime[num])�� �ð� �� �ִ� ���� �־��ݴϴ�.
						
						// �ִ� ���� �־��ִ� ������ num�� �Ǽ��ϱ� ���ؼ��� ���� �Ǽ��ؾ��ϴ� �ǹ����� ��� �Ǽ��Ǿ�� �ϱ� �����Դϴ�.
						// ���� ���, 4�� �ǹ��� �Ǽ��ϱ� ���ؼ� 2�� �ǹ�(�Ǽ��ð� 1��)�� 3�� �ǹ�(�Ǽ��ð� 100��)�� �Ϸ��ؾ� �Ѵٸ�,
						// 2�� �ǹ��� 1�ʸ��� �Ǽ��� �����ٰ� �ϴ��� 3�� �ǹ��� �Ǽ� �Ϸ�Ǿ�� 4�� �ǹ��� �Ǽ��� �� �ֱ� ������
						// �ᱹ 4�� �ǹ��� �Ǽ��ϱ� ���ؼ��� 2�� �ǹ� �Ǽ�(1�� �ҿ�)�� ������ 3�� �ǹ� �Ǽ�(100�� �ҿ�)�� ������ �մϴ�. (���� ���� ����)
						arrivalTime[num] = Math.max(arrivalTime[num], arrivalTime[curNum] + times[num]);
						
						// �Ǽ��� �� �ִ�(edges�� 0��)�ǹ��� ť�� ����
						if(--edges[num] == 0)
							q.add(num);
					}
				}
				
				sb.append(arrivalTime[dst]).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
