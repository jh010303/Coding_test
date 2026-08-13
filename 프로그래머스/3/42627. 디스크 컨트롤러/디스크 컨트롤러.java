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
    
    PriorityQueue<Process> pq1 = new PriorityQueue<>((a,b)->{
        return a.t - b.t;
    });
    PriorityQueue<Process> pq2 = new PriorityQueue<>((a,b)->{
        return a.r - b.r;
    });
    PriorityQueue<Process> pq3 = new PriorityQueue<>((a,b)->{
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
            if(jobIndex>=jobs.length && pq1.isEmpty() && !working){ // 종료 조건
                break;
            }
            
            if(working && time == endTime){ // 현재 작업중인 프로세스 종료
                sum+=(time-requestTime);
                working = false;
                //System.out.println(time+" "+requestTime);
            }
            
            while(jobIndex<jobs.length && jobs[jobIndex][0]==time){ // 큐에 넣음, 항상 진행해야 함
                pq1.offer(new Process(jobIndex,time,jobs[jobIndex][1]));
                jobIndex++;
            }
            
            if(!working && !pq1.isEmpty()){ // 작업중인 프로세스 없다면 큐에서 뽑아야 함
                // pq1에서 뽑음
                int minT = 1001; int minR = 1001; int minN = 1001;
                
                while(!pq1.isEmpty()){ // pq1 -> pq2 작업
                    Process p1 = pq1.poll();
                    minT = Math.min(minT,p1.t);
                    if(p1.t>minT){
                        pq1.offer(p1);
                        break;
                    }
                    pq2.offer(p1);
                }
                
                while(!pq2.isEmpty()){ // pq2 -> pq3 작업
                    Process p2 = pq2.poll();
                    minR = Math.min(minR,p2.r);
                    if(p2.r>minR){
                        pq2.offer(p2);
                        break;  
                    }
                    pq3.offer(p2);
                }
                
                Process nextProcess = pq3.poll();
                requestTime = nextProcess.r;
                endTime = time+nextProcess.t;
                
                while(!pq2.isEmpty()){
                    pq1.offer(pq2.poll());
                }
                
                while(!pq3.isEmpty()){
                    pq1.offer(pq3.poll());
                }
                
                working = true;
                //System.out.println("queue pop: "+pq1.size());
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
