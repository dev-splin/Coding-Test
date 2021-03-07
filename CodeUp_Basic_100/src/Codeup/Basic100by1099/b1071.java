package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class b1071 {
	
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
	static OutputStreamWriter osw = new OutputStreamWriter(System.out);
	static BufferedWriter bw = new BufferedWriter(osw);
	// printNum() �Լ����� ����� �ϱ����� class�� �Ӽ����� �־����ϴ�.
	// static main���� ����� ������ �Լ����� static�� �ٿ��־�� �մϴ�.
	
	// StringTokenizer ��ü�� �޾� ���� �ִ��� Ȯ�� ��, ������ �ٲٰ� 0�� �ƴ� �� ������ְ� �ٽ� printNum()�Լ��� �θ��� ����Լ��Դϴ�. (0�� ���� �� ���� ���)
	public static void printNum(StringTokenizer stk) throws Exception {
		// BufferedReader�� Writer�� ����� �� �ݵ�� ����ó���� ���־�� �ϴµ� throws�� �̿��� �Լ��� ȣ���ϴ� ������ ����ó���� �ϰ� ���־����ϴ�.
		int num = 0;
		if(stk.hasMoreTokens())
			num = Integer.parseInt(stk.nextToken());

		if (num != 0)
		{
			bw.write(Integer.toString(num));
			bw.newLine();
			printNum(stk);
		}			
	}
	
	public static void main(String[] args) {
		
		
		try {
			String strnums = br.readLine();
			StringTokenizer stk = new StringTokenizer(strnums);
			// ���� �������� ����(default)�� �������� �������ݴϴ�.
			
			printNum(stk);				
							
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


