package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4256 {
	static StringBuilder sb = new StringBuilder();
	
	public static void postorder(int pre[], int in[]) {
		int length = pre.length;
		
		if(length == 0)
			return;
		
		int root = pre[0];
		
		int left = 0;
		
		for (int i = 0; i < length; i++)
			if(in[i] == root) {
				left = i;
				break;
			}
		
		if(left != 0)
			postorder(slice(pre, 1, left), slice(in, 0, left-1));
		
		if(length - left -1 != 0)
			postorder(slice(pre, left+1, length-1), slice(in, left+1, length-1));
			
		sb.append(root).append(' ');
	}
	
	public static int[] slice(int arr[], int start, int end) {
		int result[] = new int[end-start+1];
		
		int index = 0;
		
		for (int i = start; i <= end; i++) {
			result[index] = arr[i];
			++index;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				
				int pre[] = new int[n];
				int in[] = new int[n];
				
				StringTokenizer preStk = new StringTokenizer(br.readLine());
				StringTokenizer inStk = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					pre[j] = Integer.parseInt(preStk.nextToken());
					in[j] = Integer.parseInt(inStk.nextToken());
				}
				
				postorder(pre, in);
				sb.append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
