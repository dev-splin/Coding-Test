package DataStructure;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class d1068 {
    static Set<Integer> set[];

    public static void delete(int index) {

        for (Integer num : set[index])
            delete(num);

        set[index] = null;
    }

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            int n = Integer.parseInt(br.readLine());

            set = new HashSet[n];

            for (int i = 0; i < n; i++)
                set[i] = new HashSet<>();

            StringTokenizer stk = new StringTokenizer(br.readLine());
            int parent[] = new int[n];

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(stk.nextToken());
                parent[i] = num;

                if(num == -1)
                    continue;

                set[num].add(i);
            }

            int delNum = Integer.parseInt(br.readLine());
            int delParent = parent[delNum];

            if(delParent != -1)
                set[parent[delNum]].remove(delNum);

            delete(delNum);

            int result = 0;

            for (int i = 0; i < n; i++)
                if(set[i] != null && set[i].isEmpty())
                    ++result;

            System.out.println(result);
        } catch (Exception e) {

        }
    }
}
