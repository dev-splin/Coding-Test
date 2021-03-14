package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class g2217 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			Integer ropes[] = new Integer[n];
			
			// ������ ��ƿ �� �ִ� �߷��� �Է¹޽��ϴ�.
			for (int i = 0; i < n; i++) {
				ropes[i] = Integer.parseInt(br.readLine().trim());
			}
			
			// ������������ ���� ��
			Arrays.sort(ropes);
			
			int maxWeight = 0;
			// �� ������ ���� �߷��� �ɸ��� �ǹǷ� (������ �߷�/������ ����)�� �ּҷ������� ���Ͽ��� �մϴ�.
			// ������������ �� �迭���� ��������� ���� * ������ġ�� ~ �ִ����(n - i) ������ ���ڸ� ���ؼ� �ִ� ���Ը� ���մϴ�.
			// ex) ������ ���԰� 30,60,90 �� ��, 30*3, 60*2, 90*1 �߿� ���� �ִ��� ���Դ� 60*2 �Դϴ�.
			for (int i = 0; i < ropes.length; i++) {
				int sum = ropes[i] * (ropes.length - i);
				if(maxWeight < sum)
					maxWeight = sum;
			}	
			
			bw.write(Integer.toString(maxWeight));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
