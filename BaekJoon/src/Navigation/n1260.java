package Navigation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class n1260 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
	
	// ��� Ŭ����, ������ ������ ����Ʈ�� ������ �ֽ��ϴ�.
	public static class Node {
		int nodeNum;
		List<Node>  adjacentNodes;
		
		public Node(int num) {
			this.nodeNum = num;
			adjacentNodes = new ArrayList<>();
		}
		
		public int getNodeNum() {
			return nodeNum;
		}
		
		public void setNodeNum(int nodeNum) {
			this.nodeNum = nodeNum;
		}
		
		public void add(Node node) {
			adjacentNodes.add(node);
		}		
	}
	
	// ���������� �־��ִ� �Լ��Դϴ�.
	public static void insertMainLine(Node[] nodes, int m) throws Exception {
		for (int i = 0; i < m; i++) {
			String nodeNums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(nodeNums);
			
			int nodeNum1 = Integer.parseInt(stk.nextToken()) - 1;
			int nodeNum2 = Integer.parseInt(stk.nextToken()) - 1;
			
			nodes[nodeNum1].add(nodes[nodeNum2]);
			nodes[nodeNum2].add(nodes[nodeNum1]);
		}				
	}
	
	// stack�� �̿��� DFS�Դϴ�. 
	public static List<Node> DFS(Node[] nodes, int v) {
		Stack<Node> stack = new Stack<>();
		Node startNode = nodes[v-1];
		List<Node> DFSNodes = new ArrayList<>();
		
		stack.add(startNode);
		
		while(!stack.empty()) {
			Node checkNode = stack.pop();
			
			// DFS����Ʈ�� ��尡 ������ ���ÿ� �߰����� ���� �����ϴ� �κ��� �ǳ� �ݴϴ�.
			if(DFSNodes.contains(checkNode))
				continue;
			
			DFSNodes.add(checkNode);
			
			for(Node node : checkNode.adjacentNodes) {
				if(!DFSNodes.contains(node))
					stack.add(node);
			}
		}
				
		return DFSNodes;
	}
	
	// ��� �Լ��� �̿��� DFS �����Դϴ�. �̹� Ž���ؼ� ����Ʈ�ȿ� �ִ� ���� �Լ��� �����ְ�
	// ������ ����Ʈ�� �߰����� ��, ���� ������ ��͸� �̿��� üũ�� �ݴϴ�.
	public static void recursionDFS(List<Node> nodes, Node startNode) {
		if(nodes.contains(startNode))
			return;
		
		nodes.add(startNode);
		
		for(Node node : startNode.adjacentNodes) {
			recursionDFS(nodes, node);
		}
	}

	// queue�� �̿��� DFS�Դϴ�. 
	public static List<Node> BFS(Node[] nodes, int v) {	
		Queue<Node> queue = new LinkedList<>();
		Node startNode = nodes[v-1];
		List<Node> BFSNodes = new ArrayList<>();
		
		queue.add(startNode);
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(BFSNodes.contains(checkNode))
				continue;
			
			BFSNodes.add(checkNode);
			
			for(Node node : checkNode.adjacentNodes) {
				if(!BFSNodes.contains(node))
					queue.add(node);
			}
		}
		
		return BFSNodes;
	}
	

	
	public static void main(String[] args) {
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(nums);
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			
			Node[] nodes = new Node[n];
			
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node(i+1);
			}
			
			insertMainLine(nodes,m);
			
			// ����Լ��� �̿��� 
//			for(Node node : nodes)
//				Collections.sort(node.adjacentNodes,(a,b)->a.nodeNum-b.nodeNum);
//			List<Node> recusionNodes = new ArrayList<>();
//			recursionDFS(recusionNodes, nodes[v-1]);
			
			// DFS�� BFS ����Ʈ�� ��ȯ ���� �����Դϴ�.
			List<Node> NavigationNodes;
			// DFS�� ����Ǳ� �� ���� ��尡 ������ ���� �� ���� ��� ���� ���� �ϹǷ� ������������ ���־����ϴ�.
			// ������������ �� ������ DFS�� ������ �̿��ϴµ�, ������ ���Լ����̱� ������ �������� �� ���� ���� ���ڰ� ���� ���� ������ �����Դϴ�. 
			for(Node node : nodes)
				Collections.sort(node.adjacentNodes,(a,b)->b.nodeNum-a.nodeNum);
			NavigationNodes = DFS(nodes,v);
			
			// DFS ���(����Լ��� ����� ��, NavigationNodes�� recusionNodes�� �ٲ��־�� �մϴ�.)
			for(Node node : NavigationNodes) {
				bw.write(Integer.toString(node.nodeNum) + " ");
			}
			bw.newLine();
			
			// BFS�� ť�� ���� �����̱� ������ ������������ ���������� �������־����ϴ�.
			for(Node node : nodes)
				Collections.sort(node.adjacentNodes,(a,b)->a.nodeNum-b.nodeNum);
			NavigationNodes = BFS(nodes,v);
			
			// BFS ���
			for(Node node : NavigationNodes) {
				bw.write(Integer.toString(node.nodeNum) + " ");
			}
			bw.newLine();
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


