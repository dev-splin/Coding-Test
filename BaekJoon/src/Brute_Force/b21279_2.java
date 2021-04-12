package Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

 public class b21279_2 {
	 static List<Mineral> minerals[];
	 final static int MAX_NUM = 100000;
	 
	 public static class Mineral implements Comparable<Mineral>{
		 int x;
		 long v;
		 
		 public Mineral() {
		}
		 
		 public Mineral(int x, long v) {
			 this.x = x;
			 this.v = v;
		}

		@Override
		public int compareTo(Mineral o) {
			return o.x - this.x;
		}
	 }
	 
 	public static void main(String[] args) {
 		InputStreamReader isr = new InputStreamReader(System.in);
 		BufferedReader br = new BufferedReader(isr);
 		
 		try {
 			// 입력
 			String nums = br.readLine();
 			StringTokenizer stk = new StringTokenizer(nums);
 			
 			int n = Integer.parseInt(stk.nextToken());
 			int c = Integer.parseInt(stk.nextToken());
 			
 			// y가 인덱스, y에 해당하는 행에 있는 광물들을 저장할 리스트 배열
 			minerals = new ArrayList[MAX_NUM+1];
 			
 			// 우선순위 큐, Mineral에서 CompareTo로 x기준 내림차순으로 정해주었습니다.
 			PriorityQueue<Mineral> queue = new PriorityQueue<>();
 			
 			for (int i = 0; i < n; i++) {
				nums = br.readLine();
				stk = new StringTokenizer(nums);
				
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				long v = Long.parseLong(stk.nextToken());
				
				if(minerals[y] == null)
					minerals[y] = new ArrayList<>();
				
				// 리스트 배열의 인덱스가 y이기 때문에 광물은 x,v만 저장
				Mineral mineral = new Mineral(x,v);
				
				minerals[y].add(mineral);
			}
 			// 입력 끝
 			
 			long sum = 0;
 			long max = 0;
 			
 			// y를 증가시키면서, 행에 있는 값들을 가져옵니다.
 			for (int y = 0; y <= MAX_NUM; y++) {
 				if(minerals[y] == null)
 					continue;
 				
 				for(Mineral mineral : minerals[y]) {
 					queue.add(mineral);
 					sum += mineral.v;
 				}
 				
 				int prevX = 0;
 				// 큐에 값이 들어있지 않거나 큐의 사이즈가 c이하가 될 때까지 반복합니다.
 				// 큐에 들어있는 값 중, 해당 행의 x최대 값(사각형의 꼭짓점)을 구한 후 최대 값과 같은 크기를 가지는 광물을 큐에서 뺍니다.
 				// 즉, x의 값을 줄이는 것입니다. (사각형의 범위를 줄이는 것) 
 				while(!queue.isEmpty() && queue.size() > c) {
 					prevX = queue.peek().x;
 					
 					while(!queue.isEmpty() && queue.peek().x == prevX)
 						sum -= queue.poll().v;
 				}
 				
 				max = Math.max(max, sum);
			}
 			
 			System.out.println(max);
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 	}
 }
