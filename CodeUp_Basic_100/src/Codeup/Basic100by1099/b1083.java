package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1083 {
	
	// ���ڸ� �޾Ƽ� �� ���ڿ� 3,6,9(�ڼ��� ĥ ����)�� ��� ��� ������ ã���ִ� �Լ��Դϴ�. 
	public static int clapNum(int num) {
		// �� ���� �ڼ��� ������ �� ������ �����Դϴ�.
		int clapNum = 0;
	
		// num�� 0�� �� ���� �ݺ��մϴ�.
		while(num != 0)
		{
			// 10�� ������ ������ �̿��� 1�� �ڸ����� 3,6,9���� Ȯ���մϴ�. 
			if(num % 10 == 3 ||
					num % 10 == 6 ||
					 num % 10 == 9) {
					++clapNum;				
			}
			
			// ������ ���ڸ� 10�� �����־ �� �ڸ��� ���Դϴ�.
			// ex) 3456/10=345, 345/10=34, 34/10= 3
			num /= 10;
		}
				
		return clapNum;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int num = Integer.parseInt(br.readLine().trim());
			// ���ڰ� 1~9 �������� ����� ���α׷��� �����մϴ�.
			if(num < 1 || num > 9)
				return;
			
			for (int i = 1; i <= num; ++i) {
				// �ڼ��� ������ ���ϴ� �Լ��� �̿��� �ڼ��� ������ ���մϴ�.
				int clapNum = clapNum(i);
				
				// �ڼ��� ������ 0�̸� �׳� ���ڸ� ������ְ� 0�� �ƴϸ� �ڼ��� ������ŭ X�� ������ݴϴ�.
				if (clapNum == 0)
					bw.write(Integer.toString(i));
				else {
					for (int j = 1; j <= clapNum; ++j) {
						bw.write('X');
					}
				}
				bw.write(" ");
			}	
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
