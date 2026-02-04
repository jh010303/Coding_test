import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[][] ladder = new int[100][100];
	static boolean[][] visited = new boolean[100][100];
	static int[] dx = {1,-1};
	static int curY,curX;
	static int t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		for (int test_case = 1; test_case <= 10; test_case++) {	
			t = Integer.parseInt(br.readLine());
			init();
			for(int i=0;i<100;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(ladder[i][j] == 2) {
						curY = i; curX = j;
					}
				}
			}
			
			while(curY!=0) {
				boolean rl = false;
				for(int i=0; i<2; i++) {
					int nextX = curX+dx[i];
					if(nextX<0 || nextX>=100 || visited[curY][nextX])continue;
					if(ladder[curY][nextX]==1) {
						visited[curY][curX]=true;
						visited[curY][nextX] = true;
						rl = true;
						curX = nextX;
						break;
					}
				}
				if(!rl)
					curY--;
			}
			
			sb.append("#").append(test_case).append(" ").append(curX).append("\n");
		}

		System.out.println(sb);
	}
	
	static void init() {
		for(int i=0; i<100; i++) {
			Arrays.fill(visited[i], false);
		}
	}
}
