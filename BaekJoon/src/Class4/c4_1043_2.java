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
	// 부모를 저장할 배열
	static int parent[];
	// 진실을 아는 사람의 인덱스를 저장
	static List<Integer> knows;
		
	// 부모를 찾아서 부모가 다르면 서로 연결해 줍니다.
	public static void union(int a, int b) {
		int num1 = find(a);
		int num2 = find(b);
		if(num1 != num2)
			parent[num2] = num1;
	}
	
	// 부모를 찾습니다. 최상위 부모는 자기 자신을 가르킵니다.
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
			// 입력 시작
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			parent = new int[51];
			// 각 파티에 속한 인덱스들을 저장
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
			// 진실을 아는 사람들 까지 입력 끝
			
			// 파티에 오는 사람들
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				int count = Integer.parseInt(stk.nextToken());
				
				// 이전 인덱스
				int prev = 0;
				
				list[i] = new ArrayList<>();
				
				for (int j = 0; j < count; j++) {
					int num = Integer.parseInt(stk.nextToken());
					
					// 이전 인덱스가 0이 아니라면, 서로 연결해줍니다.
					// 이전 인덱스가 0이라는 것은 파티에서 맨 처음에 입력한 인덱스이기 때문에 합칠 게 없습니다.
					if(prev != 0) 
						union(prev, num);
					
					// 현재 인덱스를 이전 인덱스로 설정
					prev = num;
					list[i].add(num);
				}
			}
			
			int ans = 0;
			
			for (int i = 0; i < m; i++) {
				boolean isPossible = true;
				
				for(Integer know : knows) {
					// 진실을 알고있는 사람들의 최상위 부모
					int knowNum = find(know);
					
					// 각 파티마다 순회 (파티에 아무도 없는 경우는 List가 비어있기 때문에 counting 됩니다.)
					for(Integer num : list[i])
						
						// 진실을 알고있는 사람의 최상위 부모와 파티에 속한 인덱스의 최상위 부모가 같으면 과장된 파티가 아닙니다. 
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
