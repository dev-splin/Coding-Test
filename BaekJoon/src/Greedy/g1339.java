package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class g1339 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			// 아스키 코드를 이용해서 알파벳 A~Z를 인덱스로할 배열을 만듭니다.
			int alphabets[] = new int[26];

			// 단어 char배열로 입력받고 단어의 길이만큼 자리수(digit)를 만들어 주고(abcd면 10의 3승)
			// 해당 알파벳에-65(아스키코드)를 해서 해당 인덱스에 자리수를 더합니다.
			// 만약 ABC와 CDE가 있다고 하면 C(67 - 65)는 2번인덱스에 1 + 100이 들어가 있습니다.
			for (int i = 0; i < n; i++) {
				char word[] = br.readLine().toUpperCase().trim().toCharArray();
				
				int digit = (int)Math.pow(10, word.length - 1);
				for (int j = 0; j < word.length; j++) {
					alphabets[word[j] - 65] += digit;
					
					digit /= 10;
				}
			}
			
			// 알파벳들을 오름차순으로 정렬
			Arrays.sort(alphabets);
			
			// 해당 알파벳을 num으로 인식하게 하기위한 변수
			int num = 9;
			int sum = 0;
			
			// 알파벳들을 오름차순으로 정렬했기 때문에 거꾸로 순회하면서 제일 큰 숫자를 가지고 있는 알파벳 부터
			// 9~0순으로 부여해주고 결과를 구해줍니다. 이 때, 0이면 순회를 종료해줍니다.(알파벳을 사욯아지 않았으면 0이기 때문에)
			// c가 cdsq, dfsc, accd에 사용되고 있으면 c에 해당하는 인덱스의 값은 1000 + 1 + 110 = 1111 이됩니다.
			for (int i = alphabets.length -1 ; i >= 0; --i) {
				if(alphabets[i] == 0)
					break;
				
				sum += num * alphabets[i];
				--num;
			}
						
			bw.write(Integer.toString(sum));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
