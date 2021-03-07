package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1028 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String num = br.readLine();
			int unsignedNum = Integer.parseUnsignedInt(num);
			// String?„ '0 ~ 4,294,967,295'ë²”ìœ„ë¥? ê°?ì§??Š” UnsignedIntë¡? ë°”ê¾¸?–´ ì¤ë‹ˆ?‹¤.
			// Java?Š” ?–¸?–´?˜ ê°„ê²°?„±?„ ?œ„?•´ ë¶??˜¸?—†?Š” ???…?„ ? œ?™¸?–ˆê¸? ?•Œë¬¸ì— 
			// ê¸°ë³¸ UnsignedInt ?˜•?„ ì§??›?•˜ì§? ?•Š?•„ ë©”ì†Œ?“œë¥? ?´?š©?•´ ?‚¬?š©?•´?•¼ ?•©?‹ˆ?‹¤.
			// Java?Š” ë¶??˜¸?—†?Š” ???… ?‚¬?š©?„ ê¶Œì¥?•˜ì§? ?•Š?Š”?‹¤ê³? ?•©?‹ˆ?‹¤.
							
			bw.write(Integer.toUnsignedString(unsignedNum));
			// Integer.toUnsignedString?„ ?‚¬?š©?•˜ì§? ?•Š?œ¼ë©? ê¸°ë³¸ ? •?ˆ˜?˜• ìµœë? ë²”ìœ„?¸ 2147483647?„ ?„˜?–´ê°??Š” 2147483648 ë¶??„°
			// UnsignedInt ?˜ ìµœë? ë²”ìœ„?¸ 4294967295ê³¼ì˜ ì°?(?Œ?ˆ˜)ê°? ?‚˜?˜¤ê¸? ?•Œë¬¸ì— 
			// UnsignedIntë¥? ì¶œë ¥?•  ?•Œ?Š” ë°˜ë“œ?‹œ Integer.toUnsignedString?„ ?‚¬?š©?•˜?—¬?•¼ ?•©?‹ˆ?‹¤.
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
