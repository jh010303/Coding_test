import java.util.*;
import java.io.*;

class Solution
{
    static class V{
    	int y;
        int x;
        int t;
        
        public V(int y, int x, int t){
        	this.y = y;
            this.x = x;
            this.t = t;
        }
    }
    
    static int[][] map;

    // 상 하 좌 우
    static int dy[][] = { 
        {0,0,0,0}, {-1,1,0,0}, {-1,1,0,0},{0,0,0,0},{-1,0,0,0},{0,1,0,0},{0,1,0,0},{-1,0,0,0}
    };
    static int dx[][] = { 
        {0,0,0,0}, {0,0,-1,1}, {0,0,0,0},{0,0,-1,1},{0,0,0,1},{0,0,0,1},{0,0,-1,0},{0,0,-1,0}
    };
    static boolean[][] visited;
    static Queue<V> que = new LinkedList<>();
    
	public static void main(String args[]) throws Exception
	{
		int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            que.clear();
           
			st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            for(int i=0; i<n; i++){
            	st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++){
                	map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int answer = bfs(n,m,r,c,l);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        
        System.out.print(sb);
	}
                  
    static int bfs(int n, int m, int r, int c, int l){
        visited[r][c] = true;
        que.offer(new V(r,c,1));
         
        int count = 1;
        while(!que.isEmpty()){
        	V cur = que.poll();
            int cy = cur.y; int cx = cur.x; int ct = cur.t;
            int curMap = map[cy][cx];
            
            for(int i=0; i<4; i++){
            	int ny = cy+dy[curMap][i]; int nx = cx+dx[curMap][i]; int nt = ct+1;
                if(ny<0 || ny>=n || nx<0 || nx>=m || nt>l || map[ny][nx]==0 || visited[ny][nx] || !checkHole(ny,nx,i)){
                	continue;
                }
                
               count++;
               visited[ny][nx]=true;
               que.offer(new V(ny,nx,nt));
                
            }
            
        }
        
        return count;
    }
    
    static boolean checkHole(int y, int x, int dir){
    	if(dir==0){
        	if(map[y][x]==1 || map[y][x]==2 || map[y][x]==5 || map[y][x] == 6){
            	return true;
            }
        }
        else if(dir==1){
            if(map[y][x]==1 || map[y][x]==2 || map[y][x]==4 || map[y][x] == 7){
            	return true;
            }
        }
        else if(dir==2){
            if(map[y][x]==1 || map[y][x]==3 || map[y][x]==4 || map[y][x] == 5){
            	return true;
            }
        }
        else if(dir==3){
            if(map[y][x]==1 || map[y][x]==3 || map[y][x]==6 || map[y][x] == 7){
            	return true;
            }
        }
        return false;
    }
}