package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;



public class g11399 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			// ������ ����� ���α׷� ����
			if(1 > n || 1000 < n)
				return;
			
			// ���ڿ��� �Է¹ް�
			String times = br.readLine().trim();
			// ���� ������ ���ڿ��� ��ū���� �ɰ� ��
			StringTokenizer stk = new StringTokenizer(times);
			
			// ��ū�� ������ �Էµ� ������ ���� ������ ���α׷� ����
			if(stk.countTokens() != n)
				return;
			
			// �Է¹��� ���� ������ ����Ʈ
			List<Integer> list = new ArrayList<>();
			
			// ��ū�� �ִ� �� üũ�ϰ� ������ ������ ��ȯ �� ���� üũ�� ���ְ� list�� �߰��մϴ�.
			while(stk.hasMoreTokens())
			{
				int time = Integer.parseInt(stk.nextToken());
				if(time < 1 || time > 1000)
					return;
				list.add(time);				
			}
			
			// list �����մϴ� ( �⺻ ��������)
			Collections.sort(list);
			
			// �ּ� �ð��� ���� ������ ����
			int sum = 0;
			// ���� ����� �ð��� ������ ����
			int preNum = 0;
			
			// list�� ��ȸ�Ͽ� preNum�� ���� �ð��� ���� �� �� ���� ���� sum�� ���� �� �ð��� �����ݴϴ�.
			for(int time : list)
			{
				preNum += time;
				sum += preNum;
			}
			
			// ���
			bw.write(Integer.toString(sum));
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
