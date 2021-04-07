package Brute_Force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b14888 {
	static int nums[], operators[];
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n;
	final static int ADD = 0, SUB = 1, MUL = 2, DIV = 3;
	
	public static void DFS(int sum ,int depth) {
		if(depth >= n) {
			if(min > sum)
				min = sum;
			if(max < sum)
				max = sum;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(operators[i] > 0) {
				--operators[i];
				int tmpSum = sum;
				if(i == ADD)
					tmpSum += nums[depth];
				else if(i == SUB)
					tmpSum -= nums[depth];
				else if(i == MUL)
					tmpSum *= nums[depth];
				else
					tmpSum /= nums[depth];
				
				DFS(tmpSum,depth + 1);
				++operators[i];
			}
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			n = Integer.parseInt(br.readLine());
			
			nums = new int[n];
			operators = new int[4];
			
			String inputNums = br.readLine();
			StringTokenizer stk = new StringTokenizer(inputNums);
			
			for (int i = 0; i < n; i++)
				nums[i] = Integer.parseInt(stk.nextToken());
			
			inputNums = br.readLine();
			stk = new StringTokenizer(inputNums);
			
			for (int i = 0; i < 4; i++)
				operators[i] = Integer.parseInt(stk.nextToken());
			
			DFS(nums[0],1);
			System.out.println(max);
			System.out.println(min);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

