import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static List<String> cryptogram = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			cryptogram.clear();
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				cryptogram.add(st.nextToken());
			}
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String cmd = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if (cmd.equals("I")) {
					for (int j = x; j < x + y; j++) {
						cryptogram.add(j, st.nextToken());
					}
				}else if(cmd.equals("D")) {
					for(int j=0; j<y; j++) {
						cryptogram.remove(x);
					}
				}
			}
			sb.append('#').append(test_case).append(' ');
			for (int i = 0; i < 10; i++) {
				sb.append(cryptogram.get(i)).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
