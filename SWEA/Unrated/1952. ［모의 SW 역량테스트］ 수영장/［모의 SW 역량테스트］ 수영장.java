import java.io.*;
import java.util.*;

public class Solution {
	static int[] cost;
	static int[] plan;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			init();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			ans = cost[3];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			backTracking(0,0);
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}
	
	static void backTracking(int curCost, int depth) {
		if(depth >= 12) {
			ans = Math.min(curCost, ans);
			return;
		}
		
		if(plan[depth]==0) {
			backTracking(curCost,depth+1);
		}else {
			backTracking(curCost+cost[0]*plan[depth],depth+1);
			backTracking(curCost+cost[1],depth+1);
			backTracking(curCost+cost[2],depth+3);
		}
	}
	
	static void init() {
		cost = new int[4];
		plan = new int[12];
	}
}
