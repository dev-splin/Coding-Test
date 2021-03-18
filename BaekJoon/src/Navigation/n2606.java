package Navigation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class n2606 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	// ��ǻ�� ��
	static int computerCount;
	// ��ǻ�� ����ŭ ��ǻ�͸� ���� �ֱ� ���� �迭
	static Computer[] computers;
	
	// ��ǻ�� ��ȣ�� ��������Ʈ�� ������ �ִ� ��ǻ�� Ŭ����
	public static class Computer {
		int num;
		List<Computer> adjacentComputer;
		
		public Computer(int num) {
			this.num = num;
			adjacentComputer = new ArrayList<>();
		}
		
		public void add(Computer computer) {
			adjacentComputer.add(computer);
		}
	}
	
	// ��ǻ�� ������ŭ ��ǻ�͸� ����� ��Ʈ��ũ�� �Է��ϰ� �������ݴϴ�.(������ ��������Ʈ�� ���� �߰����ݴϴ�.)
	public static void makeComputer() throws Exception{
		computers = new Computer[computerCount];
		
		for (int i = 0; i < computers.length; i++)
			computers[i] = new Computer(i+1);
		
		int networkCount = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < networkCount; i++) {
			String nums = br.readLine().trim();
			
			StringTokenizer stk = new StringTokenizer(nums);
			int computerIndex1 = Integer.parseInt(stk.nextToken()) - 1;
			int computerIndex2 = Integer.parseInt(stk.nextToken()) - 1;
			
			computers[computerIndex1].add(computers[computerIndex2]);
			computers[computerIndex2].add(computers[computerIndex1]);
		}
	}

	// BFS�� �̿��Ͽ� 1�� ��ǻ�Ϳ� �̾��� ��ǻ�͵��� ã�� ������ üũ�մϴ�.
	public static int BFS() {
		Queue<Computer> queue = new LinkedList<>();
		queue.add(computers[0]);
		
		// ��ǻ�Ͱ� üũ�ƴ� �� Ȯ���ϱ� ���� boolean �迭
		boolean check[] = new boolean[computerCount];
		check[0] = true;
		
		// ������ ���ڸ� �� �� 1�� ���Ƿ� 0���� �����մϴ�.
		int count = 0;
		
		while(!queue.isEmpty()) {
			Computer checkComputer = queue.poll();
			
			// �ش� ��ǻ���� ��������Ʈ���� üũ���� ���� ��ǻ�͸� ť�� �־��ְ� üũ���·� ����鼭 count�� �÷��ݴϴ�.
			for(Computer computer : checkComputer.adjacentComputer) {
				if(!check[computer.num - 1]) {
					queue.add(computer);
					++count;
					check[computer.num - 1] = true;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			computerCount = Integer.parseInt(br.readLine().trim());
			
			makeComputer();
			
			int result = BFS();
			
			bw.write(Integer.toString(result));
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


