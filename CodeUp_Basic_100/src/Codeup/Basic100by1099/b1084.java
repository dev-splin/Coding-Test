package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1084 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine().trim();
			
			//rgb���� ���� int �迭
			int rgb[] = new int[3];
			
			StringTokenizer stk = new StringTokenizer(nums);
			
			// r,g,b 3���� ���� �޾ƾ� �ϹǷ� ���� ���ڿ��� 3���� �ȵǸ� ���α׷��� �����մϴ�.
			if (stk.countTokens() != 3)
				return;
			
			// ���� 3���� ������ �����Ƿ� hasNextTokens()�� üũ���� �ʰ� �ٷ� �־��ݴϴ�.
			rgb[0] = Integer.parseInt(stk.nextToken());
			rgb[1] = Integer.parseInt(stk.nextToken());
			rgb[2] = Integer.parseInt(stk.nextToken());
			
			for (int i = 0; i < rgb[0]; ++i) {
				for (int j = 0; j < rgb[1]; ++j) {
					for (int k = 0; k < rgb[2]; ++k) {
						bw.write(Integer.toString(i) + " ");
						bw.write(Integer.toString(j) + " ");
						bw.write(Integer.toString(k));
						bw.newLine();
					}
				}
			}
			// rgb ����� �� ����
			int count = rgb[0] * rgb[1]  * rgb[2];
			
			bw.write(Integer.toString(count));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
