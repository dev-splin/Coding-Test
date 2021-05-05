package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c2_2108 {
	public static class Rank{
		int num;
		int count;
		
		public Rank() {
		}
		
		public Rank(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}
		
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int inputNums[] = new int[n];
			Map<Integer ,Rank> nums = new HashMap<>();
			int result[] = new int[4];
			
			int max = -4000;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				inputNums[i] = Integer.parseInt(br.readLine());
				
				if(!nums.containsKey(inputNums[i]))
					nums.put(inputNums[i], new Rank(inputNums[i], 1));
				else
					++nums.get(inputNums[i]).count;
				
				sum += inputNums[i];
				if(inputNums[i] > max)
					max = inputNums[i];
				
				if(inputNums[i] < min)
					min = inputNums[i];
			}
			
			result[0] = Math.round((float)sum / (float)n);
			result[3] = max - min;
			
			Arrays.sort(inputNums);
			result[1] = inputNums[n/2];
			
			List<Rank> list = new ArrayList<>(nums.values());
			
			Collections.sort(list, (a,b) -> {
				if(a.count == b.count)
					return a.num - b.num;
				return b.count - a.count;
				});
			
			if(list.size() > 1 &&
					list.get(0).count == list.get(1).count)
				result[2] = list.get(1).num;
			else
				result[2] = list.get(0).num;
			
			for(int num : result)
				System.out.println(num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
