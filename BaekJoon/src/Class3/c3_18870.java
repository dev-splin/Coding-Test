package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class c3_18870 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int arr[] = new int[n];
			int ans[] = new int[n];
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
				ans[i] = arr[i];
			}
			
			Arrays.sort(arr);
			
			Map<Integer, Integer> map = new HashMap<>();
			
			int count = 0;
			
			for (int i = 0; i < n; i++) {
				if(!map.containsKey(arr[i])) {
					map.put(arr[i], count);
					++count;
				}
			}
			
			for (int i = 0; i < n; i++)
				sb.append(map.get(ans[i])).append(' ');
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}