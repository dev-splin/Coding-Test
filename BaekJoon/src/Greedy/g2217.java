package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class g2217 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			Integer ropes[] = new Integer[n];
			
			// 로프가 버틸 수 있는 중량을 입력받습니다.
			for (int i = 0; i < n; i++) {
				ropes[i] = Integer.parseInt(br.readLine().trim());
			}
			
			// 오름차순으로 정렬 후
			Arrays.sort(ropes);
			
			int maxWeight = 0;
			// 각 로프에 고르게 중량이 걸리게 되므로 (물건의 중량/로프의 개수)가 최소로프무게 이하여야 합니다.
			// 오름차순으로 된 배열에서 현재로프의 무게 * 현재위치에 ~ 최대로프(n - i) 까지의 숫자를 곱해서 최대 무게를 구합니다.
			// ex) 로프의 무게가 30,60,90 일 때, 30*3, 60*2, 90*1 중에 제일 최대의 무게는 60*2 입니다.
			for (int i = 0; i < ropes.length; i++) {
				int sum = ropes[i] * (ropes.length - i);
				if(maxWeight < sum)
					maxWeight = sum;
			}	
			
			bw.write(Integer.toString(maxWeight));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
