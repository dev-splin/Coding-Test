package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class c4_1043_2 {
	static int n;
	static int parent[];
	static List<Integer> knows;
		
	public static void union(int a, int b) {
		int num1 = find(a);
		int num2 = find(b);
		if(num1 != num2)
			parent[num2] = num1;
	}
	
	public static int find(int a) {
		if(parent[a] == a)
			return parent[a];
		else
			return parent[a] = find(parent[a]);
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			parent = new int[51];
			List<Integer> list[] = new ArrayList[m];
			
			for (int i = 0; i <= 50; i++) {
				parent[i] = i;
				if(i < m)
					list[i] = new ArrayList<>();
			}
			
			stk = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(stk.nextToken());
			
			knows = new ArrayList<>();
			
			for (int i = 0; i < k; i++) {
				int num = Integer.parseInt(stk.nextToken());
				knows.add(num);
			}
			
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				int count = Integer.parseInt(stk.nextToken());
				int prev = 0;
				
				if(count == 0)
					continue;
					
				for (int j = 0; j < count; j++) {
					int num = Integer.parseInt(stk.nextToken());
					if(prev != 0) 
						union(prev, num);
					
					prev = num;
					list[i].add(num);
				}
			}
			
			int ans = 0;
			for (int i = 0; i < m; i++) {
				boolean isPossible = true;
				
				for(Integer know : knows) {
					int knowNum = find(know);
					
					for(Integer num : list[i])
						
						if(knowNum == find(num)) {
							isPossible = false;
							break;
						}
				}
				
				if(isPossible)
					++ans;
			}
			
			System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
