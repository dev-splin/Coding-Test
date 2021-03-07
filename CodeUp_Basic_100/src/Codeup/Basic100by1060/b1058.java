package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1058 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String strNums = br.readLine();
			StringTokenizer stk = new StringTokenizer(strNums);
			List<Boolean> nums = new ArrayList<Boolean>();
			
			while(stk.hasMoreTokens())
			{
				int intNum = Integer.parseInt(stk.nextToken());
				
				if (intNum != 1 && intNum!= 0)
					return;
				
				boolean num = intNum != 0;
				// java�� boolean�� true�� �Է����� ������ ���� false�� �޾� ���̴� �� �����ϴ�.
				// �׷��� ������ ���ڿ����� boolean���� �ٷ� ��ȯ���� �ʰ� ���������� ��ȯ �� (1 != 0)�� ��� true false�� �̿��� boolean�� ���� �ֽ��ϴ�.
				nums.add(num);
			}
				
			int result;
			if (!nums.get(0) && !nums.get(1))
				result = 1;
			else
				result = 0;
			
			bw.write(Integer.toString(result));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
