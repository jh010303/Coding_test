import java.util.*;

class Solution {
    int[] island;
    int answer = 0;
    public int solution(int n, int[][] costs) {
        island = new int[n];
        Arrays.fill(island,-1);
        Arrays.sort(costs,(a,b)->{
            return Integer.compare(a[2],b[2]);
        });
        
        for(int i=0; i<costs.length; i++){
            union(costs[i][0], costs[i][1], costs[i][2]);
        }
        return answer;
    }
    
    int find(int n){
        if(island[n]<0){
            return n;
        }
        return island[n] = find(island[n]);
    }
    
    void union(int n1, int n2, int w){
        int p1 = find(n1), p2 = find(n2);
        if(p1==p2){
            return;
        }
        island[p1]+=island[p2];
        island[p2] = p1;
        answer+=w;
    }
}   