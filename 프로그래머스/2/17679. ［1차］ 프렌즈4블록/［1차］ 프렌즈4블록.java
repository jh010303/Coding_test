import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,1,0};
    static int[] dy = {0,0,1,1};
    static int ans;
    
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        visited = new boolean[m][n];
        
        initMap(board,m,n);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        
        int bef = 0;
        while(true){
            bef = ans;
            for(int i=0; i<m; i++){
                Arrays.fill(visited[i],false);
            }
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    char cur = map[i][j];
                    if(cur=='.')continue;
                    boolean allSame = true;
                    int count = 0;
                    for(int r=0; r<4; r++){
                        int nextY = i+dy[r], nextX = j+dx[r];
                        if(nextY>=m || nextX>=n || cur!=map[nextY][nextX]){
                            allSame = false;
                            break;
                        }
                        if(!visited[nextY][nextX]){
                            count++;
                        }
                    }
                    if(allSame){
                        ans+=count;
                        changeVisit(i,j);
                    }
                }
            }
            if(bef==ans){
                break;
            }
            changeMap(m,n);
        }
        
        
        return ans;
    }
    
    static void changeMap(int m, int n){
        char[] temp = new char[m];
        for(int i=0; i<n; i++){
            int cnt = 0;
            int index = 0;
            for(int j=0; j<m; j++){
                if(visited[j][i]){
                    cnt++;
                }
                else{
                    temp[index++] = map[j][i];
                }
            }
            index=0;
            for(int j=0; j<m; j++){
                if(j<cnt){
                    map[j][i]='.';
                }
                else{
                    map[j][i] = temp[index++];
                }
            }
        }
    }
    
    static void changeVisit(int y, int x){
        for(int i=0; i<4; i++){
            int nextY = y+dy[i], nextX = x+dx[i];
            if(!visited[nextY][nextX]){
                visited[nextY][nextX] = true;
            }
        }
    }
    
    static void initMap(String[] board, int m, int n){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
    }
    
}