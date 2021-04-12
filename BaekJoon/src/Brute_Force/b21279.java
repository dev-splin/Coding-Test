 package Brute_Force;

 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.InputStreamReader;
 import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

 public class b21279 {
	 static List<Mineral> minerals[];
	 final static int MAX_NUM = 100000;
	 
	 public static class Mineral{
		 int x;
		 long v;
		 
		 public Mineral() {
		}
		 
		 public Mineral(int x, long v) {
			 this.x = x;
			 this.v = v;
			}
	 }
	 
 	public static void main(String[] args) {
 		InputStreamReader isr = new InputStreamReader(System.in);
 		BufferedReader br = new BufferedReader(isr);
 		OutputStreamWriter osw = new OutputStreamWriter(System.out);
 		BufferedWriter bw = new BufferedWriter(osw);
 		StringBuilder sb = new StringBuilder();
 		
 		try {
 			// �Է�
 			String nums = br.readLine();
 			StringTokenizer stk = new StringTokenizer(nums);
 			
 			int n = Integer.parseInt(stk.nextToken());
 			int c = Integer.parseInt(stk.nextToken());
 			
 			// y�� �ε���, y�� �ش��ϴ� �࿡ �ִ� �������� ������ ����Ʈ �迭
 			minerals = new ArrayList[MAX_NUM+1];
 			
 			// x�� �ε���, (x,y)��ǥ�� �ε���x�� �����ϰ� �ִ� ������ v,c�� ������ �迭��
 			// v�� ������ ũ�� ������ long���� ����
 			long colV[] = new long[MAX_NUM+1];
 			int colC[] = new int[MAX_NUM+1];
 			
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
 			int count = 0;
 			int y = 0;
 			 
 			// �簢���� x�� �ִ밪���� ���� , y�� �����ϸ鼭 �簢�� ������ ����
 			// 10�� ~ 0���� x�� �پ��
 			for (int x = MAX_NUM; x >= 0; --x) {
 				
 				// y�� ������ ����� �ʰ� count�� c���� �������� y�� ����
 				while(count < c && y <= MAX_NUM) {
 					
 					// y�� �ش��ϴ� �࿡ ������ ���� ��
 					if(minerals[y] == null) {
 						++y;
 						continue;
 					}
 					
 					// ������ ���� �� �࿡ �ִ� �� ��, �簢�� ���� �ȿ� ���ԵǴ� ����(�簢���� x���� ����)�� ����
 					for(Mineral mineral : minerals[y]) {
 	 					
 	 					if(mineral.x <= x) {
 	 						sum += mineral.v;
 	 						++count;
 	 						
 	 						colV[mineral.x] += mineral.v;
 	 						++colC[mineral.x];
 	 					}
 	 				}
 					// ���� üũ �� y����
 					++y;
 				}
 				// count�� c�� �� �������� ���� ���� �ֱ� ������ <=
 				if(count <= c)
 					if(max < sum)
 						max = sum;
 				
 				// x�� ��� �پ��� ������ ���� x�� ���Ե� �������� ����
				if(colC[x] != 0) 
 					sum -= colV[x];
 					count -= colC[x];
			}
 			
 			System.out.println(max);
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 	}
 }
