import java.util.*;

class Solution {
    static int[] parent;
    static int answer;
    public int solution(int n, int[][] computers) {
        answer = n;
        parent = new int[n+1];
        Arrays.fill(parent,-1);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)continue;
                if(computers[i][j]==1){
                    union(i+1,j+1);
                }
            }
        }
        return answer;
    }
    
    static int find(int n){
        if(parent[n]<0){
            return n;
        }
        return parent[n] = find(parent[n]);
    }
    
    static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA==parentB){
            return;
        }
        parent[parentB]+=parent[parentA];
        parent[parentA] = parentB;
        answer--;
    }
    
}