package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class d2579 {
	// ����� ������ ������ �迭 ����
	static int stairs[];
	// n��ܱ��� ���� �� �ִ� ����� ���� �� �ִ� ���� ������ �迭 ����
	static Integer memo[];
	
	// maxScore(n)�� n��ܱ��� ���� �� �ִ� ����� ���� �� �ִ� ���� ��ȯ���ִ� �޼��� �Դϴ�.
	public static int maxScore(int num) {
		// ã�� ������ ������ ǥ�� �մϴ�. (n-2�� ��� + n) , (n-3�� ��� + n-1 + n)���� n�� ����ǹǷ� ������ ���ְ�
		// (n-2�� ���) , (n-3�� ��� + n-1) ��, maxScore(n-2), maxScore(n-3) + stairs[n-1]�� ǥ���� �� �ֽ��ϴ�.
		if(memo[num] == null) 
			memo[num] = Math.max(maxScore(num-3) + stairs[num-1], maxScore(num-2)) + stairs[num];
		
		return memo[num];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			stairs = new int[n+1];
			memo = new Integer[n+1];
			
			for (int i = 1; i <= n; i++) {
				stairs[i] = Integer.parseInt(br.readLine().trim());
			}
			
			// ���� ���� ������ �� �ִ� �ʱ��� ������ �־��ְ� ���� �մϴ�.
			memo[0] = stairs[0];
			memo[1] = stairs[1];
			// n�� 1�� ���� ���� �ֱ� ������ ������ ���� 2�� ���� �־��ݴϴ�.
			if(n >= 2)
				memo[2] = stairs[1] + stairs[2];
			
			int result = maxScore(n);
			
			bw.write(Integer.toString(result));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
