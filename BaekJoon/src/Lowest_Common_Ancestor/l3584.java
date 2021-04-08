package Lowest_Common_Ancestor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class l3584 {
	// 최대 노드 수
	final static int MAX_NODE = 10001;
	// 2^i번째 부모 노드를 표현할 때, i에 올 수 있는 최대값 (노드 수 보다 커야함) 
	final static int MAX_LEVEL = 14;
	static int n;
	
	// 깊이를 저장할 배열
	static int level[];
	// [노드번호][i]로 이루어질 2차원 배열입니다.
	// i는 2^i번째 부모 노드를 표현할 때, i입니다. 즉, [1][3]이면 노드 1의 8번째(2^3) 부모를 말합니다.
	static int parents[][];
	// 연결된 노드를 저장할 리스트(노드가 n개 만큼 있으므로 n+1(노드1이 배열1에 올 수 있게 + 1)개의 리스트를 생성할 것입니다.
	static List<Integer> adjacentNodes[];
	// 해당 인덱스를 노드번호, 값을 부모노드로 사용할 배열입니다.
	static int parentNode[];
	
	// 1번 조건
	// DFS를 이용해 루트노드부터 깊이를 구해줍니다.
	public static void DFS(int node, int depth) {
		
		level[node] = depth;
		
		for(int adjacentNode : adjacentNodes[node]) {
			
			// 이미 깊이가 설정되어 있으면 스킵
			if(level[adjacentNode] != 0)
				continue;
			
			// 현재 노드(node)의 인접 노드들은 자식 노드이기 때문에
			// [자식노드][0] 즉, 자식노드의 1번째(2^0) 부모는 현재 노드(node)가 됩니다.
			parents[adjacentNode][0] = node;
			DFS(adjacentNode,depth + 1);
		}
	}
	
	// 입력된 간선 정보를 이용해 트리를 만듭니다.
	public static void setParent() {
		int startNode = 0;
		
		// 부모노드를 저장한 배열을 이용해 시작노드(루트)를 구해줍니다.
		for (int i = 1; i <= n; i++) {
			if(parentNode[i] == 0)
				startNode = i;
		}
		
		DFS(startNode,1);
		
		// 2번 조건
		// DFS를 수행하고 나면 각 노드들의 1번째(2^0)부모만이 저장되었기 때문에 저장할 수 있는(루트노드를 넘지 않는) 2^i번째 부모를 구합니다.
		for (int i = 1; i <= MAX_LEVEL; i++)
			for (int j = 1; j <= n; j++)
				// 2^i번째 부모를 구하기 위해서 2^(i-1)의부모의 2^(i-1)부모를 이용할 수 있습니다. (DP)
				// 문제의 그래프로 예를 들면, 
				// [3][1] 3번노드의 2번째(2^1)부모노드 10은 [16][1] 즉, 3번노드의 1번째(2^0) 부모노드[16]의 1번째(2^0) 부모노드[0] 와 같습니다.
				// 또, [3][2]는 [10][1]과 같은 것을 볼 수 있습니다.
				
				// 반복문 시작을 1로 둔 것은 DFS를 수행하고 나면 각 노드들의 1번째(2^0)부모만이 저장되었기 때문에
				// 위의 DP성질(i-1)을 이용해 차근차근 부모노드를 구할 수 있기 때문입니다.
				// 예를 들면, 각 노드(j)의 2번째(2^1) 부모노드[n][1]을 구하면 부모노드도 n에 속해있기 때문에
				// 다음 반복문 [n][2]를 부모노드 [n][1]을 이용해 차근차근 구할 수 있습니다.
				parents[j][i] = parents[parents[j][i-1]][i-1];

	}
	
	// 최소 공통 조상을 구합니다.
	public static int LCA(int a, int b) {
		
		// 4번 조건
		// 어떤 인자가 깊이가 깊은지 알 수 없기 때문에 b를 깊이가 깊은 변수로 설정합니다.
		if(level[a] > level[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		// 가장 상단에 있는 부모노드 부터 내려오면서 깊이를 체크해 a보다 깊이가 더 깊으면 b를 해당 부모노드로 변경해줍니다.
		// i가 1씩 감소하기 때문에 b로 변한 부모노드의 1번째 (2^0)부모노드 까지 체크하게 되므로 깊이가 같아질 수 있습니다.
		// 예를 들면, 4(a)과 3(b)의 노드가 있으면 3의 상단 노드부터 체크하다가 4보다 깊이가 같거나 깊은 10을 만나게되면 b가 10으로 변하게 됩니다.
		// 4로 변하지 않는 이유는 부모는 2^i 번째만 저장하기 때문에 3번째 부모인 4는 저장되어 있지 않기 때문입니다.
		// 하지만, b가 10인 상태에서 i가 0까지 내려오기 때문에 b의 1번째(2^0) 부모인 4가 될 수 있습니다.
		for (int i = MAX_LEVEL; i >= 0; --i) 
			if(level[a] <= level[parents[b][i]])
				b = parents[b][i];
		
		// 위와 같이 4와 3의 경우처럼 깊이가 같으면서 공통 조상을 갖게 되므로 바로 종료하면 됩니다.
		if(b == a)
			return a;
		else {
			// 5번 조건
			// 깊이는 같지만 공통 조상이 아직 아닐경우
			// 위와 같이 최상단 노드 부터 탐색합니다.
			for (int i = MAX_LEVEL; i >= 0; --i) 
				// 깊이를 맞춰주는 부분과 비슷합니다. 최상단에 있을 수록 공통 조상(최소는 아닐수도)이 많기 때문에
				// 두 부모가 다를 때(최소 공통 조상 보다 깊이가 깊어짐) a와 b를 해당 부모로 교체하게 됩니다.
				// 하지만 위와 같이 결국 i가 0에 도달하기 때문에 a와 b는 최소 공통 조상의 바로 아래의 노드가 됩니다.(a와 b가 다를 때만 바꿔주기 때문)
				if(parents[a][i] != parents[b][i]) {
					a = parents[a][i];
					b = parents[b][i];
				}
					
			// a와 b가 최소 공통 조상의 바로 아래의 노드이기 때문에 1번째(2^0)부모가 최소 공통 조상입니다.
			return parents[a][0];
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		StringBuilder sb = new StringBuilder();
		
		try {
			// 입력 시작
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				n = Integer.parseInt(br.readLine());
				
				level = new int[n+1];
				parents = new int[n+1][MAX_LEVEL+1];
				adjacentNodes = new ArrayList[n+1];
				parentNode = new int[n+1];
				
				for (int j = 1; j <= n; j++)
					adjacentNodes[j] = new ArrayList<>();
				
				for (int j = 1; j <= n; j++) {
					String nodes = br.readLine();
					StringTokenizer stk = new StringTokenizer(nodes);
					
					int a = Integer.parseInt(stk.nextToken());
					int b = Integer.parseInt(stk.nextToken());
					// 입력 끝
					
					// 3번 조건
					// 간선은 n-1개고 n번째에서는 LCA를 찾을 두 노드를 입력하기 때문
					if(j == n) {
						setParent();
						System.out.println(LCA(a,b));
						break;
					}
					
					adjacentNodes[a].add(b);
					adjacentNodes[b].add(a);
					parentNode[b] = a;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
