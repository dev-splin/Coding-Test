package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class g1541 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String equation = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(equation,"+-",true);
			
			List<Integer> nums = new ArrayList<>();
			List<Character> signs = new ArrayList<>();
			
			// '+'�� '-'�� ���� ��ū�� ��ȸ�Ͽ� ��ū�� Object��ü�� �ް�
			// try catch�� �̿��� int������ ����ȯ�� �����ϸ� int�� �ٲٰ� �ƴϸ� char������ �ٲߴϴ�. 
			while(stk.hasMoreElements()) {
				Object numOrSign = stk.nextElement();
				try {
					int num = Integer.parseInt((String)numOrSign);
					nums.add(num);
				} catch (NumberFormatException e) {
					char sign = numOrSign.toString().charAt(0);
					signs.add(sign);
				}
			}
			
			int tempsum = 0;
			int sum = nums.get(0);
			boolean meetMinus = false;
			
			// ������ ���ڸ���Ʈ�� ��ȸ�ϸ� '-'�� ������ �������� ���� �� �հ迡 �����ְ�
			// -�� �������� ���� �ӽ��հ迡 �� �����ش��� "���հ� - �ӽ��հ�"�� �մϴ�.
			for (int i = 1; i < nums.size(); i++) {
				if(signs.get(i-1) == '-')
					meetMinus = true;
				
				if(meetMinus)
					tempsum += nums.get(i);
				else 
					sum += nums.get(i);
			}
			sum -= tempsum;
			
			bw.write(Integer.toString(sum));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
