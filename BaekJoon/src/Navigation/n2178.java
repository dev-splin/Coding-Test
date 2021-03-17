package Navigation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class n2178 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
	// ���������, ������ ������ üũ�ϴ� ����, ������� ����Ʈ�� ������ �ִ� ��� Ŭ����
	public static class Node {
		boolean checkRoad;
		int row;
		int col;
		List<Node> adjacentNodes;
		
		public Node(int row, int col, boolean checkRoad) {
			adjacentNodes = new ArrayList<>();
			this.row = row;
			this.col = col;
			this.checkRoad = checkRoad;
		}
		
		public void add(Node node) {
			adjacentNodes.add(node);
		}
	}
	
	// �̷θ� ������ָ鼭 ��� Ŭ���� ������� ����Ʈ�� ��带 �־��ݴϴ�.
	public static Node[][] MakeMaze(int n, int m) throws Exception {
		Node maze[][] = new Node[n][m];
		
		for (int i = 0; i < maze.length; i++) {
			char wallsOrRoads[] = br.readLine().trim().toCharArray();  
			
			for (int j = 0; j < wallsOrRoads.length; j++) {
				boolean checkRoad = false;
				if(wallsOrRoads[j] == '1')
					checkRoad = true;
					
				maze[i][j] = new Node(i, j, checkRoad);
				
				// i ��, ���� 0�� �ƴϸ� ���� �࿭ ���� �ִ� �� ��带 ������忡 �����մϴ�.
				// ������ ������ ������ ��������Ʈ�� ���� �߰��� �ֱ� �����Դϴ�. 
				if(i != 0)
					if(maze[i-1][j].checkRoad && maze[i][j].checkRoad) {
						maze[i-1][j].add(maze[i][j]);
						maze[i][j].add(maze[i-1][j]);
					}
				
				// j ��, ���� 0�� �ƴϸ� ���� �࿭ ���ʿ� �ִ� �� ��带 ������忡 �����մϴ�.
				if(j != 0)
					if(maze[i][j-1].checkRoad && maze[i][j].checkRoad) {
						maze[i][j-1].add(maze[i][j]);
						maze[i][j].add(maze[i][j-1]);
					}
			}
		}
		return maze;
	}
	
	// NodeŬ�����ȿ� ��������Ʈ�� �̿��� BFS�Դϴ�. int���� ��ȯ�ϴµ�, �� �� ���� ���� depth�� �ǹ��մϴ�.
	public static int BFS(Node startNode,Node findNode,int n, int m) {
		boolean checkNodes[][] = new boolean[n][m];
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(startNode);
		checkNodes[startNode.row][startNode.col] = true;	
		Node checkNode; 
		
		// depth�� üũ�ϱ� ���� ���� ó���� startNode�� ���� ������ 1�ν����մϴ�.
		int depth = 1;
		// �� �������� üũ���� ���� ����� �� �Դϴ�.
		int countNodesInLevel = 1;
		// ���� ������ ���������� ��� ���� �����մϴ�.
		int countAdjacentNodes = 0;
		
		while(!queue.isEmpty()) {
			checkNode = queue.poll();	
			// ť���� �ϳ��� ���鼭 üũ�� ���̱� ������ --�� ���ݴϴ�.
			--countNodesInLevel;
					
			if(checkNode == findNode) {
				break;
			}

			// üũ����� ���������� ��ȸ�ϸ鼭 üũ���� ���� ������ ť�� �־��ְ� üũ���ݴϴ�.
			// �� ��, ť�� �ִ� ���� countAdjacentNodes���� ++ ���ݴϴ�.
			// �̷��� ���ִ� ������ Ư�� ������ ���� ������ ���� �����ֱ� �����Դϴ�.
			for(Node node : checkNode.adjacentNodes) {
				if(!checkNodes[node.row][node.col]) {
					queue.add(node);
					checkNodes[node.row][node.col] = true;
					++countAdjacentNodes;
				}
			}
			
			// countNodesInLevel�� 0�� �� ��, �� ���� ������ �� üũ�Ͽ����� ���������� ��� ���� �־��ְ�
			// ���� ������ ������ 0���� �ٽ� �ʱ�ȭ�ϰ� depth�� 1�÷��ݴϴ�.
			if(countNodesInLevel == 0) {
				countNodesInLevel = countAdjacentNodes;
				countAdjacentNodes = 0;
				++depth;
			}
		}
		return depth;
	}
	
	public static void main(String[] args) {
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String mazeSize = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(mazeSize);
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			Node maze[][] = MakeMaze(n, m);
			
			int result = BFS(maze[0][0],maze[n-1][m-1], n, m);
			
			bw.write(Integer.toString(result));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
