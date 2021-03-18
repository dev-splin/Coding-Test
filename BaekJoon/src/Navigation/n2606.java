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
	// 컴퓨터 수
	static int computerCount;
	// 컴퓨터 수만큼 컴퓨터를 만들어서 넣기 위한 배열
	static Computer[] computers;
	
	// 컴퓨터 번호와 인접리스트를 가지고 있는 컴퓨터 클래스
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
	
	// 컴퓨터 개수만큼 컴퓨터를 만들고 네트워크를 입력하고 연결해줍니다.(서로의 인접리스트에 서로 추가해줍니다.)
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

	// BFS를 이용하여 1번 컴퓨터와 이어진 컴퓨터들을 찾아 개수를 체크합니다.
	public static int BFS() {
		Queue<Computer> queue = new LinkedList<>();
		queue.add(computers[0]);
		
		// 컴퓨터가 체크됐는 지 확인하기 위한 boolean 배열
		boolean check[] = new boolean[computerCount];
		check[0] = true;
		
		// 감염된 숫자를 셀 때 1은 빼므로 0부터 시작합니다.
		int count = 0;
		
		while(!queue.isEmpty()) {
			Computer checkComputer = queue.poll();
			
			// 해당 컴퓨터의 인접리스트에서 체크되지 않은 컴퓨터를 큐에 넣어주고 체크상태로 만들면서 count를 늘려줍니다.
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


