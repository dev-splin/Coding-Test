package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class s2751 {
	static int nums[];
	static int tmpArr[];
	
	public static void merge(int start, int mid, int end) {
		
		int i = start;
		int j = mid + 1;
		int k = start;
		
		while(i <= mid && j <= end) {
			if(nums[i] < nums[j]) {
				tmpArr[k] = nums[i];
				++i;
			}
			else {
				tmpArr[k] = nums[j];
				++j;
			}
			++k;
		}
			
		if(i > mid)
			for (int t = j; t <= end; t++) {
				tmpArr[k] = nums[t];
				++k;
			}
		else
			for (int t = i; t <= mid; t++) {
				tmpArr[k] = nums[t];
				++k;
			}
		
		for (int t = start; t <= end; t++)
			nums[t] = tmpArr[t];
		
	}
	
	public static void mergeSort(int start, int end) {
		
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(start,mid);
			mergeSort(mid+1,end);
			merge(start, mid, end);
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			nums = new int[n];
			tmpArr = new int[n];
			
			for (int i = 0; i < n; i++) 
				nums[i] = Integer.parseInt(br.readLine());
			
			mergeSort(0, n-1);
			
			for(int num : nums) {
				bw.write(Integer.toString(num));
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
