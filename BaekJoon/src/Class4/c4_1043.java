package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class c4_1043 {
	static int n;
	// �� ��Ƽ���� ����� �̾߱⸦ ���� �ε����� ����
	static List<Integer> partys[];
	// �� �ε����� ����� �̾߱⸦ ����� ��Ƽ�� ����
	static List<Integer> liePartys[];
	// ������ �˰� �ִ� �ε���
	static boolean know[];
	
	// �Ķ���ͷ� ���� ��Ƽ��ȣ�� �ش��ϴ� �ε������� ������ �˰� �ǰ�,
	// �� �ε������� ���Ե� �ٸ� ��Ƽ�� �ε����鵵 ���������� ������ �˰� �Ǳ� ������ DFS�� ����մϴ�.
	public static void DFS (int partyNum) {
			
		if(partys[partyNum] == null)
			return;
			
		for(Integer index : partys[partyNum]) {
			// �̹� ������ �˰� �ִ� �ε����� liePartys�� ������ ���� �ʰ�
			// ���Ӱ� ������ �˰Ե� �ε����� know�� true�� �ٲ��� �� liePartys�� �˻��ϰ� �˴ϴ�.
			// ����, �� ������ ���ٸ� ���Ӱ� ������ �˰Ե� �ε����� �ٸ� ��Ƽ���� �����ϱ� ������ ���� ������ ������ �˴ϴ�.
			if(know[index])
				continue;
			
			know[index] = true;
			
			for(Integer lieParty : liePartys[index])
				DFS(lieParty);
		}
		// ��Ƽ�� �ִ� �ε����� üũ�� �������� �ش� ��Ƽ�� ����� ��Ƽ�� üũ�� �� �����ϱ� ���� null�� �־��ݴϴ�.
		partys[partyNum] = null;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			// �Է� ����
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			liePartys = new ArrayList[51];
			know = new boolean[51];
			
			for (int i = 1; i <= n; i++)
				liePartys[i] = new ArrayList<>();
			
			stk = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(stk.nextToken());
			
			for (int i = 0; i < k; i++)
				know[Integer.parseInt(stk.nextToken())] = true;
			// ������ �ƴ� ��� �Է±��� �Ϸ�
			
			partys = new ArrayList[m];
			
			// ��Ƽ�� ���� �����
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				int count = Integer.parseInt(stk.nextToken());
				
				partys[i] = new ArrayList<>();
				
				boolean isPossible = true;
				
				for (int j = 0; j < count; j++) {
					int num = Integer.parseInt(stk.nextToken());
					
					partys[i].add(num);
					
					// ������ �˰� �ִ� �ε����� 1���� ������ ����� �̾߱⸦ �� �� ���� ��Ƽ
					if(know[num])
						isPossible = false;
					// ������ �˰� �ִ� �ε����� 1���� ������ ����� ��Ƽ�̱� ������ ������ �д�.
					else
						liePartys[num].add(i);
				}
				
				// ����� �̾߱⸦ �� �� ���� ��Ƽ�̸� DFS�� �̿��� ���� ��Ƽ�� �ε������ �����Ǿ��ְ� ���ԵǾ��ִ� ��Ƽ���� null�� �ٲ��ݴϴ�.
				if(!isPossible)
					DFS(i);
			}
			
			int ans = 0;
			
			// ��Ƽ�� null�� �ƴ϶�� ����� ��Ƽ (��Ƽ�� �ƹ��� ���� ��쿡�� DFS���� null�� ���� �� ���� ������ counting �˴ϴ�.)
			for (int i = 0; i < m; i++)
				if(partys[i] != null)
					++ans;
			
			System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
