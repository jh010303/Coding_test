import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class Node{
		int y;
		int x;
		
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	static int[][] map = new int[16][16];
	static boolean[][] visited = new boolean[16][16];
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue<Node> que = new LinkedList<>();
	static boolean pos = false;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (int test_case = 1; test_case <= 10; test_case++) {
			init();
			br.readLine();
			for(int i=0; i<16; i++) {
				String temp = br.readLine();
				for(int j=0; j<16; j++) {
					map[i][j] = temp.charAt(j)-'0';
					if(map[i][j]==2) {
						visited[i][j] = true;
						que.offer(new Node(i,j));
					}
				}
			}
			

			while(!que.isEmpty()) {
				Node cur = que.poll();
				int cur_y = cur.y;
				int cur_x = cur.x;
				if(map[cur_y][cur_x]==3) {
					pos = true;
					break;
				}
				for(int i=0; i<4; i++) {
					int next_y = cur.y+dy[i];
					int next_x = cur.x+dx[i];
					if(next_y<0 || next_x<0 || next_y>=16 || next_x>=16 || map[next_y][next_x]==1 || visited[next_y][next_x]) {
						continue;
					}
					visited[next_y][next_x] = true;
					que.offer(new Node(next_y,next_x));
				}
			}
			
			sb.append("#").append(test_case).append(" ");
			if(pos) {
				sb.append(1);
			}
			else {
				sb.append(0);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void init() {
		que.clear();
		pos = false;
		for(int i=0; i<16; i++) {
			Arrays.fill(visited[i], false);
		}
	}
}
