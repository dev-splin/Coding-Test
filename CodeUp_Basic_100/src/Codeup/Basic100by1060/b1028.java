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
			// String? '0 ~ 4,294,967,295'λ²μλ₯? κ°?μ§?? UnsignedIntλ‘? λ°κΎΈ?΄ μ€λ?€.
			// Java? ?Έ?΄? κ°κ²°?±? ??΄ λΆ??Έ?? ???? ? ?Έ?κΈ? ?λ¬Έμ 
			// κΈ°λ³Έ UnsignedInt ?? μ§???μ§? ?? λ©μ?λ₯? ?΄?©?΄ ?¬?©?΄?Ό ?©??€.
			// Java? λΆ??Έ?? ??? ?¬?©? κΆμ₯?μ§? ???€κ³? ?©??€.
							
			bw.write(Integer.toUnsignedString(unsignedNum));
			// Integer.toUnsignedString? ?¬?©?μ§? ??Όλ©? κΈ°λ³Έ ? ?? μ΅λ? λ²μ?Έ 2147483647? ??΄κ°?? 2147483648 λΆ??°
			// UnsignedInt ? μ΅λ? λ²μ?Έ 4294967295κ³Όμ μ°?(??)κ°? ??€κΈ? ?λ¬Έμ 
			// UnsignedIntλ₯? μΆλ ₯?  ?? λ°λ? Integer.toUnsignedString? ?¬?©??¬?Ό ?©??€.
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
