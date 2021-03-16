package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class g4796 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			List<Integer> testCases = new ArrayList<>();
			
			while(true) {
				String testCase = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(testCase);
				
				// l,p,v�� ��ū���� ���� �� �޾ƿɴϴ�.
				int l = Integer.parseInt(stk.nextToken());
				int p = Integer.parseInt(stk.nextToken());
				int v = Integer.parseInt(stk.nextToken());
				
				// 0�� �ԷµǸ� ����
				if (l == 0 && p == 0 && v == 0)
					break;
				
				// �� ����� �� �ִ� ���� �����ϴ� ����
				int availableDays = (v / p) * l;
				// ���� ���� �����ϴ� ����
				int restDays = v % p;
				
				// ���� ���� ����� �� �ִ� ��(l)���� ������ �ٷ� �ѻ���� ���� ���ϰ� �ƴϸ� l�� ���մϴ�. 
				if(restDays < l)
					availableDays += restDays;
				else
					availableDays += l;

				testCases.add(availableDays);
			}
			
			// ���
			for (int i = 0; i < testCases.size(); i++) {
				bw.write("Case " + Integer.toString(i+1) + ": " + Integer.toString(testCases.get(i)));
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
