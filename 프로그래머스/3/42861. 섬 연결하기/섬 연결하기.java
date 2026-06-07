import java.util.*;

class Solution {
    int[] parent;
    int answer = 0;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        Arrays.fill(parent,-1);
        Arrays.sort(costs,(a,b)->{
           return Integer.compare(a[2],b[2]); 
        });
        
        for(int i=0; i<costs.length; i++){
            int s = costs[i][0]; int e = costs[i][1]; int w = costs[i][2];
            union(s,e,w);
        }
        
        return answer;
    }
    
    int find(int n){
        if(parent[n]<0){
            return n;
        }
        return parent[n] = find(parent[n]);
    }
    
    void union(int s, int e, int w){
        int p1 = find(s);
        int p2 = find(e);
        
        if(p1==p2){
            return;
        }
        
        answer+=w;
        parent[p2]=p1;
    }
}