package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class g2839 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		// �ԷµǴ� n�� �ִ� ���� 3���� ���� ���� ���� ������ ������ ��츦 ��Ÿ���ϴ�.
		// �ּ� ������ ���� �� ���˴ϴ�.
		final int MAX_BAG = 5000 / 3;
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			// n�� ������ ����� ���α׷��� �����մϴ�.
			if(n < 3 || n > 5000)
				return;
			
			// 3�� 5ų�α׷� ������ ���� �� �ִ� n�� ����� ���� ���� �� 
			// n�� 3ų�ο� 5ų�η� ���� �� �ִ� �ִ� ���ڸ� ������ ������ ��ȸ���ݴϴ�.
			int maxThreeKiloBag = n / 3;
			int maxFiveKiloBag = n / 5;
			
			// 3ų�� �� 5ų�η� ���� �� �ִ� ����� ���� ��� ����
			int TotalBag = 0;
			// 3ų�ο� 5ų�η� ���� �� �ִ� �ּ� ������ ���� ��� ����
			int minTotalBag = MAX_BAG;
			
			// n�� 3ų�η� ���� �� �ִ� �ִ����, 5ų�η� ���� �� �ִ� �ִ�� ��ŭ �ݺ��մϴ�.
			for (int i = 0; i <= maxThreeKiloBag; i++) {
				for (int j = 0; j <= maxFiveKiloBag; j++) {
					// 3ų�� ���� i���� 5ų�� ���� j���� �̿��� n�� ���ϱ� ���� ų�α׷��� ����ϴ�.
					int sum = 3*i + 5*j;
					
					// ���� ų�α׷� sum�� n�� ��ġ�ϰ� sum�� ���������� ���� minTotalBag���� ������ minTotalBag�� �������ݴϴ�. 
					if(sum == n && minTotalBag > i + j)
						minTotalBag = i + j;
				}
			}
			
			// ó���� ������ minTotalBag�� �ٲ��� �ʾ����� ����� ���� ���ٴ� ���̹Ƿ� -1�� �ֽ��ϴ�.
			if(minTotalBag == MAX_BAG)
				minTotalBag = -1;
			
			// ���
			bw.write(Integer.toString(minTotalBag));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	// �� ȿ������ ����Դϴ�.
//	// ���� �ּ��� ���� �������� 5ų�ΰ� ���� ���Ǿ�� �մϴ�.
//	 public static void main(String args[]){
//		 	// �Է� ���� ����
//	        int input = 0; 
//	        // 3ų�� ������ ������ ������ ����
//	        int count = 0;
//	        Scanner sc = new Scanner(System.in);
//	        input = sc.nextInt();
//	        
//	        while(true) {
//	        	// �Է¹��� ���� 5�� ������ ���������� ���� ������ �������ٸ� 
//	        	// count(3ų�� ������ ����)�� ���� 5�γ��� ��(5ų�� ������ ����)�� ����մϴ�.
//	        	// 0�� �������� 0�Դϴ�. 5�� ������ �������� �ʾƵ� ��, 3���θ� ������ ������ 0�̵ǵ� ������ �����մϴ�.
//	            if (input % 5 ==0) {
//	                System.out.println(input/5 + count);	// 
//	                break;
//	            // �ؿ��� 5�� ������ �������������� ����ؼ� 3�� ���ְ� �ǹǷ� input�� 0���ϰ� �Ǹ�
//	            // 5�� 3���� ���ڸ� ǥ���� �� ���ٴ� �ǹ̰� �ǹǷ� �Ұ����ϴٴ� -1�� ǥ�����ְ� �����մϴ�.
//	            }else if(input <= 0) {
//	                System.out.println(-1);
//	                break;
//	            }
//	            // ������ 5�� ������ �������� ������ -3�� ���ְ� 3ų�� ������ ������ 1�� �ø��ϴ�.
//	            input = input-3;
//	            count++;
//	        }
//	    }
}
