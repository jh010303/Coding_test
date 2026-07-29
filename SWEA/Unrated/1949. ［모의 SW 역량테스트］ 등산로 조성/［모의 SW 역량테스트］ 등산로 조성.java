import java.util.*;
import java.io.*;

class Solution
{
    static int[][] map;
    static List<List<Integer>> start = new ArrayList<>();
    static int answer = 0;
	static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            start.clear();
            
            int max = -1;
            answer = 0;
            
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
            	for(int j=0; j<n; j++){
                	map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max,map[i][j]);
                }
            }
            
            for(int i=0; i<n; i++){
            	for(int j=0; j<n; j++){
                	if(map[i][j]==max){
                        List<Integer> cord = new ArrayList<>();
                        cord.add(i); cord.add(j);
                    	start.add(cord);
                    }
                }
            }
            
            boolean[][] visited = new boolean[n][n];
            for(int i=0; i<start.size(); i++){
            	int y = start.get(i).get(0);
                int x = start.get(i).get(1);
                visited[y][x] = true;
                backTracking(visited,n,k,1,y,x,false);
                visited[y][x] = false; 
            }
           
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        
        System.out.print(sb);
	}
    
    static void backTracking(boolean[][] visited, int n, int k, int len, int y, int x, boolean used){
    	answer = Math.max(answer,len);
        
        for(int i=0; i<4; i++){
        	int ny = y+dy[i];
            int nx = x+dx[i];
            
            if(ny<0 || nx<0 || ny>=n || nx>=n || visited[ny][nx]){
            	continue;
            }
            
            if(map[y][x]>map[ny][nx]){
                visited[ny][nx] = true;
            	backTracking(visited,n,k,len+1,ny,nx,used);
                visited[ny][nx] = false;
            }
            else if(!used && map[y][x]>map[ny][nx]-k){
                int origin = map[ny][nx];
                map[ny][nx]=map[y][x]-1;
                used = true;
                visited[ny][nx] = true;
            	backTracking(visited,n,k,len+1,ny,nx,used);
                map[ny][nx]=origin;
                used = false;
                visited[ny][nx] = false;
            }
        }
    }
}