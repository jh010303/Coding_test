import java.util.*;
import java.io.*;


class Solution
{
    static int[][] map = new int[4][4];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    static Set<List<Integer>> set = new HashSet<>();
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            set.clear();
			for(int i=0; i<4; i++){
				st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++){
                	map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
		
			List<Integer> number = new ArrayList<>();
            for(int i=0; i<4; i++){
            	for(int j=0; j<4; j++){
                	dfs(i,j,0,number);
                }
            }
			
            sb.append("#").append(test_case).append(" ").append(set.size()).append("\n");
		}
        System.out.print(sb);
	}
    
    static void dfs(int y, int x, int cnt, List<Integer> number){
    	if(cnt==7) {
    		set.add(number);
    		return;
    	}
    	
    	number.add(map[y][x]);
    	for(int i=0; i<4; i++) {
    		int ny = y+dy[i];
    		int nx = x+dx[i];
            if(ny<0 || nx<0 || ny>=4 || nx>=4){
            	continue;
            }
    		dfs(ny,nx,cnt+1,number);
    	}
    	number.remove(cnt);
    }
}