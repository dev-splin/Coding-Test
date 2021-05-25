package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class c4_1043_2 {
	static int n;
	// �θ� ������ �迭
	static int parent[];
	// ������ �ƴ� ����� �ε����� ����
	static List<Integer> knows;
		
	// �θ� ã�Ƽ� �θ� �ٸ��� ���� ������ �ݴϴ�.
	public static void union(int a, int b) {
		int num1 = find(a);
		int num2 = find(b);
		if(num1 != num2)
			parent[num2] = num1;
	}
	
	// �θ� ã���ϴ�. �ֻ��� �θ�� �ڱ� �ڽ��� ����ŵ�ϴ�.
	public static int find(int a) {
		if(parent[a] == a)
			return parent[a];
		else
			return parent[a] = find(parent[a]);
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			// �Է� ����
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			parent = new int[51];
			// �� ��Ƽ�� ���� �ε������� ����
			List<Integer> list[] = new ArrayList[m];
			
			for (int i = 0; i <= 50; i++)
				parent[i] = i;
			
			stk = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(stk.nextToken());
			
			knows = new ArrayList<>();
			
			for (int i = 0; i < k; i++) {
				int num = Integer.parseInt(stk.nextToken());
				knows.add(num);
			}
			// ������ �ƴ� ����� ���� �Է� ��
			
			// ��Ƽ�� ���� �����
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				int count = Integer.parseInt(stk.nextToken());
				
				// ���� �ε���
				int prev = 0;
				
				list[i] = new ArrayList<>();
				
				for (int j = 0; j < count; j++) {
					int num = Integer.parseInt(stk.nextToken());
					
					// ���� �ε����� 0�� �ƴ϶��, ���� �������ݴϴ�.
					// ���� �ε����� 0�̶�� ���� ��Ƽ���� �� ó���� �Է��� �ε����̱� ������ ��ĥ �� �����ϴ�.
					if(prev != 0) 
						union(prev, num);
					
					// ���� �ε����� ���� �ε����� ����
					prev = num;
					list[i].add(num);
				}
			}
			
			int ans = 0;
			
			for (int i = 0; i < m; i++) {
				boolean isPossible = true;
				
				for(Integer know : knows) {
					// ������ �˰��ִ� ������� �ֻ��� �θ�
					int knowNum = find(know);
					
					// �� ��Ƽ���� ��ȸ (��Ƽ�� �ƹ��� ���� ���� List�� ����ֱ� ������ counting �˴ϴ�.)
					for(Integer num : list[i])
						
						// ������ �˰��ִ� ����� �ֻ��� �θ�� ��Ƽ�� ���� �ε����� �ֻ��� �θ� ������ ����� ��Ƽ�� �ƴմϴ�. 
						if(knowNum == find(num)) {
							isPossible = false;
							break;
						}
				}
				
				if(isPossible)
					++ans;
			}
			
			System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
