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
	
	// n������ ������ ��ȸ�Ͽ� n�� ������ �۰� count�� �ִ��� ���� �ִ��� ū ���� memo[n]�� ����ݴϴ�.
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
			
			// ù ��° ���� ���� �Է��ϴ� ���ÿ� dp�� ������ �ݴϴ�.
			for (int i = 1; i < nums.length; i++) {
				nums[i] = Integer.parseInt(stk.nextToken());
				dp(i);
			}
			
			// �ִ밪�� ���� �ֱ� ������ �������� ���� �� �������� �ִ� ���� ����մϴ�.
			Arrays.sort(memo);

			bw.write(Integer.toString(memo[n]));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
