package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1090 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine().trim();
			
			StringTokenizer stk = new StringTokenizer(nums);
			
			if(stk.countTokens() != 3)
				return;
			
			long a = Long.parseLong(stk.nextToken());
			if(a < 0 || a > 10)
				return;
			
			long r = Long.parseLong(stk.nextToken());
			if(r < 0 || r > 10)
				return;
			
			long n = Long.parseLong(stk.nextToken());
			if(n < 0 || n > 10)
				return;
			
			// ��� ���� ���� ���� �־��ݴϴ�. �� ��� ���� ������ �Ұ̴ϴ�.
			long result = a;
			
			// �� ��° ���� üũ���ִ� �����Դϴ�.
			long i = 1;
			
			while(n != i)
			{
				// ó�� ���۰��� result�� �־� �־��� ������ 2�� ° ���� �����մϴ�.
				++i;
				result *= r;
			}
			
			bw.write(Long.toString(result));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

