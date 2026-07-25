import java.util.*;

class Solution {
    int[] dy = {0,-1,1,0};
    int[] dx = {1,0,0,-1};
    char[] dir = {'d','l','r','u'};
    
    StringBuilder sb = new StringBuilder();
    String answer = "impossible";
    boolean flag = false;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dfs(n,m,x,y,r,c,k,0);
        return answer;
    }
    
    void dfs(int n, int m, int x, int y, int r, int c, int k, int cnt){
        if(flag){
            return;
        }
        
        int diff = Math.abs(r-x)+Math.abs(c-y);
        if(diff>k-cnt || (k-cnt-diff)%2!=0){
            return;
        }
        
        if(cnt==k){
            if(x==r && y==c){
                answer = sb.toString();
                flag = true;
            }
            return;
        }
        
        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny<1 || ny>m || nx<1 || nx>n){
                continue;
            }
            sb.append(dir[i]);
            dfs(n,m,nx,ny,r,c,k,cnt+1);
            sb.deleteCharAt(cnt);
        }
    }
}

// dfs -> 문자열이 사전 순으로 가장 빠른 경로
// 같은 격자 두 번 이상 방문 가능 -> visited 없음
// 거리가 k 초과하면 X => 무한 순회 방지

// d l r u