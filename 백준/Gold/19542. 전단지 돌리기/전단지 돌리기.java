import java.io.*;
import java.util.*;

public class Main {
	static int n,s,d,ans;
	static List<List<Integer>> wayGraph = new ArrayList<List<Integer>>();
	static int[] height;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		init();
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			wayGraph.get(start).add(end);
			wayGraph.get(end).add(start);
		}

		height[s] = checkHeight(s,0);
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			if(height[i]>=d) {
				cnt++;
			}
		}
		ans = 2*(cnt-1<=0?0:cnt-1);
		System.out.print(ans);
	}

	static int checkHeight(int cur, int p) {
		for(int i=0; i<wayGraph.get(cur).size(); i++) {
			int next = wayGraph.get(cur).get(i);
			if(next!=p) {
				height[cur] = Math.max(height[cur],checkHeight(next,cur)+1);
			}
		}
		return height[cur];
	}
	
	static void init() {
		height = new int[n+1];
		for(int i=0; i<=n; i++) {
			wayGraph.add(new ArrayList<>());
		}
	}
}