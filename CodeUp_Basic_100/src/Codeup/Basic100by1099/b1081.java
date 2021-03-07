package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1081 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(nums);

			if(stk.countTokens() != 2)
				return;
			// �� ���� ���ڸ� �Է¹޾ƾ� �ϱ� ������ �������� ���ڰ� 2���� �ƴϸ� ���α׷��� �����մϴ�.
			
			int firstNum = Integer.parseInt(stk.nextToken());
			if (firstNum > 10)
				return;
			
			int secondNum = Integer.parseInt(stk.nextToken());
			if (secondNum > 10)
				return;
			// �������� ���ڰ� 2���� ��쿡�� ����ǰ� �����Ƿ� hasMoreTokens�� üũ���� �ʾƵ� �˴ϴ�.
			
			for (int i = 1; i <= firstNum; ++i) {
				for (int j = 1; j <= secondNum ; ++j) {
					bw.write(Integer.toString(i) + " " + Integer.toString(j));
					bw.newLine();
				}
			}
			// �� ���ڰ� ���յǴ� ����� ���� ������ݴϴ�.
			

			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
