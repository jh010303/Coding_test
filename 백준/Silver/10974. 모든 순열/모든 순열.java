import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N;
	static List<Integer> list = new ArrayList<Integer>();
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());// 입력된 숫자
		visited = new boolean[N + 1];
		select(0);
		System.out.println(sb);

	}

	public static void select(int idx) {
		if (idx == N) {
			for (int i : list) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list.add(i);
				
				select(idx + 1);
				
				visited[i] = false;
				list.remove(list.size() - 1);
			}
		}

	}

}