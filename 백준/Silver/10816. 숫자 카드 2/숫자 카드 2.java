import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static HashMap<Integer,Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			map.put(temp, map.getOrDefault(temp, 0)+1);
		}
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(temp, 0)).append(" ");
		}
		System.out.print(sb);
	}
}