import java.util.*;

class Solution {
    int[][] d;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 20000001;
        d = new int[n+1][n+1];
        initD(fares,n);
        
        for(int i=1; i<=n; i++){
            answer = Math.min(answer,d[s][i]+d[i][a]+d[i][b]);
        }
        return answer;
    }
    
    void initD(int[][] fares, int n){
        for(int i=0; i<n+1; i++){
            Arrays.fill(d[i],20000001);
        }
        for(int i=0; i<n+1; i++){
            d[i][i] = 0;
        }
        
        for(int i=0; i<fares.length; i++){
            int s = fares[i][0]; int e = fares[i][1]; int f = fares[i][2];
            d[s][e] = f;
            d[e][s] = f;
        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    d[i][j] = Math.min(d[i][j],d[i][k]+d[k][j]);
                }
            }
        }
    }
}