import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        setSchedules(schedules);
        for(int i=0; i<timelogs.length; i++){
            int limitTime = schedules[i];
            for(int j=0; j<timelogs[i].length; j++){
                if(j==7-startday || j==((7-startday-1<0)?6:(7-startday-1))){ // 주말
                    continue;
                }
                int t = timelogs[i][j%7];
                if(limitTime<t){
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
    
    void setSchedules(int[] schedules){
        for(int i=0; i<schedules.length; i++){
            int time = schedules[i];
            time+=10;
            int m = time%100;
            if(m>=60){
                time+=40;
            }
            schedules[i] = time;
        }
    }
}

// 7 -> 0 6
// 6 -> 0 1
// 5 -> 1 2
// 1 -> 5 6
// startday-1 -> (j+startday-1)%7 