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
 			// �Է�
 			String nums = br.readLine();
 			StringTokenizer stk = new StringTokenizer(nums);
 			
 			int n = Integer.parseInt(stk.nextToken());
 			int c = Integer.parseInt(stk.nextToken());
 			
 			// y�� �ε���, y�� �ش��ϴ� �࿡ �ִ� �������� ������ ����Ʈ �迭
 			minerals = new ArrayList[MAX_NUM+1];
 			
 			// �켱���� ť, Mineral���� CompareTo�� x���� ������������ �����־����ϴ�.
 			PriorityQueue<Mineral> queue = new PriorityQueue<>();
 			
 			for (int i = 0; i < n; i++) {
				nums = br.readLine();
				stk = new StringTokenizer(nums);
				
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				long v = Long.parseLong(stk.nextToken());
				
				if(minerals[y] == null)
					minerals[y] = new ArrayList<>();
				
				// ����Ʈ �迭�� �ε����� y�̱� ������ ������ x,v�� ����
				Mineral mineral = new Mineral(x,v);
				
				minerals[y].add(mineral);
			}
 			// �Է� ��
 			
 			long sum = 0;
 			long max = 0;
 			
 			// y�� ������Ű�鼭, �࿡ �ִ� ������ �����ɴϴ�.
 			for (int y = 0; y <= MAX_NUM; y++) {
 				if(minerals[y] == null)
 					continue;
 				
 				for(Mineral mineral : minerals[y]) {
 					queue.add(mineral);
 					sum += mineral.v;
 				}
 				
 				int prevX = 0;
 				// ť�� ���� ������� �ʰų� ť�� ����� c���ϰ� �� ������ �ݺ��մϴ�.
 				// ť�� ����ִ� �� ��, �ش� ���� x�ִ� ��(�簢���� ������)�� ���� �� �ִ� ���� ���� ũ�⸦ ������ ������ ť���� ���ϴ�.
 				// ��, x�� ���� ���̴� ���Դϴ�. (�簢���� ������ ���̴� ��) 
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
