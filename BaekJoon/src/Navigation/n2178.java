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
	
	// 행과열정보, 길인지 벽인지 체크하는 변수, 인접노드 리스트를 가지고 있는 노드 클래스
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
	
	// 미로를 만들어주면서 노드 클래스 인접노드 리스트에 노드를 넣어줍니다.
	public static Node[][] MakeMaze(int n, int m) throws Exception {
		Node maze[][] = new Node[n][m];
		
		for (int i = 0; i < maze.length; i++) {
			char wallsOrRoads[] = br.readLine().trim().toCharArray();  
			
			for (int j = 0; j < wallsOrRoads.length; j++) {
				boolean checkRoad = false;
				if(wallsOrRoads[j] == '1')
					checkRoad = true;
					
				maze[i][j] = new Node(i, j, checkRoad);
				
				// i 즉, 행이 0이 아니면 현재 행열 위에 있는 길 노드를 인접노드에 저장합니다.
				// 위에만 저장한 이유는 인접리스트에 서로 추가해 주기 때문입니다. 
				if(i != 0)
					if(maze[i-1][j].checkRoad && maze[i][j].checkRoad) {
						maze[i-1][j].add(maze[i][j]);
						maze[i][j].add(maze[i-1][j]);
					}
				
				// j 즉, 열이 0이 아니면 현재 행열 왼쪽에 있는 길 노드를 인접노드에 저장합니다.
				if(j != 0)
					if(maze[i][j-1].checkRoad && maze[i][j].checkRoad) {
						maze[i][j-1].add(maze[i][j]);
						maze[i][j].add(maze[i][j-1]);
					}
			}
		}
		return maze;
	}
	
	// Node클래스안에 인접리스트를 이용한 BFS입니다. int형을 반환하는데, 이 때 리턴 값은 depth를 의미합니다.
	public static int BFS(Node startNode,Node findNode,int n, int m) {
		boolean checkNodes[][] = new boolean[n][m];
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(startNode);
		checkNodes[startNode.row][startNode.col] = true;	
		Node checkNode; 
		
		// depth를 체크하기 위한 변수 처음에 startNode가 들어갔기 때문에 1로시작합니다.
		int depth = 1;
		// 한 레벨에서 체크하지 않은 노드의 수 입니다.
		int countNodesInLevel = 1;
		// 현재 레벨의 다음레벨의 노드 수를 저장합니다.
		int countAdjacentNodes = 0;
		
		while(!queue.isEmpty()) {
			checkNode = queue.poll();	
			// 큐에서 하나를 빼면서 체크할 것이기 때문에 --를 해줍니다.
			--countNodesInLevel;
					
			if(checkNode == findNode) {
				break;
			}

			// 체크노드의 인접노드들을 순회하면서 체크되지 않은 노드들은 큐에 넣어주고 체크해줍니다.
			// 이 때, 큐에 넣는 순간 countAdjacentNodes값을 ++ 해줍니다.
			// 이렇게 해주는 이유는 특정 레벨의 다음 레벨의 수를 구해주기 위함입니다.
			for(Node node : checkNode.adjacentNodes) {
				if(!checkNodes[node.row][node.col]) {
					queue.add(node);
					checkNodes[node.row][node.col] = true;
					++countAdjacentNodes;
				}
			}
			
			// countNodesInLevel이 0이 될 때, 즉 현재 레벨을 다 체크하였으면 다음레벨의 노드 수를 넣어주고
			// 다음 레벨의 노드수는 0으로 다시 초기화하고 depth를 1올려줍니다.
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
