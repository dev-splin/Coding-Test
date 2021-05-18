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
			
			// �ش� �ε���(����)�� �湮�� �ð��� ����
			int time[] = new int[100001];
			int count[] = new int[100001];
			
			Queue<Integer> q = new LinkedList<>();
			
			// ó�� �ð��� 0
			time[n] = 0;
			// ó�� ����(n)�� �湮�� ���ڴ� 1��(�ڱ� �ڽ�)
			count[n] = 1;
			q.add(n);
			
			// 
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				// ť�� �����鼭 �湮 üũ�� �߱� ������ ��ǥ ��ġ�� ������ ���� ����
				if(cur == k)
					break;
				
				int nexts[] = {cur - 1, cur + 1, cur * 2};
				
				for(int next : nexts) {
					// ������ ������ ��ŵ
					if(next < 0 || next > 100000)
						continue;
					
					// �ð��� 0 ��, �湮�� ���� ���� ��
					if(time[next] == 0) {
						q.add(next);
						time[next] = time[cur] + 1;
						
						// 1->2(*2)->4(*2), 1->2(+1)->4(*2)�� ��쿡�� ���� ���ڰ� 2��� �����ϸ�,
						// ���� ����(2)�� �����ϴ� �������� ���(count[2])�� ������
						// ���� ����(4)�� ���� ���ڿ� ������ ����� ������ŭ(count[4] = count[2]) �� �� �ֽ��ϴ�.
						// ������ 1�� �ִ� ���� �ƴϰ� ���� ���ڿ� ������ ���� ��ŭ �־��ݴϴ�.
						count[next] = count[cur];
						
					// �湮�� ���� ������, ���� �ð��� �������� ���� ���� ���� ������ ���� ���ڿ� ������ ���� ��ŭ �����ݴϴ�.
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
