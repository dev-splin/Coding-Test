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
			// String?�� '0 ~ 4,294,967,295'범위�? �?�??�� UnsignedInt�? 바꾸?�� 줍니?��.
			// Java?�� ?��?��?�� 간결?��?�� ?��?�� �??��?��?�� ???��?�� ?��?��?���? ?��문에 
			// 기본 UnsignedInt ?��?�� �??��?���? ?��?�� 메소?���? ?��?��?�� ?��?��?��?�� ?��?��?��.
			// Java?�� �??��?��?�� ???�� ?��?��?�� 권장?���? ?��?��?���? ?��?��?��.
							
			bw.write(Integer.toUnsignedString(unsignedNum));
			// Integer.toUnsignedString?�� ?��?��?���? ?��?���? 기본 ?��?��?�� 최�? 범위?�� 2147483647?�� ?��?���??�� 2147483648 �??��
			// UnsignedInt ?�� 최�? 범위?�� 4294967295과의 �?(?��?��)�? ?��?���? ?��문에 
			// UnsignedInt�? 출력?�� ?��?�� 반드?�� Integer.toUnsignedString?�� ?��?��?��?��?�� ?��?��?��.
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
