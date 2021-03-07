package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class b1053 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String strNums = br.readLine();
			
			int num = Integer.parseInt(strNums);
			
			if (num != 1 && num != 0)
				return;
			// �Էµ� ���ڰ� 1�̳� 0�� �ƴϸ� ����ǰ� �մϴ�.
			num = Math.abs(num - 1);
			// java������ %d�� �̿��� �������� '!'�� ����� �� �����ϴ�.
			// �׷��� ������ boolean���� ����ȯ �� '!' ����� ���� �ٽ� Integer�� ��ȯ �� ����ϴ� ����� �ִµ�
			// �� ����� �۾��� ���� �� �� ���� num���� 1�� ���� ������ �̿��� '!'�� ������ ���־����ϴ�.
			// ex) abs(1 - 1) = 0 / abs(0 - 1) = 1
			
			bw.write(Integer.toString(num));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
