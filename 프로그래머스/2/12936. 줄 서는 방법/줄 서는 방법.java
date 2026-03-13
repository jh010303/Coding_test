import java.util.*;

class Solution {
    static long[] dp = new long[21];
    public List<Integer> solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[21];
        long div = 0L;
        k--;
        for(int i=n; i>1; i--){
            div = fib(i-1);
            int num = (int)(k/div);
            int move = 0;
            for(int j=1; j<=20; j++){
                if(!visited[j]){
                    if(move==num){
                        list.add(j);
                        visited[j]=true;
                        break;   
                    }
                    else{
                        move++;
                    }
                }
            }
            if(num>0){
                k%=div;
            }
        }
        for(int i=1; i<=20; i++){
            if(!visited[i]){
                list.add(i);
                break;
            }
        }
        return list;
    }
    
    public long fib(int n){
        if(n<=1){
            return 1;
        }
        return n*fib(n-1);
    }
}