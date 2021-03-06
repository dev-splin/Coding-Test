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
			// 75254?Όλ©? 7?? 10000? κ³±ν΄μ£Όμ΄?Ό ?κΈ? ?λ¬Έμ 10? n?Ή? n? ?? λ³?????€.
			
			while (parsenum > 0) // κ³μ ??  ?«?κ°? 0?΄ ?  ? κΉμ? λ°λ³΅?©??€.
			{
				int singleDigit = parsenum % 10;
				// λ§? λ§μ?λ§? ??λ¦? ?λ₯? κ΅¬ν©??€. ex) 75254 % 10 = 4 
				
				singleDigit *= Math.pow(10, i);
				// 75254?? 2? 100? κ³±ν΄μ£Όμ΄?Ό ?κΈ? ?λ¬Έμ 10? n?Ή? ?΄?©?©??€.
				nums.add(singleDigit);
				
				++i;
				parsenum /= 10;
				// ?λ³Έκ°?? 10?Όλ‘? ???΄ ?λ¦? ?λ₯? μ€μ¬μ€λ?€. ex) 75254 / 10 = 7525
			}
			
			Collections.reverse(nums);
			// ??¬ λ¦¬μ€?Έ?? 75254κ°? '4, 50, 200, ...' ??Όλ‘? ?€?΄κ°? ?κΈ? ?λ¬Έμ λ°μ ?μΌμ€??€.
			
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
