package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1086 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(nums);
			
			// 3���� ���� �� �Էµ��� �ʾ����� ���α׷��� �����մϴ�.
			if(stk.countTokens() != 3)
				return;
			
			// ���� ���� ����, �� ���� �ִ� ���� ������ ���� ���� Ŀ���� ������ long���� �־����ϴ�.
			long w,h,b = 0;
			
			// ������ 3���� ���� ������ �߱� ������ hasNextTokens()���� �����մϴ�.
			// �� ���� �´� ������ üũ�մϴ�.
			w = Long.parseLong(stk.nextToken());
			if(w > 1024 || w < 1)
				return;
			
			h = Long.parseLong(stk.nextToken());
			if(h > 1024 || h < 1)
				return;
			
			b = Long.parseLong(stk.nextToken());
			if(b > 40 || b % 4 != 0)
				return;
	
			// ó�� ���� ������ bit�̱� ������ byte�� �ٲپ� �ݴϴ�.
			long bytes = (w * h * b) / 8;
			// 1024Byte == 1KB, 1024KB == 1MB �̱� ������ 1024*1024�� ������ �ݴϴ�.
			// �� ��, �Ǽ��� ���;� �ϱ� ������ ����ȯ�� ���ݴϴ�.
			double result = (double)bytes / (1024 * 1024);
			
			bw.write(String.format("%.2f MB", result));	
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

