package Brute_Force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b14391 {
	static int paper[][];
	static int bitMask[];
	static int n;
	static int m;
	
	public static int findScore() {
		
		int result = 0; // �ִ밪�� ���� �� ����
		
		// ��Ʈ ����ũ ��� (��ġ�� �ʴ� ��� ��츦 üũ�� �� �ֽ��ϴ�.)
		// 0�� ����, 1�� ���η� �Ǵ� 
		// n X m �迭�� n * m������ ��Ʈ�� ǥ�� 
		for (int i = 0; i < 1<<(n * m); i++) {
			
			int totalScore = 0; // ���̸� ������ ���� ���ڵ��� ���� ���� ����
			
			int sum = 0; // ���ӵ� ���� ���ڸ� ���ؼ� ǥ���� �� ���� 
			int row = 0; // ���� ǥ���� �� ����
			
			// ����(�� ����, �� ����)
			for (int j = 0; j < n; j++) {
				
				sum = 0;	
				row = j * m; // ���� ������ ������ ���� ����(m)��ŭ ��Ʈ �ڸ����� ����
				

				for (int k = 0; k < m; k++) { // ���� ������ ��ŭ�� ��Ʈ �ڸ��� + �� == [��][��]
					if((i & 1<<(row + k)) == 0) { 
						sum *= 10; // 2���� �迭���� �� �ڸ��� ���� �� �ֱ� ������ ���ӵ� ������ ���� ������ ���ڿ� 10�� �����ݴϴ�.
						sum += paper[j][k];
					}
					else { // ������ ����� totalScore�� �������ְ� sum�� �����ϰ� sum�� 0���� ����ϴ�.(������ ����� ����)
						totalScore += sum;
						sum = 0;
					}
				}
				totalScore += sum;
			}
			
			// ����(�� ����, �� ����)
			for (int j = 0; j < m; j++) {
				sum = 0; 
				
				for (int k = 0; k < n; k++) {
					row = k * m;
					if((i & 1<<(row+j)) > 0) {
						sum *= 10;
						sum += paper[k][j];
					}
					else {
						totalScore += sum;
						sum = 0;
					}
				}
				totalScore += sum;
			}
			
			if(totalScore > result)
				result = totalScore;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			paper = new int[n][m];
			bitMask = new int[n];
			
			for (int i = 0; i < n; i++) {
				nums = br.readLine();
				for (int j = 0; j < m; j++)
					paper[i][j] = nums.charAt(j) - 48;
			}
			
			System.out.println(findScore());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

