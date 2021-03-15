package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class g1339 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			// �ƽ�Ű �ڵ带 �̿��ؼ� ���ĺ� A~Z�� �ε������� �迭�� ����ϴ�.
			int alphabets[] = new int[26];

			// �ܾ� char�迭�� �Է¹ް� �ܾ��� ���̸�ŭ �ڸ���(digit)�� ����� �ְ�(abcd�� 10�� 3��)
			// �ش� ���ĺ���-65(�ƽ�Ű�ڵ�)�� �ؼ� �ش� �ε����� �ڸ����� ���մϴ�.
			// ���� ABC�� CDE�� �ִٰ� �ϸ� C(67 - 65)�� 2���ε����� 1 + 100�� �� �ֽ��ϴ�.
			for (int i = 0; i < n; i++) {
				char word[] = br.readLine().toUpperCase().trim().toCharArray();
				
				int digit = (int)Math.pow(10, word.length - 1);
				for (int j = 0; j < word.length; j++) {
					alphabets[word[j] - 65] += digit;
					
					digit /= 10;
				}
			}
			
			// ���ĺ����� ������������ ����
			Arrays.sort(alphabets);
			
			// �ش� ���ĺ��� num���� �ν��ϰ� �ϱ����� ����
			int num = 9;
			int sum = 0;
			
			// ���ĺ����� ������������ �����߱� ������ �Ųٷ� ��ȸ�ϸ鼭 ���� ū ���ڸ� ������ �ִ� ���ĺ� ����
			// 9~0������ �ο����ְ� ����� �����ݴϴ�. �� ��, 0�̸� ��ȸ�� �������ݴϴ�.(���ĺ��� ��G���� �ʾ����� 0�̱� ������)
			// c�� cdsq, dfsc, accd�� ���ǰ� ������ c�� �ش��ϴ� �ε����� ���� 1000 + 1 + 110 = 1111 �̵˴ϴ�.
			for (int i = alphabets.length -1 ; i >= 0; --i) {
				if(alphabets[i] == 0)
					break;
				
				sum += num * alphabets[i];
				--num;
			}
						
			bw.write(Integer.toString(sum));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
