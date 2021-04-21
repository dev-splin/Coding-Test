package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class c2_1966 {
	public static class Importance {
		int num;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(stk.nextToken());
				int m = Integer.parseInt(stk.nextToken());
				
				Importance findImportance = null;
				Queue<Importance> queue = new LinkedList<>();
				
				stk = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					Importance importance = new Importance();
					importance.num = Integer.parseInt(stk.nextToken());
					
					queue.add(importance);
					
					if(j == m)
						findImportance = importance;
				}
				
				int sequence = 0;
				while(true) {
					
					Importance importance = queue.poll();
					
					Importance importances[] = new Importance[queue.size()];
					queue.toArray(importances);
					
					boolean isPossible = true;
					for(Importance cmp : importances)
						if(cmp.num > importance.num) {
							isPossible = false;
							break;
						}
					
					if(isPossible) {
						++sequence;
						
						if(importance.equals(findImportance))
							break;	
					}
					else
						queue.add(importance);
					
										
				}
				System.out.println(sequence);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}