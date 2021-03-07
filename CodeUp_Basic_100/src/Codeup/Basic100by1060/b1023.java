package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

public class b1023 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String strnum = br.readLine();
			BigDecimal num = new BigDecimal(strnum);
			// ?ˆ˜ë¥? ?…? ¥ë°›ê³  BigDecimal???…?˜ num?— ?„£?Šµ?‹ˆ?‹¤.
						
			if (Math.abs(num.doubleValue()) < 10000)	// ? ˆ??ê°? ì²´í¬
			{
				int integerPart = num.intValue();
				bw.write(Integer.toString(integerPart));
				bw.write("\r\n");
				// BigDecimal?˜ ? •?ˆ˜ê°’ì„ ê°?? ¸?? ì¶œë ¥?•©?‹ˆ?‹¤.
								
				BigDecimal IntNum = new BigDecimal(Integer.toString(integerPart));
				// ?‹¤?ˆ˜ ê°’ì„ êµ¬í•˜? ¤ë©? '?›ë³¸ìˆ«? - ? •?ˆ˜' ë¥? ?•´?•¼?•©?‹ˆ?‹¤.
				// ? •?™•?•œ ?‹¤?ˆ˜ ê°? ê³„ì‚°?„ ?•˜? ¤ë©? BigDecimal?•ˆ?˜ ?—°?‚° ë©”ì†Œ?“œë¥? ?‚¬?š©?•´?•¼ ?•©?‹ˆ?‹¤.
				// BigDecimal?˜ ?—°?‚° ë©”ì†Œ?“œ?Š” BigDecimal???…ë§? ë°›ê¸°?•Œë¬¸ì— ? •?ˆ˜ê°’ì„ BigDecimal ???…?„ ë§Œë“¤?–´ ?„£?–´ì¤ë‹ˆ?‹¤.

				BigDecimal deciamlNum = num.subtract(IntNum);
				// BigDecimal?˜ ?—°?‚° ë©”ì†Œ?“œë¥? ?´?š©?•´ ?‹¤?ˆ˜ë¶?ë¶„ì„ êµ¬í•©?‹ˆ?‹¤.

				BigDecimal absDecimalNum = deciamlNum.abs();
				// ? •?ˆ˜ ë¶?ë¶„ì? '-'ê°? ?‚˜???„ ?ƒê´??—†ì§?ë§? ?‹¤?ˆ˜ë¶?ë¶„ì´ '-'ë¶™ì–´?„œ ?‚˜?˜¤ë©? ?•ˆ?˜ê¸? ?•Œë¬¸ì— ? ˆ??ê°’ìœ¼ë¡? ë§Œë“¤?–´ ì¤ë‹ˆ?‹¤.
				BigDecimal multiplyNum = new BigDecimal("10");
				// ?‹¤?ˆ˜ë¶?ë¶„ì? '0.xxx' ?˜•?‹?´ ?•„?‹ˆê³? ? •?ˆ˜ì²˜ëŸ¼ 'xxxx'?˜•?‹?œ¼ë¡? ?‚˜???•¼ ?˜ê¸? ?•Œë¬¸ì— ê³±í•  ?ˆ˜ë¥? BigDecimalë¡? ë§Œë“¤?–´ ì¤ë‹ˆ?‹¤.
				// BigDecimal ?—°?‚°?œ¼ë¡? ?•˜?Š” ?´?œ ?Š” '?‹¤?ˆ˜ * 10' ?œ¼ë¡? ?•˜ê²Œë˜ë©? ë¶??™?†Œ?ˆ˜? ?˜ ?Š¹ì§? ?•Œë¬¸ì— ?˜¤ì°¨ê? ?ƒê¸°ê²Œ ?©?‹ˆ?‹¤.
				
				int i = 1;
				// ?—¬?„¯ ë²ˆì§¸ ?ë¦¬ì¸ì§? ì²´í¬?•˜ê¸? ?œ„?•œ ë³??ˆ˜
				
				while (true) {
					BigDecimal multiplyResult = absDecimalNum.multiply(multiplyNum);
					// ?„?‹œë¡? BigDecimalë¥? ë§Œë“¤?–´ 10?„ ê³±í•´ë³´ê³  
					
					if (multiplyResult.doubleValue() % 10 == 0)
						break;
					// ?”± ?‚˜?ˆ„?–´ ?–¨?–´ì§?ë©? ë°˜ë³µë¬¸ì„ ?‚˜ê°‘ë‹ˆ?‹¤.
					// ex) 0.4356?Š” 4356?œ¼ë¡? ?‚˜???•¼ ?•˜ê¸? ?•Œë¬¸ì— 43560?´ ??„ ?•Œ ?›ë³? ê°’ì„ ?—…?°?´?Š¸ ?•˜ì§? ?•Šê³? ??‚´?Š” ê²ƒì…?‹ˆ?‹¤.
				
					absDecimalNum = absDecimalNum.multiply(multiplyNum);
					// ?›ë³? ê°’ì„ ë³?ê²½í•´ ì¤ë‹ˆ?‹¤.
					++i;
					
					if (i > 6)	// 7ë²ˆì§¸ ?ë¦¬ë?? ?—°?‚°?•˜? ¤ê³? ?•œ?‹¤ë©? ??ƒ…?‹ˆ?‹¤.
						break;
				}
				bw.write(Integer.toString(absDecimalNum.intValue()));
				bw.write("\r\n");
				
				bw.flush();
				bw.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
