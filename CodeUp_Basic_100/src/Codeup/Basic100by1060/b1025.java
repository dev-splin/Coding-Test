package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class b1025 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			List<Integer> nums = new ArrayList<Integer>();
			
			String num = br.readLine();
			
			int parsenum = Integer.parseInt(num);
			
			if(parsenum < 10000 || parsenum >= 100000)
				return;
			
			int i = 0;
			// 75254?���? 7?? 10000?�� 곱해주어?�� ?���? ?��문에 10?�� n?��?�� n?�� ?��?�� �??��?��?��?��.
			
			while (parsenum > 0) // 계속 ?��?�� ?��?���? 0?�� ?�� ?�� 까�? 반복?��?��?��.
			{
				int singleDigit = parsenum % 10;
				// �? 마�?�? ?��?���? ?���? 구합?��?��. ex) 75254 % 10 = 4 
				
				singleDigit *= Math.pow(10, i);
				// 75254?��?�� 2?�� 100?�� 곱해주어?�� ?���? ?��문에 10?�� n?��?�� ?��?��?��?��?��.
				nums.add(singleDigit);
				
				++i;
				parsenum /= 10;
				// ?��본값?? 10?���? ?��?��?�� ?���? ?���? 줄여줍니?��. ex) 75254 / 10 = 7525
			}
			
			Collections.reverse(nums);
			// ?��?�� 리스?��?��?�� 75254�? '4, 50, 200, ...' ?��?���? ?��?���? ?���? ?��문에 반전?��켜줍?��?��.
			
			for(int digitNum : nums)
			{
				bw.write("[" + Integer.toString(digitNum) + "]");
				bw.write("\r\n");
			}
			
			bw.flush();
			bw.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
