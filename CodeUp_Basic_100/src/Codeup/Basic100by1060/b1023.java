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
			// ?���? ?��?��받고 BigDecimal???��?�� num?�� ?��?��?��?��.
						
			if (Math.abs(num.doubleValue()) < 10000)	// ?��??�? 체크
			{
				int integerPart = num.intValue();
				bw.write(Integer.toString(integerPart));
				bw.write("\r\n");
				// BigDecimal?�� ?��?��값을 �??��?? 출력?��?��?��.
								
				BigDecimal IntNum = new BigDecimal(Integer.toString(integerPart));
				// ?��?�� 값을 구하?���? '?��본숫?�� - ?��?��' �? ?��?��?��?��?��.
				// ?��?��?�� ?��?�� �? 계산?�� ?��?���? BigDecimal?��?�� ?��?�� 메소?���? ?��?��?��?�� ?��?��?��.
				// BigDecimal?�� ?��?�� 메소?��?�� BigDecimal???���? 받기?��문에 ?��?��값을 BigDecimal ???��?�� 만들?�� ?��?��줍니?��.

				BigDecimal deciamlNum = num.subtract(IntNum);
				// BigDecimal?�� ?��?�� 메소?���? ?��?��?�� ?��?���?분을 구합?��?��.

				BigDecimal absDecimalNum = deciamlNum.abs();
				// ?��?�� �?분�? '-'�? ?��???�� ?���??���?�? ?��?���?분이 '-'붙어?�� ?��?���? ?��?���? ?��문에 ?��??값으�? 만들?�� 줍니?��.
				BigDecimal multiplyNum = new BigDecimal("10");
				// ?��?���?분�? '0.xxx' ?��?��?�� ?��?���? ?��?��처럼 'xxxx'?��?��?���? ?��???�� ?���? ?��문에 곱할 ?���? BigDecimal�? 만들?�� 줍니?��.
				// BigDecimal ?��?��?���? ?��?�� ?��?��?�� '?��?�� * 10' ?���? ?��게되�? �??��?��?��?��?�� ?���? ?��문에 ?��차�? ?��기게 ?��?��?��.
				
				int i = 1;
				// ?��?�� 번째 ?��리인�? 체크?���? ?��?�� �??��
				
				while (true) {
					BigDecimal multiplyResult = absDecimalNum.multiply(multiplyNum);
					// ?��?���? BigDecimal�? 만들?�� 10?�� 곱해보고 
					
					if (multiplyResult.doubleValue() % 10 == 0)
						break;
					// ?�� ?��?��?�� ?��?���?�? 반복문을 ?��갑니?��.
					// ex) 0.4356?�� 4356?���? ?��???�� ?���? ?��문에 43560?�� ?��?�� ?�� ?���? 값을 ?��?��?��?�� ?���? ?���? ?��?��?�� 것입?��?��.
				
					absDecimalNum = absDecimalNum.multiply(multiplyNum);
					// ?���? 값을 �?경해 줍니?��.
					++i;
					
					if (i > 6)	// 7번째 ?��리�?? ?��?��?��?���? ?��?���? ?��?��?��?��.
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
