import java.io.*;
import java.util.*;

public class Solution {
	static class Cord{
		int y;
		int x;
		int w;
		public Cord(int y, int x, int w) {
			this.y = y;
			this.x = x;
			this.w = w;
		}
	}
	static int ans,n,w,h;
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			init();
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] tempMap = new int[h][w];
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					tempMap[i][j] = map[i][j];
				}
			}
			backTracking(0,tempMap);
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void backTracking(int depth, int[][] tempMap) {
		int cnt = countZero(tempMap);
		if(cnt==0) {
			ans=0;
			return;
		}
		if(depth==n) {
			ans = Math.min(ans, cnt);
			return;
		}
		for(int i=0; i<w; i++) {
			int j=0;
			for(; j<h; j++) {
				if(tempMap[j][i]!=0) {
					break;
				}
			}
			if(j>=h)continue;
			int[][] nextMap = new int[h][w];
			for(int r=0; r<h; r++) {
				for(int v=0; v<w; v++) {
					nextMap[r][v] = tempMap[r][v];
				}
			}
			boom(j,i,nextMap);
			down(nextMap);
			backTracking(depth+1, nextMap);
		}
	}
	
	static void down(int[][] tempMap) {
		for(int i=0; i<w; i++) {
			int[] temp = new int[h];
			int index = 0;
			for(int j=0; j<h; j++) {
				if(tempMap[j][i]!=0) {
					temp[index++]=tempMap[j][i];
				}
			}
			int tempI=0;
			for(int j=0; j<h; j++) {
				if(j<h-index) {
					tempMap[j][i]=0;
				}
				else {					
					tempMap[j][i] = temp[tempI++];
				}
				
			}
		}
	}
	
	static void boom(int y, int x, int[][] tempMap) {
		Queue<Cord> que = new LinkedList<>();
		que.offer(new Cord(y,x,tempMap[y][x]));
		while(!que.isEmpty()) {
			Cord cur = que.poll();
			int curY = cur.y; int curX = cur.x; int curW = cur.w;
			tempMap[curY][curX]=0;
			for(int i=0; i<4; i++) {
				for(int j=1; j<curW; j++) {
					int nextY = curY+dy[i]*j; int nextX = curX+dx[i]*j;
					if(nextX<0 || nextY<0 || nextX>=w || nextY>=h || tempMap[nextY][nextX]==0) {
						continue;
					}
					int nextW = tempMap[nextY][nextX];
					tempMap[nextY][nextX]=0;
					que.offer(new Cord(nextY,nextX,nextW));
				}
			}
		}
	}
	
	static int countZero(int[][] tempMap) {
		int cnt = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(tempMap[i][j]!=0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static void init() {
		ans = Integer.MAX_VALUE;
		map = new int[h][w];
	}
}