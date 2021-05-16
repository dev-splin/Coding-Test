package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c4_5639 {
	static StringBuilder sb = new StringBuilder();
	
	public static class Node {
		int index;
		Node childs[];
		
		public Node(int index) {
			this.index = index;
			childs = new Node[2];
		}
	}
		
	public static void setTree(Node cur, int index) {
		int child;
		
		if(index < cur.index)
			child = 0;
		else 
			child = 1;
			
		if(cur.childs[child] == null)
			cur.childs[child] = new Node(index);
		else 
			setTree(cur.childs[child], index);
	}
	
	public static void post(Node cur) {
		if(cur == null)
			return;
		
		post(cur.childs[0]);
		post(cur.childs[1]);
		sb.append(cur.index).append("\n");
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int num = 0;
			String input = "";
			
			Node root = new Node(Integer.parseInt(br.readLine()));
			
			while((input = br.readLine()) != null) {
				num = Integer.parseInt(input);
				setTree(root ,num);
			}
			
			post(root);
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
