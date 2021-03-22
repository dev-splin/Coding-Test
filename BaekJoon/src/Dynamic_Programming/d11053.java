package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d11053 {
	static int memo[];
	static int nums[];
	
	// n까지의 수열을 순회하여 n의 값보다 작고 count로 최댓값을 비교해 최댓값이 큰 값을 memo[n]에 담아줍니다.
	public static void dp(int n) {
		if(n == 0)
			return;
		if(n == 1)
			return;
		
		if(memo[n] == 0) {
			int count = 1;
			for (int i = 1; i < n; i++) {
				if(nums[i] < nums[n] && count < memo[i] + 1)
					count = memo[i] + 1;
			}
			memo[n] = count;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			memo = new int[n+1];
			nums = new int[n+1];
			
			String inputNums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(inputNums);
			
			memo[0] = 0;
			memo[1] = 1;
			
			// 첫 번째 수열 부터 입력하는 동시에 dp를 수행해 줍니다.
			for (int i = 1; i < nums.length; i++) {
				nums[i] = Integer.parseInt(stk.nextToken());
				dp(i);
			}
			
			// 최대값이 섞여 있기 때문에 오름차순 정렬 후 마지막에 있는 값을 출력합니다.
			Arrays.sort(memo);

			bw.write(Integer.toString(memo[n]));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
