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
			// ?λ₯? ?? ₯λ°κ³  BigDecimal???? num? ?£?΅??€.
						
			if (Math.abs(num.doubleValue()) < 10000)	// ? ??κ°? μ²΄ν¬
			{
				int integerPart = num.intValue();
				bw.write(Integer.toString(integerPart));
				bw.write("\r\n");
				// BigDecimal? ? ?κ°μ κ°?? Έ?? μΆλ ₯?©??€.
								
				BigDecimal IntNum = new BigDecimal(Integer.toString(integerPart));
				// ?€? κ°μ κ΅¬ν? €λ©? '?λ³Έμ«? - ? ?' λ₯? ?΄?Ό?©??€.
				// ? ?? ?€? κ°? κ³μ°? ?? €λ©? BigDecimal?? ?°?° λ©μ?λ₯? ?¬?©?΄?Ό ?©??€.
				// BigDecimal? ?°?° λ©μ?? BigDecimal???λ§? λ°κΈ°?λ¬Έμ ? ?κ°μ BigDecimal ???? λ§λ€?΄ ?£?΄μ€λ?€.

				BigDecimal deciamlNum = num.subtract(IntNum);
				// BigDecimal? ?°?° λ©μ?λ₯? ?΄?©?΄ ?€?λΆ?λΆμ κ΅¬ν©??€.

				BigDecimal absDecimalNum = deciamlNum.abs();
				// ? ? λΆ?λΆμ? '-'κ°? ???? ?κ΄??μ§?λ§? ?€?λΆ?λΆμ΄ '-'λΆμ΄? ??€λ©? ??κΈ? ?λ¬Έμ ? ??κ°μΌλ‘? λ§λ€?΄ μ€λ?€.
				BigDecimal multiplyNum = new BigDecimal("10");
				// ?€?λΆ?λΆμ? '0.xxx' ???΄ ??κ³? ? ?μ²λΌ 'xxxx'???Όλ‘? ????Ό ?κΈ? ?λ¬Έμ κ³±ν  ?λ₯? BigDecimalλ‘? λ§λ€?΄ μ€λ?€.
				// BigDecimal ?°?°?Όλ‘? ?? ?΄? ? '?€? * 10' ?Όλ‘? ?κ²λλ©? λΆ????? ? ?Ήμ§? ?λ¬Έμ ?€μ°¨κ? ?κΈ°κ² ?©??€.
				
				int i = 1;
				// ?¬?― λ²μ§Έ ?λ¦¬μΈμ§? μ²΄ν¬?κΈ? ?? λ³??
				
				while (true) {
					BigDecimal multiplyResult = absDecimalNum.multiply(multiplyNum);
					// ??λ‘? BigDecimalλ₯? λ§λ€?΄ 10? κ³±ν΄λ³΄κ³  
					
					if (multiplyResult.doubleValue() % 10 == 0)
						break;
					// ?± ???΄ ?¨?΄μ§?λ©? λ°λ³΅λ¬Έμ ?κ°λ?€.
					// ex) 0.4356? 4356?Όλ‘? ????Ό ?κΈ? ?λ¬Έμ 43560?΄ ?? ? ?λ³? κ°μ ??°?΄?Έ ?μ§? ?κ³? ??΄? κ²μ??€.
				
					absDecimalNum = absDecimalNum.multiply(multiplyNum);
					// ?λ³? κ°μ λ³?κ²½ν΄ μ€λ?€.
					++i;
					
					if (i > 6)	// 7λ²μ§Έ ?λ¦¬λ?? ?°?°?? €κ³? ??€λ©? ????€.
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
