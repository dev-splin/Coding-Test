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
			// 분할?�� 문자�? ?��짜�?? ?��?�� 리스?��
			
			while(separatedCharacter.hasMoreTokens()) {
				separatedDates.add(separatedCharacter.nextToken());
			}
			
			Collections.reverse(separatedDates);
			// 리스?���? 반전 ?��켜�??�� 'dd-mm-yyyy'�? ?��?��?�� ?���? ?���?
			
			for (int i = 0; i < separatedDates.size(); i++) {
				if (i != 0)
					bw.write("-");
				// �? 번째 ?��?��?�� ?��?�� '-' �? ?��?���? ?��?��?��?��.
				
				bw.write(separatedDates.get(i));
			}
			
			bw.flush();			
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
