import java.util.*;
import java.io.*;

class Solution {
	static int[][] magnet = new int[4][8];
	static int[][] index = {{0,2},{0,2},{0,2},{0,2}}; // 점수, 회전 칸 인덱스
	static boolean[] visited = new boolean[4];
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			init();
			int k = Integer.parseInt(br.readLine());
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken())-1;
				int dir = Integer.parseInt(st.nextToken());
				visited[idx]=true;
				rotate(0,idx,dir);
				visited[idx]=false;
			}
			
			int ans = score();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static void rotate(int depth, int idx, int dir) {		
		int newDir = dir==1?-1:1;	
		if(idx-1>=0 && !visited[idx-1] && magnet[idx][(index[idx][1]+4)%8]!=magnet[idx-1][index[idx-1][1]]) {
			visited[idx-1]=true;
			rotate(depth+1,idx-1,newDir);
			visited[idx-1]=false;
		}
		if(idx+1<=3 && !visited[idx+1] && magnet[idx][index[idx][1]]!=magnet[idx+1][(index[idx+1][1]+4)%8]) {
			visited[idx+1]=true;
			rotate(depth+1,idx+1,newDir);
			visited[idx+1]=false;
		}
		
		if(dir==1) {
			index[idx][0] = (index[idx][0]+7) % 8;
			index[idx][1] = (index[idx][1]+7) % 8;
		}
		else {
			index[idx][0] = (index[idx][0]+1) % 8;
			index[idx][1] = (index[idx][1]+1) % 8;
		}
		
	}
	
	static int score() {
		int sum = 0;
		for(int i=0; i<4; i++) {
			if(magnet[i][index[i][0]]==1) {
				sum+=Math.pow(2, i);
			}
		}
		return sum;
	}
	
	static void init() {
		for(int i=0; i<4; i++) {
			index[i][0] = 0;
			index[i][1] = 2;
		}
	}
}