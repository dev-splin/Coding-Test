package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class b1072 {
		
	static OutputStreamWriter osw = new OutputStreamWriter(System.out);
	static BufferedWriter bw = new BufferedWriter(osw);
	static StringTokenizer stk;
	// ��𼭳� ����� �� �ְ� static���� �־����ϴ�.
	
	// �Է��� ���� ������,�Է¹��� ���ڸ� ���ڷ� �ް� �Է¹��� ���ڸ� �ɰ� ������ �Է��� ���������� üũ�� �ְ� ������ִ� �Լ� 
	public static void printNum(int count, String nums) throws Exception {
		stk = new StringTokenizer(nums);
		
		if (stk.countTokens() > count)	//�Է��� ���ڰ� count���� ������ �Լ��� �����մϴ�. 
			return;
		
		while(stk.hasMoreTokens())	// ����ϴ� �κ�
		{
			int num = Integer.parseInt(stk.nextToken());
			bw.write(Integer.toString(num));
			bw.newLine();
		}
	}
	
	public static void main(String[] args) {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int count = Integer.parseInt(br.readLine().trim());
			// Ȥ�� �� ������ ���� ���ָ鼭 ������ �Է� �޽��ϴ�.
			String nums = br.readLine();
			
			printNum(count, nums);				
							
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


