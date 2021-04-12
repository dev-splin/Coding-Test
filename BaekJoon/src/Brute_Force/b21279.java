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
 			// 입력
 			String nums = br.readLine();
 			StringTokenizer stk = new StringTokenizer(nums);
 			
 			int n = Integer.parseInt(stk.nextToken());
 			int c = Integer.parseInt(stk.nextToken());
 			
 			// y가 인덱스, y에 해당하는 행에 있는 광물들을 저장할 리스트 배열
 			minerals = new ArrayList[MAX_NUM+1];
 			
 			// x가 인덱스, (x,y)좌표에 인덱스x를 포함하고 있는 광물의 v,c를 저장할 배열들
 			// v의 범위가 크기 때문에 long으로 저장
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
				
				// 리스트 배열의 인덱스가 y이기 때문에 광물은 x,v만 저장
				Mineral mineral = new Mineral(x,v);
				
				minerals[y].add(mineral);
			}
 			// 입력 끝
 			
 			long sum = 0;
 			long max = 0;
 			int count = 0;
 			int y = 0;
 			 
 			// 사각형의 x는 최대값부터 감소 , y는 증가하면서 사각형 범위를 구함
 			// 10만 ~ 0까지 x가 줄어듬
 			for (int x = MAX_NUM; x >= 0; --x) {
 				
 				// y가 범위를 벗어나지 않고 count가 c보다 작을때만 y를 증가
 				while(count < c && y <= MAX_NUM) {
 					
 					// y에 해당하는 행에 광물이 없을 때
 					if(minerals[y] == null) {
 						++y;
 						continue;
 					}
 					
 					// 광물이 있을 때 행에 있는 값 중, 사각형 범위 안에 포함되는 광물(사각형의 x보다 작은)만 연산
 					for(Mineral mineral : minerals[y]) {
 	 					
 	 					if(mineral.x <= x) {
 	 						sum += mineral.v;
 	 						++count;
 	 						
 	 						colV[mineral.x] += mineral.v;
 	 						++colC[mineral.x];
 	 					}
 	 				}
 					// 광물 체크 후 y증가
 					++y;
 				}
 				// count가 c랑 딱 떨어지지 않을 수도 있기 때문에 <=
 				if(count <= c)
 					if(max < sum)
 						max = sum;
 				
 				// x가 계속 줄어들기 때문에 현재 x가 포함된 광물들을 빼줌
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
