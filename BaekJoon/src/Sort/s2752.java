package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2752 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			
			int count = stk.countTokens();
			int array[] = new int[count];
			
			for (int i = 0; i < count; i++) {
				array[i] = Integer.parseInt(stk.nextToken());
			}
			
			int temp;
			int index = 0;
			
			for (int i = 0; i < count; i++) {
				int min = 10000000;
				for (int j = i; j < count; j++) {
					if(min > array[j]) {
						min = array[j];
						index = j;
					}
				}
				
				temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
			
			for(int num : array)
				System.out.print(num + " ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
