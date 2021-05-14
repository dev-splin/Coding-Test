package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class c4_15663 {
	static int n;
	static int m;
	static int arr[];
	static boolean visit[];
	static Set<String> check = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void DFS(int depth, String result) {
		if(m == depth && !check.contains(result)) {
			check.add(result);
			sb.append(result).append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(visit[i])
				continue;
			
			visit[i] = true;
			DFS(depth+1, result + arr[i] + " ");
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			arr = new int[n];
			visit = new boolean[n];
			
			stk = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(stk.nextToken());
			
			Arrays.sort(arr);
			
			DFS(0,"");
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
