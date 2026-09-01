import java.util.*;

class Solution {
    boolean poss = true;
    String trace = "";
    
    int[] dy = {0,-1,1,0};
    int[] dx = {1,0,0,-1};
    char[] alpha = {'d','l','r','u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        int dist = Math.abs(r-x)+Math.abs(c-y);
        
        // 짝수, 홀수 맞지 않거나, 최단거리가 k보다 클 때
        if(!(k%2==0 && dist%2==0 || k%2!=0 && dist%2!=0) || dist>k){
            poss = false;
            answer = "impossible";
        }
        
        if(poss){
            recurSive(n,m,x,y,r,c,k);
            answer =  trace;
        }
        
        return answer;
    }
    
    void recurSive(int n, int m, int x, int y, int r, int c, int k){
        int dist = Math.abs(r-x)+Math.abs(c-y); // 최단거리
        if(dist==k){ // 이동할 수 있는 거리
            if(x<r){ 
                for(int i=0; i<r-x; i++){
                    trace+='d';
                }
            }
            if(y>c){ 
                for(int i=0; i<y-c; i++){
                    trace+='l';
                }
            }
            if(y<c){ 
                for(int i=0; i<c-y; i++){
                    trace+='r';
                }
            }
            if(x>r){ 
                for(int i=0; i<x-r; i++){
                    trace+='u';
                }
            }
            return;
        }
        
        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny<1 || nx<1 || ny>m || nx>n){
                continue;
            }
            else{
                trace+=alpha[i];
                recurSive(n,m,nx,ny,r,c,k-1);
                break;
            }
        }
        
    }
}

// 문자열 사전 순이니 사전 순으로 순회하고 거리가 k이면 갱신하는 방식
// d l r u

// 풀이 방법
// 처음 불가능 판단해야 함
// 현재 위치 -> 목표 위치까지 최단 거리 구했는데 둘 다 짝수 or 홀수가 아니면 불가능
// 최단거리는 그냥 좌표 서로 빼서 더하면 됨

// 정확히 k로 갈 수 있다면
// 최단거리 < k 이면 d -> l -> r -> u 순서로 일단 진행
// 최단거리 == k이면 이제 정확히 움직여야 함