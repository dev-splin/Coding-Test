package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1026 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String time = br.readLine();
			StringTokenizer separatedChar = new StringTokenizer(time,":");
			
			List<Integer> separatedTime = new ArrayList<Integer>();
			// ?‹œ, ë¶?, ì´ˆë?? ?•˜?‚˜?”© ë°›ì•„ì£¼ê¸° ?œ„?•œ ë¦¬ìŠ¤?Š¸
			
			while(separatedChar.hasMoreElements()) {
				separatedTime.add(Integer.parseInt(separatedChar.nextToken()));
			}
			
			bw.write(separatedTime.get(1).toString());
			bw.flush();
			bw.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
