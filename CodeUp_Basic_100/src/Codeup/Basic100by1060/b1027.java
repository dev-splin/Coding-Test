package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b1027 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String date = br.readLine();
			StringTokenizer separatedCharacter = new StringTokenizer(date,".");
			
			List<String> separatedDates = new ArrayList<String>();
			// ë¶„í• ?œ ë¬¸ìë¥? ?‚ ì§œë?? ?‹´?Š” ë¦¬ìŠ¤?Š¸
			
			while(separatedCharacter.hasMoreTokens()) {
				separatedDates.add(separatedCharacter.nextToken());
			}
			
			Collections.reverse(separatedDates);
			// ë¦¬ìŠ¤?Š¸ë¥? ë°˜ì „ ?‹œì¼œì??‹¤ 'dd-mm-yyyy'ê°? ?˜?–´?•¼ ?•˜ê¸? ?•Œë¬?
			
			for (int i = 0; i < separatedDates.size(); i++) {
				if (i != 0)
					bw.write("-");
				// ì²? ë²ˆì§¸ ?¸?±?Š¤ ?•?—” '-' ê°? ?‚˜?˜¤ë©? ?•ˆ?©?‹ˆ?‹¤.
				
				bw.write(separatedDates.get(i));
			}
			
			bw.flush();			
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
