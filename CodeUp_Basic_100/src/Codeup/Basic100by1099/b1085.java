package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1085 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(nums);
			
			// 4���� ���� �� �Էµ��� �ʾ����� ���α׷��� �����մϴ�.
			if(stk.countTokens() != 4)
				return;
			
			// ���� ���� ����, �� ���� �ִ� ���� ������ ���� ���� Ŀ���� ������ long���� �־����ϴ�.
			long h,b,c,s = 0;
			
			// ������ 4���� ���� ������ �߱� ������ hasNextTokens()���� �����մϴ�.
			// �� ���� �´� ������ üũ�մϴ�.
			h = Long.parseLong(stk.nextToken());
			if(h > 48000)
				return;
			
			b = Long.parseLong(stk.nextToken());
			if(b > 32)
				return;
			
			c = Long.parseLong(stk.nextToken());
			if(c > 5)
				return;
	
			s = Long.parseLong(stk.nextToken());
			if(s > 6000)
				return;
			
			// ó�� ���� ������ bit�̱� ������ byte�� �ٲپ� �ݴϴ�.
			long bytes = (h * b * c * s) / 8;
			// 1024Byte == 1KB, 1024KB == 1MB �̱� ������ 1024*1024�� ������ �ݴϴ�.
			// �� ��, �Ǽ��� ���;� �ϱ� ������ ����ȯ�� ���ݴϴ�.
			double result = (double)bytes / (1024 * 1024);
			
			bw.write(String.format("%.1f MB", result));	
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

