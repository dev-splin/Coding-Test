package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class g11047 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			// ���� ���� ������ ������ �Է¹޽��ϴ�.
			String coinTypeCountAndPrice = br.readLine().trim();
			
			// ������ �������� ��ū���� �����ϴ�.
			StringTokenizer stk = new StringTokenizer(coinTypeCountAndPrice);
			
			// ���� ��ū ������ 2���� �ƴϸ� ���α׷� ����(2���� �Է����� ������ ����)
			if(stk.countTokens() != 2)
				return;
			
			// ��ū�� ������ ������ ����ϴ�.
			int coinTypeCount = Integer.parseInt(stk.nextToken());
			int price = Integer.parseInt(stk.nextToken());
			
			// ���� ���� ������ŭ �迭�� ����� �ݴϴ�.
			int coin[] = new int[coinTypeCount];
			
			// �迭�濡 �� �Է�
			for (int i = 0; i < coin.length; i++)
				coin[i] = Integer.parseInt(br.readLine().trim());
			
			// �迭���� ��ȸ�ϱ� ���� ����
			int i = coin.length - 1;
			// ������ �����ϴµ� �ʿ��� �� ���� ����
			int totalCoinCount = 0;
			
			// ������ 0���ϰ� �� �� ���� ������ ���ϴ�.
			// "����/��������" �� ���� ������ ���� ������ �Ǵ��ϰ� ���ݿ� ���ΰ���*���������� ���ݴϴ�.
			while(price > 0) {
				int quotient = price / coin[i];
				if(quotient != 0) {
					price -= (coin[i] * quotient);
					totalCoinCount += quotient;
				}
				--i;
			}
			
			bw.write(Integer.toString(totalCoinCount));
			bw.flush();
			bw.close();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
