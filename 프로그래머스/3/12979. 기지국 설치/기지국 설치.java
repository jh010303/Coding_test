import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        for(int i=0; i<=stations.length; i++){
            int bef = i-1<0?1:stations[i-1]+w+1;
            int cur = i>=stations.length?n:stations[i]-w-1;
            if(bef>cur){
                continue;
            }
            int between = cur-bef+1;
            int cnt = (int)Math.ceil((double)between/(2*w+1));
            answer+=cnt;
        }
        return answer;
    }
}