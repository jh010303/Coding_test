import java.util.*;
import java.io.*;

public class Solution {
	static int n, m,ans;
	static List<List<Integer>> ingred = new ArrayList<>();
	static boolean[] ban;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			init();
			ban = new boolean[n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				ingred.get(a).add(b);
				ingred.get(b).add(a);
			}

			for (int i = 0; i < (1 << n); i++) {
				Arrays.fill(ban, false);
				boolean pos = true;
				for (int j = 1; j <=n; j++) {
					if ((i & (1 << (j-1))) != 0) {
						if(ban[j]) {
							pos = false;
							break;
						}
						for(int k=0; k<ingred.get(j).size(); k++) {
							ban[ingred.get(j).get(k)] = true;
						}
					}
				}
				if(pos) {
					ans++;
				}
			}
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void init() {
		ans=0;
		ingred.clear();
		for (int i = 0; i <= n + 1; i++) {
			ingred.add(new ArrayList<>());
		}
	}
}