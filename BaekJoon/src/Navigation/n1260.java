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
	
	
	// 노드 클래스, 이인접 노드들을 리스트로 가지고 있습니다.
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
	
	// 인접노드들을 넣어주는 함수입니다.
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
	
	// stack을 이용한 DFS입니다. 
	public static List<Node> DFS(Node[] nodes, int v) {
		Stack<Node> stack = new Stack<>();
		Node startNode = nodes[v-1];
		List<Node> DFSNodes = new ArrayList<>();
		
		stack.add(startNode);
		
		while(!stack.empty()) {
			Node checkNode = stack.pop();
			
			// DFS리스트에 노드가 있으면 스택에 추가할지 말지 결정하는 부분을 건너 뜁니다.
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
	
	// 재귀 함수를 이용한 DFS 구현입니다. 이미 탐색해서 리스트안에 있는 노드면 함수를 끝내주고
	// 없으면 리스트에 추가해준 후, 인접 노드들을 재귀를 이용해 체크해 줍니다.
	public static void recursionDFS(List<Node> nodes, Node startNode) {
		if(nodes.contains(startNode))
			return;
		
		nodes.add(startNode);
		
		for(Node node : startNode.adjacentNodes) {
			recursionDFS(nodes, node);
		}
	}

	// queue을 이용한 DFS입니다. 
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
			
			// 재귀함수를 이용한 
//			for(Node node : nodes)
//				Collections.sort(node.adjacentNodes,(a,b)->a.nodeNum-b.nodeNum);
//			List<Node> recusionNodes = new ArrayList<>();
//			recursionDFS(recusionNodes, nodes[v-1]);
			
			// DFS와 BFS 리스트를 반환 받을 변수입니다.
			List<Node> NavigationNodes;
			// DFS가 실행되기 전 인접 노드가 여러개 있을 때 작은 노드 부터 들어가야 하므로 내림차순으로 해주었습니다.
			// 내림차순으로 한 이유는 DFS는 스택을 이용하는데, 스택은 후입선출이기 때문에 마지막에 들어간 제일 작은 숫자가 제일 먼저 나오기 때문입니다. 
			for(Node node : nodes)
				Collections.sort(node.adjacentNodes,(a,b)->b.nodeNum-a.nodeNum);
			NavigationNodes = DFS(nodes,v);
			
			// DFS 출력(재귀함수를 사용할 땐, NavigationNodes를 recusionNodes로 바꿔주어야 합니다.)
			for(Node node : NavigationNodes) {
				bw.write(Integer.toString(node.nodeNum) + " ");
			}
			bw.newLine();
			
			// BFS의 큐는 선입 선출이기 때문에 오름차순으로 인접노드들을 정렬해주었습니다.
			for(Node node : nodes)
				Collections.sort(node.adjacentNodes,(a,b)->a.nodeNum-b.nodeNum);
			NavigationNodes = BFS(nodes,v);
			
			// BFS 출력
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


