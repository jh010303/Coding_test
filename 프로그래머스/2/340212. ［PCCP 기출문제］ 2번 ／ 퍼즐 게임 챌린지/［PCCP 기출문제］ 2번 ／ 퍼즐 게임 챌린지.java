class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int l = 1;
        int r = 1;
        for(int i=0; i<diffs.length; i++){
            if(r<diffs[i]){
                r = diffs[i];
            }
        }
        int answer = r;
        
        while(l<=r){
            int mid = (l+r)/2;
            long time = getTime(diffs,times,mid);
            
            if(time>limit){
                l = mid+1;
            }else{
                answer = Math.min(answer,mid);
                r = mid-1;
            }
        }
        
        return answer;
    }
    
    long getTime(int[] diffs, int[] time, int level){
        long res = 0;
        
        for(int i=0; i<diffs.length; i++){
            int diff = diffs[i]; int t = time[i];
            if(diff<=level){
                res+=t;
            }
            else{
                res+=((diff-level)*(t+time[i-1])+t);
            }
        }
        
        return res;
    }
}

// diff<=level이면 time_cur 소요
// diff>level이면 (diff-level)*(time_cur+time_prev)+time_cur
// 이전 퍼즐을 풀 때는 이전 퍼즐의 난이도에 상관없이 틀리지 않음

// 제한 시간 (limit) 내에 퍼즐을 풀기 위한 최소의 level
// diffs, times의 길이 <=300000

// 이분 탐색?
// nlogn안에 가능

// time > limit -> level 증가 
// time < limit -> level 감소 => 계속 정답 갱신
// time = limit -> 이 level이 정답

// level이 감소 -> time 증가