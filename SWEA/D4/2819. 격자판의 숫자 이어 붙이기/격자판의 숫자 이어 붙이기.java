import java.io.*;
import java.util.*;

public class Solution {
	static int ans;
	static char[][] map = new char[4][4];
	static Set<String> set = new HashSet<>();
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			init();
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			StringBuilder num = new StringBuilder();
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {					
					backTracking(i,j,num,0);
				}
			}
			
			ans = set.size();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void backTracking(int y, int x, StringBuilder num, int depth) {
		if(depth==7) {
			set.add(num.toString());
			return;
		}
		for(int i=0; i<4; i++) {
			int nextY = y+dy[i]; int nextX = x+dx[i];
			if(nextY<0 || nextX<0 || nextY>=4 || nextX>=4) {
				continue;
			}
			num.append(map[nextY][nextX]);
			backTracking(nextY,nextX,num,depth+1);
			num.deleteCharAt(num.length()-1);
		}
	}
	
	static void init() {
		ans = 0;
		map = new char[4][4];
		set.clear();
	}
}