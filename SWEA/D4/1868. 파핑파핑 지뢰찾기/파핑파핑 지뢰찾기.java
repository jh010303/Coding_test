import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution
{
	static int t,n,cnt;
	static char[][] mp = new char[301][301];
	static boolean[][] visited = new boolean[301][301];
	static int[] dy = {-1,-1,-1,0,0,1,1,1};
	static int[] dx = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			for(int i=0; i<301; i++) {
				Arrays.fill(visited[i], false);
			}
			for(int i=0; i<n; i++) {
				String temp = br.readLine();
				for(int j=0; j<temp.length(); j++) {
					mp[i][j] = temp.charAt(j);
				}
			}
			
			// 0이 있는지 검사
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(mp[i][j]=='.' && !visited[i][j]) {
						if(check_bomb(i,j)==0) {
							click(i,j);
							cnt++;
						}
					}
				}
			}
			// 남은 것들 처리
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(mp[i][j]=='.' && !visited[i][j]) {
						cnt++;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+cnt);
		}
	}
	
	public static int check_bomb(int y, int x) {
		int check = 0;
		for(int i=0; i<8; i++) {
			int next_y = y+dy[i];
			int next_x = x+dx[i];
			if(next_y<0 || next_x<0 || next_y>=n || next_x>=n) {
				continue;
			}
			if(mp[next_y][next_x]=='*') {
				check++;
			}
		}
		return check;
	}
	
	public static void click(int y, int x) {
		visited[y][x] = true;
		if(check_bomb(y,x)==0) {
			for(int i=0; i<8; i++) {
				int next_y = y+dy[i];
				int next_x = x+dx[i];
				if(next_y<0 || next_x<0 || next_y>=n || next_x>=n || visited[next_y][next_x] || mp[next_y][next_x]=='*') {
					continue;
				}
				click(next_y,next_x);
			} 
		}
	}
}