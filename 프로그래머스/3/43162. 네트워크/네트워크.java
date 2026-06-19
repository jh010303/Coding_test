import java.util.*;

class Solution {
    
    int[] parent;
    int answer = 0;
    public int solution(int n, int[][] computers) {
        answer = n;
        parent = new int[n];
        Arrays.fill(parent,-1);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    continue;
                }
                if(computers[i][j]==1){
                    union(i,j);
                }
            }
        }
        
        return answer;
    }
    
    int find(int n){
        if(parent[n]<0){
            return n;
        }
        return parent[n]=find(parent[n]);
    }
    
    void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA!=parentB){
            parent[parentB]+=parent[parentA];
            parent[parentA] = parentB;
            answer--;
        }
        
    }
}

// 유니온 파인드 사용, 집합의 개수가 정답
// 