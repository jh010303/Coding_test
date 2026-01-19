import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution
{
	static int t,n,m,y,x,bw,cnt,b,w;
	static char[][] mp = new char[9][9];
	static int[] dx = {-1,0,1,1,1,0,-1,-1};
	static int[] dy = {-1,-1,-1,0,1,1,1,0};
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=t; test_case++) {
			b=0; w=0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			init_mp(n);
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken())-1;
				y = Integer.parseInt(st.nextToken())-1;
				bw = Integer.parseInt(st.nextToken());
				if(bw==1) {
					mp[y][x] = 'B';
					for(int j=0; j<8; j++) {
						int next_y = y+dy[j], next_x = x+dx[j];
						if(next_y<0 || next_x<0 || next_y>=n || next_x>=n || mp[next_y][next_x]!='W') continue;
						cnt = 2;
						while(true) {
							next_y = y+dy[j]*cnt; next_x = x+dx[j]*cnt;
							if(next_y<0 || next_x<0 || next_y>=n || next_x>=n || mp[next_y][next_x]=='0') break;
							if(mp[next_y][next_x]=='B') {
								for(int r=1; r<cnt; r++) {
									mp[y+dy[j]*r][x+dx[j]*r] = 'B';
								}
								break;
							}
							cnt++;
						}
					}
				}else if(bw==2) {
					mp[y][x] = 'W';
					for(int j=0; j<8; j++) {
						int next_y = y+dy[j], next_x = x+dx[j];
						if(next_y<0 || next_x<0 || next_y>=n || next_x>=n || mp[next_y][next_x]!='B') continue;
						cnt = 2;
						while(true) {
							next_y = y+dy[j]*cnt; next_x = x+dx[j]*cnt;
							if(next_y<0 || next_x<0 || next_y>=n || next_x>=n || mp[next_y][next_x]=='0') break;
							if(mp[next_y][next_x]=='W') {
								for(int r=1; r<cnt; r++) {
									mp[y+dy[j]*r][x+dx[j]*r] = 'W';
								}
								break;
							}
							cnt++;
						}
					}
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(mp[i][j]=='B')b++;
					else if(mp[i][j]=='W') w++;
				}
			}
			bwr.write("#"+test_case+" "+b+" "+w);
			bwr.newLine();
			bwr.flush();
		}
	}
	
	static void init_mp(int n) {
		for(int i=0; i<n; i++) {
			Arrays.fill(mp[i], '0');
		}
		mp[(n/2)-1][(n/2)-1] = 'W';
		mp[(n/2)-1][(n/2)] = 'B';
		mp[(n/2)][(n/2)-1] = 'B';
		mp[(n/2)][(n/2)] = 'W';
	}
}