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
				
				// 두 개의 큐의 크기가 같으면 maxPq에, 아니면 minPq에 값을 번갈아 넣습니다.
				if(minPq.size() == maxPq.size())
					maxPq.add(num);
				else
					minPq.add(num);
				
				// 맨 처음 minPq는 비어 있기 때문에 비어있는지 체크
				if(!minPq.isEmpty()) {
					// maxPq의 Head값은 minPq의 Head값보다 작아야 하기 때문에
					// maxPq의 Head값이 더 크다면 서로 바꿔줍니다.
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
