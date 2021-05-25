package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class c4_1043 {
	static int n;
	// 각 파티에서 과장된 이야기를 들은 인덱스를 저장
	static List<Integer> partys[];
	// 각 인덱스가 과장된 이야기를 들었던 파티를 저장
	static List<Integer> liePartys[];
	// 진실을 알고 있는 인덱스
	static boolean know[];
	
	// 파라미터로 들어온 파티번호에 해당하는 인덱스들이 진실을 알게 되고,
	// 그 인덱스들이 포함된 다른 파티의 인덱스들도 연쇄적으로 진실을 알게 되기 때문에 DFS를 사용합니다.
	public static void DFS (int partyNum) {
			
		if(partys[partyNum] == null)
			return;
			
		for(Integer index : partys[partyNum]) {
			// 이미 진실을 알고 있는 인덱스는 liePartys를 가지고 있지 않고
			// 새롭게 진실을 알게된 인덱스는 know를 true로 바꿔준 후 liePartys를 검사하게 됩니다.
			// 만약, 이 조건이 없다면 새롭게 진실을 알게된 인덱스가 다른 파티에도 존재하기 때문에 무한 루프에 빠지게 됩니다.
			if(know[index])
				continue;
			
			know[index] = true;
			
			for(Integer lieParty : liePartys[index])
				DFS(lieParty);
		}
		// 파티에 있는 인덱스들 체크가 끝났으면 해당 파티는 과장된 파티를 체크할 때 제외하기 위해 null을 넣어줍니다.
		partys[partyNum] = null;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			// 입력 시작
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			liePartys = new ArrayList[51];
			know = new boolean[51];
			
			for (int i = 1; i <= n; i++)
				liePartys[i] = new ArrayList<>();
			
			stk = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(stk.nextToken());
			
			for (int i = 0; i < k; i++)
				know[Integer.parseInt(stk.nextToken())] = true;
			// 진실을 아는 사람 입력까지 완료
			
			partys = new ArrayList[m];
			
			// 파티에 오는 사람들
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				int count = Integer.parseInt(stk.nextToken());
				
				partys[i] = new ArrayList<>();
				
				boolean isPossible = true;
				
				for (int j = 0; j < count; j++) {
					int num = Integer.parseInt(stk.nextToken());
					
					partys[i].add(num);
					
					// 진실을 알고 있는 인덱스가 1개라도 있으면 과장된 이야기를 할 수 없는 파티
					if(know[num])
						isPossible = false;
					// 진실을 알고 있는 인덱스가 1개도 없으면 과장된 파티이기 때문에 저장해 둔다.
					else
						liePartys[num].add(i);
				}
				
				// 과장된 이야기를 할 수 없는 파티이면 DFS를 이용해 현재 파티의 인덱스들과 연관되어있고 포함되어있는 파티들을 null로 바꿔줍니다.
				if(!isPossible)
					DFS(i);
			}
			
			int ans = 0;
			
			// 파티가 null이 아니라면 과장된 파티 (파티에 아무도 없는 경우에는 DFS에서 null로 만들 수 없기 때문에 counting 됩니다.)
			for (int i = 0; i < m; i++)
				if(partys[i] != null)
					++ans;
			
			System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
