import java.util.*;

class Solution {
    class Robot{
        int y;
        int x;
        int n; // 인덱스 아님
        int t; // 다음타켓 index임
        public Robot(int y, int x, int n, int t){
            this.y = y;
            this.x = x;
            this.n = n;
            this.t = t;
        }
    }
    
    List<Robot> robots = new ArrayList<>(); // 로봇 좌표 저장
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        initRobots(points,routes);
        
        List<Integer> removeRobots = new ArrayList<>(); // 인덱스 들어감
        boolean[][] visited = new boolean[101][101];
        
        while(!robots.isEmpty()){ // 로봇이 존재하는 동안 동작
            // 1. 로봇 겹치는거 확인
            for(int i=0; i<101; i++){
                Arrays.fill(visited[i],false);
            }
            
            for(int i=0; i<robots.size()-1; i++){
                Robot r1 = robots.get(i);
                for(int j=i+1; j<robots.size(); j++){
                    Robot r2 = robots.get(j);
                    if(r1.y==r2.y && r1.x==r2.x && !visited[r1.y][r1.x]){
                        visited[r1.y][r1.x]=true;
                        answer++;
                    }
                }
            }
                        
            // 2. 로봇 움직이기
            for(int i=0; i<robots.size(); i++){
                Robot robot = robots.get(i);
                int cy = robot.y; int cx = robot.x; int cn = robot.n; int t = robot.t;
                int ny = points[routes[cn-1][t]-1][0]; int nx = points[routes[cn-1][t]-1][1];
                
                if(cy!=ny){
                    robot.y = cy>ny?cy-1:cy+1;
                }
                else if(cx!=nx){
                    robot.x = cx>nx?cx-1:cx+1;
                }
                else{
                    if(t==routes[0].length-1){
                        removeRobots.add(i);
                    }
                    else{
                        robot.t+=1;
                        i--;
                        continue;
                    }
                }
            }
            
            // 3. 모두 움직인 로봇 제거
            for(int i=removeRobots.size()-1; i>=0; i--){
                robots.remove((int)removeRobots.get(i));
            }
            removeRobots.clear();
        }
        return answer;
    }
    
    void initRobots(int[][] points, int[][] routes){ 
        for(int i=0; i<routes.length; i++){
            int cur = routes[i][0];
            int cy = points[cur-1][0]; int cx = points[cur-1][1];
            robots.add(new Robot(cy,cx,i+1,1));
        }
    }
}