package Lowest_Common_Ancestor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class l3584 {
	// �ִ� ��� ��
	final static int MAX_NODE = 10001;
	// 2^i��° �θ� ��带 ǥ���� ��, i�� �� �� �ִ� �ִ밪 (��� �� ���� Ŀ����) 
	final static int MAX_LEVEL = 14;
	static int n;
	
	// ���̸� ������ �迭
	static int level[];
	// [����ȣ][i]�� �̷���� 2���� �迭�Դϴ�.
	// i�� 2^i��° �θ� ��带 ǥ���� ��, i�Դϴ�. ��, [1][3]�̸� ��� 1�� 8��°(2^3) �θ� ���մϴ�.
	static int parents[][];
	// ����� ��带 ������ ����Ʈ(��尡 n�� ��ŭ �����Ƿ� n+1(���1�� �迭1�� �� �� �ְ� + 1)���� ����Ʈ�� ������ ���Դϴ�.
	static List<Integer> adjacentNodes[];
	// �ش� �ε����� ����ȣ, ���� �θ���� ����� �迭�Դϴ�.
	static int parentNode[];
	
	// 1�� ����
	// DFS�� �̿��� ��Ʈ������ ���̸� �����ݴϴ�.
	public static void DFS(int node, int depth) {
		
		level[node] = depth;
		
		for(int adjacentNode : adjacentNodes[node]) {
			
			// �̹� ���̰� �����Ǿ� ������ ��ŵ
			if(level[adjacentNode] != 0)
				continue;
			
			// ���� ���(node)�� ���� ������ �ڽ� ����̱� ������
			// [�ڽĳ��][0] ��, �ڽĳ���� 1��°(2^0) �θ�� ���� ���(node)�� �˴ϴ�.
			parents[adjacentNode][0] = node;
			DFS(adjacentNode,depth + 1);
		}
	}
	
	// �Էµ� ���� ������ �̿��� Ʈ���� ����ϴ�.
	public static void setParent() {
		int startNode = 0;
		
		// �θ��带 ������ �迭�� �̿��� ���۳��(��Ʈ)�� �����ݴϴ�.
		for (int i = 1; i <= n; i++) {
			if(parentNode[i] == 0)
				startNode = i;
		}
		
		DFS(startNode,1);
		
		// 2�� ����
		// DFS�� �����ϰ� ���� �� ������ 1��°(2^0)�θ��� ����Ǿ��� ������ ������ �� �ִ�(��Ʈ��带 ���� �ʴ�) 2^i��° �θ� ���մϴ�.
		for (int i = 1; i <= MAX_LEVEL; i++)
			for (int j = 1; j <= n; j++)
				// 2^i��° �θ� ���ϱ� ���ؼ� 2^(i-1)�Ǻθ��� 2^(i-1)�θ� �̿��� �� �ֽ��ϴ�. (DP)
				// ������ �׷����� ���� ���, 
				// [3][1] 3������� 2��°(2^1)�θ��� 10�� [16][1] ��, 3������� 1��°(2^0) �θ���[16]�� 1��°(2^0) �θ���[0] �� �����ϴ�.
				// ��, [3][2]�� [10][1]�� ���� ���� �� �� �ֽ��ϴ�.
				
				// �ݺ��� ������ 1�� �� ���� DFS�� �����ϰ� ���� �� ������ 1��°(2^0)�θ��� ����Ǿ��� ������
				// ���� DP����(i-1)�� �̿��� �������� �θ��带 ���� �� �ֱ� �����Դϴ�.
				// ���� ���, �� ���(j)�� 2��°(2^1) �θ���[n][1]�� ���ϸ� �θ��嵵 n�� �����ֱ� ������
				// ���� �ݺ��� [n][2]�� �θ��� [n][1]�� �̿��� �������� ���� �� �ֽ��ϴ�.
				parents[j][i] = parents[parents[j][i-1]][i-1];

	}
	
	// �ּ� ���� ������ ���մϴ�.
	public static int LCA(int a, int b) {
		
		// 4�� ����
		// � ���ڰ� ���̰� ������ �� �� ���� ������ b�� ���̰� ���� ������ �����մϴ�.
		if(level[a] > level[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		// ���� ��ܿ� �ִ� �θ��� ���� �������鼭 ���̸� üũ�� a���� ���̰� �� ������ b�� �ش� �θ���� �������ݴϴ�.
		// i�� 1�� �����ϱ� ������ b�� ���� �θ����� 1��° (2^0)�θ��� ���� üũ�ϰ� �ǹǷ� ���̰� ������ �� �ֽ��ϴ�.
		// ���� ���, 4(a)�� 3(b)�� ��尡 ������ 3�� ��� ������ üũ�ϴٰ� 4���� ���̰� ���ų� ���� 10�� �����ԵǸ� b�� 10���� ���ϰ� �˴ϴ�.
		// 4�� ������ �ʴ� ������ �θ�� 2^i ��°�� �����ϱ� ������ 3��° �θ��� 4�� ����Ǿ� ���� �ʱ� �����Դϴ�.
		// ������, b�� 10�� ���¿��� i�� 0���� �������� ������ b�� 1��°(2^0) �θ��� 4�� �� �� �ֽ��ϴ�.
		for (int i = MAX_LEVEL; i >= 0; --i) 
			if(level[a] <= level[parents[b][i]])
				b = parents[b][i];
		
		// ���� ���� 4�� 3�� ���ó�� ���̰� �����鼭 ���� ������ ���� �ǹǷ� �ٷ� �����ϸ� �˴ϴ�.
		if(b == a)
			return a;
		else {
			// 5�� ����
			// ���̴� ������ ���� ������ ���� �ƴҰ��
			// ���� ���� �ֻ�� ��� ���� Ž���մϴ�.
			for (int i = MAX_LEVEL; i >= 0; --i) 
				// ���̸� �����ִ� �κа� ����մϴ�. �ֻ�ܿ� ���� ���� ���� ����(�ּҴ� �ƴҼ���)�� ���� ������
				// �� �θ� �ٸ� ��(�ּ� ���� ���� ���� ���̰� �����) a�� b�� �ش� �θ�� ��ü�ϰ� �˴ϴ�.
				// ������ ���� ���� �ᱹ i�� 0�� �����ϱ� ������ a�� b�� �ּ� ���� ������ �ٷ� �Ʒ��� ��尡 �˴ϴ�.(a�� b�� �ٸ� ���� �ٲ��ֱ� ����)
				if(parents[a][i] != parents[b][i]) {
					a = parents[a][i];
					b = parents[b][i];
				}
					
			// a�� b�� �ּ� ���� ������ �ٷ� �Ʒ��� ����̱� ������ 1��°(2^0)�θ� �ּ� ���� �����Դϴ�.
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
			// �Է� ����
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
					// �Է� ��
					
					// 3�� ����
					// ������ n-1���� n��°������ LCA�� ã�� �� ��带 �Է��ϱ� ����
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
