package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c3_1107 {
	static int nums[];
	
	public static int find(int findNum) {
		if(findNum == 100)
			return 0;
		
		int pushNum = 0;
		
		int count = 0;
		if(findNum == 0) {
			pushNum = findNearNum(0);
			++count;
		} else {
			int tmpFindNum = findNum;
			
			while(tmpFindNum > 0) {
				int mod = tmpFindNum % 10;
				pushNum += (int)Math.pow(10, count) * findNearNum(mod);
				
				tmpFindNum /= 10;
				++count;
			}
		}
			
		
		count += Math.abs(findNum - pushNum);
		
		return count;
	}
	
	public static int findNearNum(int num) {
		
		if(nums[num] == 0)
			return num;
		
		int right = num;
		int rightplus = 0;
		
		while(right < 9) {
			++rightplus;
			if(nums[++right] == 0)
				break;
		}
		
		int left = num;
		int leftplus = 0;
		
		while(left > 0) {
			++leftplus;
			if(nums[--left] == 0)
				break;
		}
		
		if(rightplus > leftplus)
			return left;
		else
			return right;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			nums = new int[10];
			StringTokenizer stk = null;
			
			if(m != 0) {
				stk = new StringTokenizer(br.readLine());
				
				for (int i = 0; i < m; i++) {
					int num = Integer.parseInt(stk.nextToken());
					nums[num] = -1;
				}
			}
			
			System.out.println(find(n));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
