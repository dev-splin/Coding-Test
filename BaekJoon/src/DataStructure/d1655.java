package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class d1655 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> minPq = new PriorityQueue<>();
			PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b)->b-a);
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(br.readLine());
				
				// �� ���� ť�� ũ�Ⱑ ������ maxPq��, �ƴϸ� minPq�� ���� ������ �ֽ��ϴ�.
				if(minPq.size() == maxPq.size())
					maxPq.add(num);
				else
					minPq.add(num);
				
				// �� ó�� minPq�� ��� �ֱ� ������ ����ִ��� üũ
				if(!minPq.isEmpty()) {
					// maxPq�� Head���� minPq�� Head������ �۾ƾ� �ϱ� ������
					// maxPq�� Head���� �� ũ�ٸ� ���� �ٲ��ݴϴ�.
					if(maxPq.peek() > minPq.peek()) {
						int bigNum = maxPq.poll();
						int smallNum = minPq.poll();
						
						maxPq.add(smallNum);
						minPq.add(bigNum);
					}
				}
				
				sb.append(maxPq.peek()).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
