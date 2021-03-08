package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class b1095 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			// �⼮ ��ȣ�� �θ� Ƚ��
			int n = Integer.parseInt(br.readLine().trim());
			
			String nums = br.readLine().trim();
			
			StringTokenizer stk = new StringTokenizer(nums);
			
			// �������� �θ� ��ȣ�� ������ ó�� �Է��� �θ� Ƚ���� ���� ������ ���α׷� ����
			if(stk.countTokens() != n)
				return;
			
			// �ҷȴ� ���ڸ� ������ ����Ʈ
			List<Integer> calledNum = new ArrayList<>(); 
			
			// ��ū�� �����ͼ� int������ ��ȯ�� list�� �����մϴ�.
			while(stk.hasMoreTokens())
			{
				int num = Integer.parseInt(stk.nextToken());
				
				calledNum.add(num);
			}
			
			// �ϴ� �ּ� ���ڴ� ���� ó�� ����� 0�� �ε����� ���� �־�����ϴ�.
			int minNum = calledNum.get(0);

			// �ּ� ���ڿ� list�� ��� ���ڿ� ���Ͽ� ���� ���� ���ڸ� ã���ϴ�.
			for(int num : calledNum)
				if(minNum > num)
					minNum = num;

			bw.write(Integer.toString(minNum));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

