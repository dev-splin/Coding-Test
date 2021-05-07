package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class c3_11724 {
	static int parent[];
	
	public static int getParent(int num) {
		if(parent[num] == num)
			return num;
		return parent[num] = getParent(parent[num]);
	}
	
	public static void setParent(int num1, int num2) {
		int a = getParent(num1);
		int b = getParent(num2);
		
		if(a > b)
			parent[a] = b;
		else
			parent[b] = a;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			parent = new int[n+1];
			
			for (int i = 1; i <= n; i++)
				parent[i] = i;
			
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(stk.nextToken());
				int num2 = Integer.parseInt(stk.nextToken());
				
				setParent(num1, num2);
			}
			
			Set<Integer> parentCheck = new HashSet<>();
			
			for (int i = 1; i <= n; i++) {
				int parentNum = getParent(parent[i]);
				if(!parentCheck.contains(parentNum))
					parentCheck.add(parentNum);
			}
			
			System.out.println(parentCheck.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
