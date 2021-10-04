package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class d20924 {
	static HashMap<Integer, ArrayList<Edge>> map;
	static int giga = 0;
	static int pillar = 0;
	static int startParent = 0;
	static boolean isFindPillar = false;
	static int branch = 0;
	
	public static class Edge {
		int dst;
		int length;
		
		public Edge(int dst, int length) {
			this.dst = dst;
			this.length = length;
		}
	}
	
	public static void findPillar(int node, int parent, int depth, int sum) {
		
		if((depth == 0 && map.get(node).size() != 1) ||
				(depth != 0 && (map.get(node).size() > 2 || map.get(node).size() == 1))) {
			pillar = sum;
			giga = node;
			startParent = parent;
			isFindPillar = true;
			return;
		}
		
		for(Edge edge : map.get(node)) {
			
			if(edge.dst == parent)
				continue;
			
			findPillar(edge.dst, node, depth + 1, sum + edge.length);
			if(isFindPillar)
				return;
		}
	}
	
	public static void findBranch(int node, int parent, int sum) {
		branch = Math.max(branch, sum);
		
		for(Edge edge : map.get(node)) {
			if(edge.dst == parent)
				continue;
			
			findBranch(edge.dst, node, sum + edge.length);
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			
			map = new HashMap<>();
			
			for (int i = 1; i <= n; i++)
				map.put(i, new ArrayList<>());
			
			for (int i = 0; i < n - 1; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				int length = Integer.parseInt(stk.nextToken());
				
				map.get(a).add(new Edge(b, length));
				map.get(b).add(new Edge(a, length));
			}
			
			findPillar(r, r, 0, 0);
			findBranch(giga, startParent, 0);
			
			System.out.println("" + pillar + " " + branch);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
