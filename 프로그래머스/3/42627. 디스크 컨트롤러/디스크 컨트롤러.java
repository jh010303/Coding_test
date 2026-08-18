import java.util.*;

class Solution {
    class Process{
        int n; // 번호
        int r; // 요청 시각
        int t; // 소요 시간 
        
        public Process(int n, int r, int t){
            this.n = n;
            this.r = r;
            this.t = t;
        }
    }
    
    PriorityQueue<Process> pq = new PriorityQueue<>((a,b)->{
        if(a.t==b.t){
            if(a.r==b.r){
                return a.n - b.n;
            }
            return a.r - b.r;
        }
        return a.t - b.t;
    });
    
    public int solution(int[][] jobs) {
        int answer = 0; int sum = 0;
        
        Arrays.sort(jobs,(a,b)->{
           return a[0]-b[0]; 
        });
    
        int time = 0; int jobIndex = 0;
        int requestTime = -1; int endTime = -1;
        boolean working = false;
        
        while(true){
            if(jobIndex>=jobs.length && pq.isEmpty() && !working){ // 종료 조건
                break;
            }
            
            while(jobIndex<jobs.length && jobs[jobIndex][0]==time){ // 큐에 넣음, 항상 진행해야 함
                pq.offer(new Process(jobIndex,time,jobs[jobIndex][1]));
                jobIndex++;
            }
            
            if(working && time == endTime){ // 현재 작업중인 프로세스 종료
                sum+=(time-requestTime);
                working = false;
            }
            
            if(!working && !pq.isEmpty()){ // 작업중인 프로세스 없다면 큐에서 뽑아야 함
                Process nextProcess = pq.poll();
                requestTime = nextProcess.r;
                endTime = time+nextProcess.t;
                
                working = true;
            }
            
            time++;
        }
        
        answer = sum/jobs.length;
        
        return answer;
    }
}

// 작업 중이라면 pq1에 계속 쌓아둠 
// 다음 작업을 위해 pq1 -> pq2 -> pq3해서 pq3에서 뽑아서 사용
// 뽑은거 제외하고 모두 pq1에 넣음
