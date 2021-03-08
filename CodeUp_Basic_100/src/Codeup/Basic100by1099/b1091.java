package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1091 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine().trim();
			
			StringTokenizer stk = new StringTokenizer(nums);
			
			if(stk.countTokens() != 4)
				return;
			
			long a = Long.parseLong(stk.nextToken());
			if(a < -50 || a > 50)
				return;
			
			long m = Long.parseLong(stk.nextToken());
			if(m < -50 || m > 50)
				return;
			
			long d = Long.parseLong(stk.nextToken());
			if(d < -50 || d > 50)
				return;
			
			long n = Long.parseLong(stk.nextToken());
			if(n < 1 || n > 10)
				return;
			
			// ��� ���� ���� ���� �־��ݴϴ�. �� ��� ���� ������ �Ұ̴ϴ�.
			long result = a;
			
			// �� ��° ���� üũ���ִ� �����Դϴ�.
			long i = 1;
			
			while(n != i)
			{
				// ó�� ���۰��� result�� �־� �־��� ������ 2�� ° ���� �����մϴ�.
				++i;
				result = result * m + d;
			}
			
			bw.write(Long.toString(result));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

