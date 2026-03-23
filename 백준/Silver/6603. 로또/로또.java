import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static boolean[] visited;
	static int[] num;
	static List<Integer> list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			K = Integer.parseInt(st.nextToken());
			num = new int[K];
			// 초기화

			if (K == 0) {
				break;
			} // 0일 시 종료
			for (int i = 0; i < K; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			// 입력완료

			Arrays.sort(num);// 정렬
			visited = new boolean[K];
			list = new ArrayList<Integer>();
			select(0, 0);
			sb.append("\n");   
		}
		System.out.println(sb);

	}

	public static void select(int idx, int start) {
		if (idx == 6) {
			for (int i : list) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		} // 종료조건

		for (int i = start; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list.add(num[i]);
				select(idx + 1, i + 1);

				visited[i] = false;
				list.remove(list.size() - 1);
			}

		}

	}

}