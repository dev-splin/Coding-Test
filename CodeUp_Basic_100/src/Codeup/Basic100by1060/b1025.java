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
			// 75254?¼ë©? 7?? 10000?„ ê³±í•´ì£¼ì–´?•¼ ?•˜ê¸? ?•Œë¬¸ì— 10?˜ n?Š¹?˜ n?„ ?œ„?•œ ë³??ˆ˜?…?‹ˆ?‹¤.
			
			while (parsenum > 0) // ê³„ì† ?‚˜?ˆ  ?ˆ«?ê°? 0?´ ?  ?•Œ ê¹Œì? ë°˜ë³µ?•©?‹ˆ?‹¤.
			{
				int singleDigit = parsenum % 10;
				// ë§? ë§ˆì?ë§? ?•œ?ë¦? ?ˆ˜ë¥? êµ¬í•©?‹ˆ?‹¤. ex) 75254 % 10 = 4 
				
				singleDigit *= Math.pow(10, i);
				// 75254?—?„œ 2?Š” 100?„ ê³±í•´ì£¼ì–´?•¼ ?•˜ê¸? ?•Œë¬¸ì— 10?˜ n?Š¹?„ ?´?š©?•©?‹ˆ?‹¤.
				nums.add(singleDigit);
				
				++i;
				parsenum /= 10;
				// ?›ë³¸ê°’?? 10?œ¼ë¡? ?‚˜?ˆ„?–´ ?ë¦? ?ˆ˜ë¥? ì¤„ì—¬ì¤ë‹ˆ?‹¤. ex) 75254 / 10 = 7525
			}
			
			Collections.reverse(nums);
			// ?˜„?¬ ë¦¬ìŠ¤?Š¸?—?Š” 75254ê°? '4, 50, 200, ...' ?‹?œ¼ë¡? ?“¤?–´ê°? ?ˆê¸? ?•Œë¬¸ì— ë°˜ì „?‹œì¼œì¤?‹ˆ?‹¤.
			
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
