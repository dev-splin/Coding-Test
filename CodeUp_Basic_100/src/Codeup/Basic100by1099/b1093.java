package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1093 {
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
			
			// 23���� �⼮��ȣ �迭�� ����ϴ�.
			int attendanceNum[] = new int[23];
		
			while(stk.hasMoreTokens())
			{
				int num = Integer.parseInt(stk.nextToken());
                // �Էµ� ���ڰ� �⼮��ȣ�� �ƴϸ� �Ѿ�ݴϴ�.
				if(num < 1 || num > 23)
					continue;
				
				// �Էµ� �� ù�� °�� 1 �̹Ƿ� -1�� ���ݴϴ�.
				++attendanceNum[num-1];
			}
			
			for (int i = 0; i < attendanceNum.length; ++i) {
				bw.write(Integer.toString(attendanceNum[i]) + " ");
				
			}
		
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

