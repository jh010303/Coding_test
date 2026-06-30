import java.util.*;

class Solution {
    Queue<Integer> que = new LinkedList<>();
    int server=0;
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        for(int t=0; t<players.length; t++){
            checkServer(t);
            int player = players[t];
            int needServer = player/m;
            //System.out.println(needServer+" "+server);
            if(server<needServer){
                for(int i=0; i<needServer-server; i++){
                    que.offer(t+k);
                }
                answer+=(needServer-server);
                server+=(needServer-server);
            }
            
            //System.out.println("t: "+t+" server: "+server+" answer: "+answer);
        }
        return answer;
    }
    
    void checkServer(int t){
        while(!que.isEmpty()){
            int curT = que.peek();
            if(curT<=t){
                que.poll();
                server--;
            }
            else{
                break;
            }
        }
    }
}