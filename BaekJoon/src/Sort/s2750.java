package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class s2750 {
	static int nums[];
	
	public static void quickSort(int start, int end) {
		if(start >= end)
			return;
		
		int pivot = start;
		
		int i = start+1;
		int j = end;
		int temp = 0;
		
		while(i <= j) {
			if(i <= end &&  nums[i] < nums[pivot]) {
				++i;
			}
			
			if(j > start && nums[j] > nums[pivot]) {
				--j;
			}
			
			if(i > j) {
				temp = nums[pivot];
				nums[pivot] = nums[j];
				nums[j] = temp;
			} else {
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		
		quickSort(j + 1, end);
		quickSort(start, j - 1);
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			nums = new int[n];
			
			for (int i = 0; i < n; i++) 
				nums[i] = Integer.parseInt(br.readLine());
			
			quickSort(0, n-1);
			
			for(int num : nums)
				System.out.println(num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

