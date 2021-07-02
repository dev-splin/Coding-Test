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
			
			// 입력 시작
			for (int i = 0; i < t; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(stk.nextToken());
				int k = Integer.parseInt(stk.nextToken());
				
				// 건설 시간
				int times[] = new int[n+1];
				// 인덱스에 해당하는 건물을 만들기 위한 이전 건물 수
				// ex) edges[4]가 2라면, edges[4]가 0이 되어야 4번 건물을 건설할 수 있음
				int edges[] = new int[n+1];
				
				stk = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++)
					times[j] = Integer.parseInt(stk.nextToken());
				
				// 해당 인덱스를 건설한 다음 건설할 수 있는 건물을 저장
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
				
				// 목표 건물 설정
				int dst = Integer.parseInt(br.readLine());
				// 입력 종료
				
				// 건설할 수 있는(edges가 0인) 건물들을 넣을 큐
				Queue<Integer> q = new LinkedList<>();
				// 해당 인덱스의 건물을 건설하는데 까지 걸린 시간
				int arrivalTime[] = new int[n+1];
				
				// 해당 인덱스 건물의 건설시간을 미리 넣어주고, 처음에 건설할 수 있는(edges가 0인)건물을 큐에 넣음
				for (int j = 1; j <= n; j++) {
					arrivalTime[j] = times[j];
				
					if(edges[j] == 0) {
						q.add(j);
					}
				}
				
				while(!q.isEmpty()) {
					int curNum = q.poll();
					
					for(Integer num : list[curNum]) {
						// num에 해당하는 건물은 curNum에 해당하는 건물을 건설한 후 건설할 수 있기 때문에
						// curNum을 건설하기 까지의 시간(arrivalTime[curNum) + 현재 num을 건설하는 시간(times[num])
						// 과 현재 num을 건설하기 까지(arrivalTime[num])의 시간 중 최대 값을 넣어줍니다.
						
						// 최대 값을 넣어주는 이유는 num을 건설하기 위해서는 먼저 건설해야하는 건물들이 모두 건설되어야 하기 때문입니다.
						// 예를 들어, 4번 건물을 건설하기 위해서 2번 건물(건설시간 1초)과 3번 건물(건설시간 100초)을 완료해야 한다면,
						// 2번 건물은 1초만에 건설이 끝났다고 하더라도 3번 건물이 건설 완료되어야 4번 건물을 건설할 수 있기 때문에
						// 결국 4번 건물을 건설하기 위해서는 2번 건물 건설(1초 소요)이 끝나고 3번 건물 건설(100초 소요)이 끝나야 합니다. (동시 진행 가능)
						arrivalTime[num] = Math.max(arrivalTime[num], arrivalTime[curNum] + times[num]);
						
						// 건설할 수 있는(edges가 0인)건물을 큐에 넣음
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
