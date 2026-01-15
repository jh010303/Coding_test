import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{

	static int t,h,w,n,cur_y,cur_x,shoot;
	static char[][] arr = new char[101][101];
	static char dir;
	static String cmds;
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=t; test_case++) {
			shoot=1;
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken()); w = Integer.parseInt(st.nextToken());
			for(int i=0; i<h; i++) {
				String temp = br.readLine();
				for(int j=0; j<w; j++) {
					arr[i][j] = temp.charAt(j);
					if(arr[i][j]=='<' || arr[i][j]=='>' || arr[i][j]=='^' || arr[i][j]=='v') {
						cur_y = i; cur_x = j;
					}
				}
			}
			n = Integer.parseInt(br.readLine());
			cmds = br.readLine();
			for(int i=0; i<cmds.length(); i++) {
				char cmd = cmds.charAt(i);
				if(cmd=='U') {
					arr[cur_y][cur_x]='^';
					if(cur_y-1>=0 && arr[cur_y-1][cur_x]=='.') {
						arr[cur_y][cur_x]='.';
						cur_y--;
						arr[cur_y][cur_x]='^';
					}
				}else if(cmd=='D') {
					arr[cur_y][cur_x]='v';
					if(cur_y+1<h && arr[cur_y+1][cur_x]=='.') {
						arr[cur_y][cur_x]='.';
						cur_y++;
						arr[cur_y][cur_x]='v';
					}
				}
				else if(cmd=='L') {
					arr[cur_y][cur_x]='<';
					if(cur_x-1>=0 && arr[cur_y][cur_x-1]=='.') {
						arr[cur_y][cur_x]='.';
						cur_x--;
						arr[cur_y][cur_x]='<';
					}
				}
				else if(cmd=='R') {
					arr[cur_y][cur_x]='>';
					if(cur_x+1<w && arr[cur_y][cur_x+1]=='.') {
						arr[cur_y][cur_x]='.';
						cur_x++;
						arr[cur_y][cur_x]='>';
					}
				}
				else if(cmd=='S') {
					dir = arr[cur_y][cur_x];
					if(dir=='^') {
						while(true) {
							if(cur_y-shoot<0)break;
							if(arr[cur_y-shoot][cur_x]=='#') break;
							if(arr[cur_y-shoot][cur_x]=='*') {
								arr[cur_y-shoot][cur_x]='.';
								break;
							}
							shoot++;
						}
					}else if(dir=='v') {
						while(true) {
							if(cur_y+shoot>=h)break;
							if(arr[cur_y+shoot][cur_x]=='#') break;
							if(arr[cur_y+shoot][cur_x]=='*') {
								arr[cur_y+shoot][cur_x]='.';
								break;
							}
							shoot++;
						}
					}else if(dir=='<') {
						while(true) {
							if(cur_x-shoot<0)break;
							if(arr[cur_y][cur_x-shoot]=='#') break;
							if(arr[cur_y][cur_x-shoot]=='*') {
								arr[cur_y][cur_x-shoot]='.';
								break;
							}
							shoot++;
						}
					}else if(dir=='>') {
						while(true) {
							if(cur_x+shoot>=w)break;
							if(arr[cur_y][cur_x+shoot]=='#') break;
							if(arr[cur_y][cur_x+shoot]=='*') {
								arr[cur_y][cur_x+shoot]='.';
								break;
							}
							shoot++;
						}
					}
					shoot=1;
				}
			}
			
			
			System.out.print("#"+test_case+" ");
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}
}