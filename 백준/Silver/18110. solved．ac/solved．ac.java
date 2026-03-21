import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<Integer> scores = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			scores.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(scores);
		
		int cut = Math.round(n*0.15f);
		int sum = 0;
		int cnt = 0;
		for(int i=cut; i<scores.size()-cut; i++) {
			sum+=scores.get(i);
			cnt++;
		}
		int ans = Math.round((float)sum/cnt);
		System.out.print(ans);
	}
}