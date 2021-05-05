package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class c2_18111 {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			int heightCount[] = new int[257];
			
			List<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < m; j++) {
					int land = Integer.parseInt(stk.nextToken());
					
					if(heightCount[land] == 0)
						list.add(land);
					
					++heightCount[land];
				}
			}
			
			Collections.sort(list,(val1, val2)-> val2 - val1);
			
			int max = list.get(0);
			int min = list.get(list.size()-1);
			int minTime = Integer.MAX_VALUE;
			int maxHeight = 0;
			
			for(int i = max ; i >= min; --i) {
				int time = 0;
				int inven = b;
				boolean isPossible = true;
				
				for(int cmpHeight : list) {
					if(cmpHeight == i)
						continue;
					
					int needcount = (i - cmpHeight) * heightCount[cmpHeight];
					if(needcount < 0) {
						inven += Math.abs(needcount);
						time += Math.abs(needcount) * 2;
					} else {
						if(inven >= needcount) {
							inven -= needcount;
							time += needcount;
						}
						else
							isPossible = false;
					}
				}
				
				if(isPossible) {
					if(time < minTime) {
						minTime = time;
						maxHeight = i;
					}
				}
			}
			
			System.out.println(minTime + " " + maxHeight);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
