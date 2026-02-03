import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int t;
	static HashMap<String, Integer> mp = new HashMap<>();
	static String[] number = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
	static List<Integer> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		init();
		t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			initArr();
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int n = 0;
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				arr.add(mp.get(st.nextToken()));
			}
			
			Collections.sort(arr);
			sb.append("#").append(test_case).append("\n");
			for (int i = 0; i < arr.size(); i++) {
				sb.append(number[arr.get(i)]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void init() {
		mp.put("ZRO", 0);
		mp.put("ONE", 1);
		mp.put("TWO", 2);
		mp.put("THR", 3);
		mp.put("FOR", 4);
		mp.put("FIV", 5);
		mp.put("SIX", 6);
		mp.put("SVN", 7);
		mp.put("EGT", 8);
		mp.put("NIN", 9);
	}
	static void initArr() {
		arr.clear();
	}
}
