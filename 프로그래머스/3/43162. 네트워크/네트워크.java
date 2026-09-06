import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        Arrays.fill(parent,-1);
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[i].length; j++){
                if(i==j){
                    continue;
                }
                if(computers[i][j]==1){
                    union(i,j);
                }
            }
        }
        
        for(int i=0; i<parent.length; i++){
            if(parent[i]<0){
                answer++;
            }
        }
        return answer;
    }
    
    int find(int n){
        if(parent[n]<0){
            return n;
        }
        return parent[n] = find(parent[n]);
    }
    
    void union(int n1, int n2){
        int p1 = find(n1), p2 = find(n2);
        if(p1==p2){
            return;
        }
        parent[p1]+=parent[p2];
        parent[p2]=p1;
    }
}

// 집합 개수 구하기