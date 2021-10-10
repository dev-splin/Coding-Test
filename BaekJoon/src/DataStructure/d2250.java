package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class d2250 {
	public static int childs[][];
	public static TreeMap<Integer, int[]> map;
	public static int leftIndex = 0;
	public static int parents[];
	
	public static int findRoot() {
		int root = 0;
		
		for (int i = 1; i < parents.length; i++) {
			if(parents[i] == 0) {
				root = i;
				break;
			}
		}
		
		return root;
	}
	
	public static void setIndex(int node, int level) {
		int leftNode = childs[node][0];
		int rightNode = childs[node][1];
		
		if(leftNode != -1)
			setIndex(leftNode, level + 1);
		
		int index = ++leftIndex;
		
		int[] arr = map.getOrDefault(level, new int[2]);
		
		if(arr[0] == 0) {
			arr[0] = index;
			arr[1] = index;
		} else {
			arr[0] = Math.min(arr[0], index);
			arr[1] = Math.max(arr[1], index);
		}
		
		map.put(level, arr);
		
		if(rightNode != -1)
			setIndex(rightNode, level + 1);
	}
	
	public static int[] solve() {
		int result[] = new int[2];
		
		
		for(Integer key : map.keySet()) {
			int arr[] = map.get(key);
			int dist = arr[1] - arr[0] + 1;
			
			if(result[1] < dist) {
				result[0] = key;
				result[1] = dist;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			map = new TreeMap<>();
			childs = new int[n+1][2];
			parents = new int[n+1];
			
			for (int i = 1; i <= n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int root = Integer.parseInt(stk.nextToken());
				int left = Integer.parseInt(stk.nextToken());
				int right = Integer.parseInt(stk.nextToken());
				
				childs[root][0] = left;
				childs[root][1] = right;
				
				if(left != -1)
					parents[left] = root;
				
				if(right != -1)
					parents[right] = root;
			}
			
			int root = findRoot();
			setIndex(root, 1);
			int result[] = solve();
			
			System.out.println(result[0] + " " + result[1]);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
