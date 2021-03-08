package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1089 {
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
			
			int a = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			
			// ��� ���� ���� ���� �־��ݴϴ�. �� ��� ���� ������ �Ұ̴ϴ�.
			int result = a;
			
			// �� ��° ���� üũ���ִ� �����Դϴ�.
			int i = 1;
			
			while(n != i)
			{
				// ó�� ���۰��� result�� �־� �־��� ������ 2�� ° ���� �����մϴ�.
				++i;
				result += d;
			}
			
			bw.write(Integer.toString(result));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

