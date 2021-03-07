package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1018 {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String time = br.readLine();
			
			StringTokenizer stk = new StringTokenizer(time,":");
			
			List<Integer> timeSeparations = new ArrayList<>();
			// ë§Œì•½ ì¶”í›„?— ?‹œ:ë¶?:ì´ˆë¡œ ì¶œë ¥?•  ?ˆ˜?„ ?ˆ?‹¤?Š” ê°?? •?•˜?— listë¡? ë°›ì•˜?Šµ?‹ˆ?‹¤. 
			
			while (stk.hasMoreTokens()) {
				int separatedTime = Integer.parseInt(stk.nextToken());
				
				timeSeparations.add(separatedTime);
			}
			
			System.out.printf("%d:%d",timeSeparations.get(0),timeSeparations.get(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


/*import java.util.Scanner;

class Main {  
  public static void main(String args[]) { 
      Scanner sc = new Scanner(System.in);
      // ê°’ì„ ?…? ¥?•˜ê³?
      
      sc = new Scanner(sc.next()).useDelimiter(":");
      // '':'ë¥? êµ¬ë¶„ ?Œ¨?„´?œ¼ë¡? ?„¤? •?•´ ?…? ¥?–ˆ?˜ ê°’ì„ ê°?? ¸???„œ ?‚˜?ˆ„?–´ ì¤ë‹ˆ?‹¤.
      int a = sc.nextInt();
      int b = sc.nextInt();
      // ?‚˜?ˆˆ ê°’ë“¤?„ Int?˜•?œ¼ë¡? ê°?? ¸?˜µ?‹ˆ?‹¤.
      
      System.out.printf("%d:%d",a,b);
      sc.close();
  } 
}*/