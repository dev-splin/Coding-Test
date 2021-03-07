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
			// 만약 추후?�� ?��:�?:초로 출력?�� ?��?�� ?��?��?�� �??��?��?�� list�? 받았?��?��?��. 
			
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
      // 값을 ?��?��?���?
      
      sc = new Scanner(sc.next()).useDelimiter(":");
      // '':'�? 구분 ?��?��?���? ?��?��?�� ?��?��?��?�� 값을 �??��???�� ?��?��?�� 줍니?��.
      int a = sc.nextInt();
      int b = sc.nextInt();
      // ?��?�� 값들?�� Int?��?���? �??��?��?��?��.
      
      System.out.printf("%d:%d",a,b);
      sc.close();
  } 
}*/