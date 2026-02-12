import java.io.*;
import java.util.*;

public class Solution {
	static class Room{
		int y;
		int x;
		int moveCnt;
		public Room(int y, int x, int moveCnt) {
			super();
			this.y = y;
			this.x = x;
			this.moveCnt = moveCnt;
		}
	}
	
	static int roomAns, cntAns;
	static int[][] rooms;
	static int[][] dp;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue<Room> que = new ArrayDeque<>();
	
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			init();
			sb.append("#").append(test_case).append(" ");
			int n = Integer.parseInt(in.readLine());
			rooms = new int[n][n];
			dp = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<n; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
	
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(dp[i][j]>0) continue;
					que.offer(new Room(i,j,dp[i][j]));
					int start = rooms[i][j];
					while(!que.isEmpty()) {
						Room curRoom = que.poll();
						int curY= curRoom.y, curX = curRoom.x, curCnt = curRoom.moveCnt, curNum = rooms[curY][curX];
						for(int r=0; r<4; r++) {
							int nextY = curY+dy[r], nextX = curX+dx[r], nextCnt=curCnt+1;
							if(nextY<0 || nextX<0 || nextX>=n || nextY>=n) continue;
							int nextNum = rooms[nextY][nextX];
							if(nextNum == curNum+1) {
								dp[nextY][nextX] = nextCnt;
								que.offer(new Room(nextY,nextX,nextCnt));
								if(cntAns<nextCnt) {
									cntAns = nextCnt;
									roomAns = start;
								}
								else if(cntAns==nextCnt) {
									if(roomAns>start) {
										roomAns = start;
									}									
								}
							}
						}
					}
				}
			}
			
			sb.append(roomAns).append(" ").append(cntAns+1).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void init() {
		roomAns = Integer.MAX_VALUE;
		cntAns = 0;
	}
}

