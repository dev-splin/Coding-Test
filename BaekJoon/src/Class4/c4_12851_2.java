package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class c4_12851_2 {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			// 해당 인덱스(숫자)를 방문한 시간과 개수
			int time[] = new int[100001];
			int count[] = new int[100001];
			
			Queue<Integer> q = new LinkedList<>();
			
			// 처음 시간은 0
			time[n] = 0;
			// 처음 숫자(n)을 방문한 숫자는 1개(자기 자신)
			count[n] = 1;
			q.add(n);
			
			// 
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				// 큐에 넣으면서 방문 체크를 했기 때문에 목표 위치와 같으면 루프 종료
				if(cur == k)
					break;
				
				int nexts[] = {cur - 1, cur + 1, cur * 2};
				
				for(int next : nexts) {
					// 범위를 넘으면 스킵
					if(next < 0 || next > 100000)
						continue;
					
					// 시간이 0 즉, 방문한 적이 없는 곳
					if(time[next] == 0) {
						q.add(next);
						time[next] = time[cur] + 1;
						
						// 1->2(*2)->4(*2), 1->2(+1)->4(*2)의 경우에서 현재 숫자가 2라고 가정하면,
						// 현재 숫자(2)에 도착하는 여러가지 방법(count[2])이 있으면
						// 다음 숫자(4)도 현재 숫자에 도착한 방법의 개수만큼(count[4] = count[2]) 올 수 있습니다.
						// 때문에 1을 넣는 것이 아니고 현재 숫자에 도착한 개수 만큼 넣어줍니다.
						count[next] = count[cur];
						
					// 방문한 적이 있지만, 같은 시간에 도착했을 때도 위와 같은 이유로 현재 숫자에 도착한 개수 만큼 더해줍니다.
					} else if(time[next] == time[cur] + 1)
						count[next] += count[cur];
				}
			}
			
			System.out.println(time[k]);
			System.out.println(count[k]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
