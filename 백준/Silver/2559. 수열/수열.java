import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> temperature = new ArrayList<>();
	static int n, k, max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			temperature.add(temp);
		}

		int s = 0, e = s + k - 1;
		int curSum = 0, befSum = 0, befEdgeSum = 0;

		while (e < n) {
			if (s == 0) {
				for (int i = s; i <= e; i++) {
					curSum += temperature.get(i);
				}
			} else {
				curSum = befSum - befEdgeSum + temperature.get(e);
			}
			if (curSum > max) {
				max = curSum;
			}
			befSum = curSum;
			befEdgeSum = temperature.get(s);
			s++;
			e++;
		}
		bw.write(max + "");
		bw.flush();
	}
}
