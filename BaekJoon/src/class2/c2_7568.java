package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c2_7568 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int n = Integer.parseInt(br.readLine());
			
			int size[][] = new int[n][2];
			int ranks[] = new int[n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				size[i][0] = Integer.parseInt(stk.nextToken());
				size[i][1] = Integer.parseInt(stk.nextToken());
				
				ranks[i] = 1;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(i == j)
						continue;
					
					if(size[i][0] < size[j][0] &&
							size[i][1] < size[j][1])
						++ranks[i];
				}
			}
			
			for(int rank : ranks)
				System.out.print(rank + " ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
