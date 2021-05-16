package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c4_5639_2 {
	static int arr[] = new int[10001];
	static StringBuilder sb = new StringBuilder();
	
	public static void post(int cur, int end) {
		if(cur > end)
			return;
		
		int mid = cur + 1;
		while(mid <= end && arr[mid] < arr[cur])
			++mid;
		
		post(cur + 1, mid - 1);
		post(mid, end);
		sb.append(arr[cur]).append("\n");
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int num = 0;
			
			String input = "";
			
			int index = 0;
			while((input = br.readLine()) != null)
				arr[index++] = Integer.parseInt(input);
			
			post(0,index-1);
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
