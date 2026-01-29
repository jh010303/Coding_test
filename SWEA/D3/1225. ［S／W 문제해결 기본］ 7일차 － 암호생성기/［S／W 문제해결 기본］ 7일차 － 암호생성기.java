import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static int t;
    static LinkedList<Integer> que = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        for (int test_case = 1; test_case <= 10; test_case++) {
        	t = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<8; i++) {
            	que.offer(Integer.parseInt(st.nextToken()));
            }
            int minus=1,cycle=0;
            while(true) {
            	if(cycle%5==0) {
            		minus=1;
            		cycle=0;
            	}
            	int temp = que.poll();
            	temp-=minus;
            	if(temp<=0) {
            		temp=0;
            		que.offer(temp);
            		break;
            	}else {
            		que.offer(temp);
            	}
            	minus++;
            	cycle++;
            }
            sb.append("#").append(test_case).append(" ");
            while(!que.isEmpty()) {
            	sb.append(que.poll()).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
