package Lowest_Common_Ancestor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class l11438 {
	final static int MAX_NODE = 100001;
	final static int MAX_LEVEL = 17;
	static int n;
	static int parent[][];
	static List<Integer> adjacentNodes[];
	static int level[];
	
	
	public static void DFS(int node, int depth) {
		
		level[node] = depth;
		
		for(int adjacent : adjacentNodes[node]) {
			
			if(level[adjacent] != 0)
				continue;
			
			parent[adjacent][0] = node;
			DFS(adjacent,depth+1);
		}
	}
	
	public static void make_tree() {
		
		DFS(1,1);
		
		for (int i = 1; i <= MAX_LEVEL; i++) 
			for (int j = 1; j <= n; j++) 
				parent[j][i] = parent[parent[j][i-1]][i-1];
	}
	
	public static int LCA(int nodeA, int nodeB) {
		
		if(level[nodeA] > level[nodeB]) {
			int tmp = nodeA;
			nodeA = nodeB;
			nodeB = tmp;
		}
		
		for (int i = MAX_LEVEL; i >= 0; --i) 
			if(level[nodeA] <= level[parent[nodeB][i]])
				nodeB = parent[nodeB][i];
		
		if(nodeA == nodeB)
			return nodeA;
		else {
			for (int i = MAX_LEVEL; i >= 0; --i)  {
				if(parent[nodeA][i] != parent[nodeB][i]) {
					nodeA = parent[nodeA][i];
					nodeB = parent[nodeB][i];
				}
			}
			return parent[nodeA][0];
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		StringBuilder sb = new StringBuilder();
		
		try {
			n = Integer.parseInt(br.readLine());
			
			parent = new int[n+1][MAX_LEVEL+1];
			adjacentNodes = new ArrayList[n+1];
			level = new int[n+1];
			
			for (int i = 1; i <= n; i++)
				adjacentNodes[i] = new ArrayList<>();
			
			for (int i = 1; i < n; i++) {
				String nums = br.readLine();
				StringTokenizer stk = new StringTokenizer(nums);
				
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				
				adjacentNodes[a].add(b);
				adjacentNodes[b].add(a);
			}
			make_tree();
			
			int m = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < m; i++) {
				String nums = br.readLine();
				StringTokenizer stk = new StringTokenizer(nums);
				
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				
				System.out.println(LCA(a,b));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
