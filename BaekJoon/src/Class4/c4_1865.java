package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_1865 {
	static final int INF = 1000000000;
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			// 테스트 케이스 입력
			int tc= Integer.parseInt(br.readLine());
			
			// 입력 시작
			for (int i = 0; i < tc; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(stk.nextToken());
				int m = Integer.parseInt(stk.nextToken());
				int w = Integer.parseInt(stk.nextToken());
				
				int arr[][] = new int[n+1][n+1];
				
				// 자기자신으로 돌아오는 경우도 구해야 하기 때문에 모두 INF로 초기화
				for (int j = 1; j <= n; j++)
					for (int k = 1; k <= n; k++)
						arr[j][k] = INF;
				
				// 도로
				for (int j = 0; j < m; j++) {
					stk = new StringTokenizer(br.readLine());
					
					int node1 = Integer.parseInt(stk.nextToken());
					int node2 = Integer.parseInt(stk.nextToken());
					int time = Integer.parseInt(stk.nextToken());
					
					// 두 지점을 연결하는 도로가 두 개 이상일 수도 있기 때문에 시간이 작은 경우만 넣어줍니다.
					if(arr[node1][node2] < time)
						continue;
					
					arr[node1][node2] = time;
					arr[node2][node1] = time;
				}
				
				// 웜홀은 시간이 줄어들기 때문에 -로 넣어줍니다.
				for (int j = 0; j < w; j++) {
					stk = new StringTokenizer(br.readLine());
					
					int node1 = Integer.parseInt(stk.nextToken());
					int node2 = Integer.parseInt(stk.nextToken());
					int time = Integer.parseInt(stk.nextToken());
					arr[node1][node2] = -time;
				}
				// 입력 끝
				
				// 플로이드 와샬
				for (int k = 1; k <= n; k++)
					for (int j = 1; j <= n; j++)
						for (int l = 1; l <= n; l++)
							if(arr[j][l] > arr[j][k] + arr[k][l])
								arr[j][l] = arr[j][k] + arr[k][l];
				
				boolean isPossible = false;
				
				// 자기자신으로 돌아가는 경우 중 0보다 작은 경우가 있으면 시간이 되돌아가 있는 경우
				for (int j = 1; j <= n; j++)
					if(arr[j][j] < 0)
						isPossible = true;
				
				if(isPossible)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
