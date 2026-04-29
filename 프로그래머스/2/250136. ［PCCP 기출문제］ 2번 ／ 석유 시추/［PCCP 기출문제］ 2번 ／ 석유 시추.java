import java.util.*;

class Solution {
    class Cord{
        int y;
        int x;
        public Cord(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    HashMap<Integer,Integer> oilMap = new HashMap<>();
    
    public int solution(int[][] land) {
        checkOil(land);
        int answer = extractOil(land);
        return answer;
    }
    
    int extractOil(int[][] land){
        int res = -1;
        Set<Integer> oilSet = new HashSet<>();
        for(int i=0; i<land[0].length; i++){
            oilSet.clear();
            int sum = 0;
            for(int j=0; j<land.length; j++){
                if(land[j][i]>0){
                    oilSet.add(land[j][i]);
                }
            }
            for(Integer o: oilSet){
                sum+=oilMap.get(o);
            }
            res = Math.max(res,sum);
        }
        return res;
    }
    
    void checkOil(int[][] land){
        int index = 2;
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[i].length; j++){
                if(land[i][j]==1){
                    oilfill(i,j,index++,land); 
                }                    
            }
        }
    }
    
    void oilfill(int y, int x, int index, int[][] land){
        Queue<Cord> que = new LinkedList<>();
        que.offer(new Cord(y,x));
        land[y][x] = index;
        int cnt = 1;
        while(!que.isEmpty()){
            Cord cur = que.poll();
            int cy = cur.y; int cx = cur.x;
            for(int i=0; i<4 ; i++){
                int ny = cy+dy[i]; int nx = cx+dx[i];
                if(ny<0 || nx<0 || ny>=land.length || nx>=land[0].length || land[ny][nx]!=1){
                    continue;
                }
                land[ny][nx] = index;
                que.offer(new Cord(ny,nx));
                cnt++;
            }
        }
        oilMap.put(index,cnt);
    }
}