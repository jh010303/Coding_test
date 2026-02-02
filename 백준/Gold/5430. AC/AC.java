import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	static int t, n;
	static String cmds, arr;
	static String[] num;
	static Deque<Integer> deque = new ArrayDeque<>();
	static boolean reverse, error;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			init();
			cmds = br.readLine();
			n = Integer.parseInt(br.readLine());
			arr = br.readLine();
			
			arr = arr.substring(1,arr.length());
			arr = arr.substring(0,arr.length()-1);
			
			num = new String[n+1];
			num = arr.split(",");

			for(int i=0; i<n; i++) {
				deque.addFirst(Integer.parseInt(num[i]));
			}

			for (int i = 0; i < cmds.length(); i++) {
				char cmd = cmds.charAt(i);
				if (cmd == 'R') {
					reverse = !reverse;
				} else if (cmd == 'D') {
					if (deque.isEmpty()) {
						error = true;
						break;
					}
					if (reverse) {
						deque.removeFirst();
					} else {
						deque.removeLast();
					}
				}
			}

			if(deque.isEmpty() && !error) {
				sb.append('[').append(']').append('\n');
				continue;
			}
			if (error) {
				sb.append("error").append('\n');
			} else {
				sb.append('[');
				while (!deque.isEmpty()) {
					if (reverse) {
						sb.append(deque.removeFirst()).append(',');
					} else {
						sb.append(deque.removeLast()).append(',');
					}
				}
				sb.deleteCharAt(sb.length()-1);
				sb.append(']').append('\n');
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
	
	static void init() {
		reverse = false;
		error = false;
		deque.clear();
	}
}
