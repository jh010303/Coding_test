import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] visited;
	static int[] num;
	static int res = Integer.MIN_VALUE;
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());// 입력된 숫자
		visited = new boolean[N];
		num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());

		}
		// 입력완료
		select(0);
		System.out.println(res);

	}

	public static void select(int idx) {
		if (idx == N) {// N개를 전부 고르면
			int cnt = 0;
			for (int i = 0; i < list.size() - 1; i++) {
				cnt += Math.abs(list.get(i) - list.get(i + 1));
			}
			res = Math.max(res, cnt);
			return;
		} // 종료조건

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list.add(num[i]);
				select(idx+1);
				visited[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}

}