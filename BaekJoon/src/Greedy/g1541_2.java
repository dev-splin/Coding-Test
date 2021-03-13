package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class g1541_2 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String equation = br.readLine().trim();
			StringTokenizer minusStk = new StringTokenizer(equation,"-");
			
			int sum = 0;
			boolean firstToken = true;
			
			// '-'�� �������� ���� ��ū�� ��ȸ�鼭 ���� ��ū�� '+' �� �� ������ '+'�� ���� ��ū���� �ӽ��հ迡 �����ݴϴ�.
			// '-'�� �������� ��, ù�� ° ��ū�̸� "�� �հ� += �ӽ��հ�", �ٸ� ��ū�̸� "�� �հ� -= �ӽ��հ�". ��, "ù ��° ��ū - ������ ��ū"�� �˴ϴ�. 
			while(minusStk.hasMoreTokens()) {
				int tempsum = 0;
				StringTokenizer plusStk1 = new StringTokenizer(minusStk.nextToken(),"+");
				
				while(plusStk1.hasMoreTokens()) {
					int num = Integer.parseInt(plusStk1.nextToken());
					
					tempsum += num;
				}
				
				if(firstToken) {
					sum += tempsum;
					firstToken = false;
				}
				else
					sum -= tempsum;
			}
			
			bw.write(Integer.toString(sum));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
