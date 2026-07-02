import java.util.*;

class Solution {
    class Homework implements Comparable<Homework>{
        String name;
        int start; // 시작 시간 분으로 표현
        int playTime;
        
        public Homework(String name, int start, int playTime){
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
        
        @Override 
        public int compareTo(Homework h){ 
            return Integer.compare(this.start,h.start);
        }
    }
    
    PriorityQueue<Homework> pq = new PriorityQueue<>(); // 안 멈춘 과제만 있음
    Stack<Homework> stk = new Stack<>(); // 멈춘 과제만 있음
    
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<plans.length; i++){
            String name = plans[i][0];
            int start = changeTime(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            
            pq.offer(new Homework(name,start,playTime));
        }
        
        int curTime = pq.peek().start;
        while(!pq.isEmpty()){
            Homework cur = pq.peek();
            int startTime = cur.start;
            if(curTime>=startTime){ // 현재 새로 시작할 과제 처리 시작
                pq.poll();
                Homework next = pq.peek();
                
                if(next==null || startTime+cur.playTime<=next.start){ // 새로 시작한 과제 처리 가능
                    answer.add(cur.name);
                    curTime+=cur.playTime;
                }
                else { // 처리 불가능
                    stk.push(new Homework(cur.name,cur.start,cur.playTime-(next.start-startTime)));
                    curTime = next.start;
                }
            }
            else{ // 남아 있는 과제 시작해야 함
                while(!stk.isEmpty()){
                    Homework top = stk.pop();
                    if(curTime+top.playTime<=startTime){
                        answer.add(top.name);
                        curTime+=top.playTime;
                    }
                    else{
                        stk.push(new Homework(top.name,top.start,top.playTime-(startTime-curTime)));
                        break;
                    }
                }
                curTime = startTime;
            }
        }
        
        while(!stk.isEmpty()){
            Homework cur = stk.pop();
            answer.add(cur.name);
        }
        
        return answer;
    }
    
    int changeTime(String time){
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3));
        return h*60+m;
    }
}