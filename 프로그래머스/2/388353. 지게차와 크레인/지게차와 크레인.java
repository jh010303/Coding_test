import java.util.*;

class Solution {
    class Cord{
        int y;
        int x;
        char e;
        
        public Cord(int y, int x, char e){
            this.y = y;
            this.x = x;
            this.e = e;
        }
    }
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    char[][] storages;
    int answer = 0;
    public int solution(String[] storage, String[] requests) {
        answer = storage.length*storage[0].length();
        initStorages(storage);

        for(String request:requests){
            char target = request.charAt(0);
            if(request.length()==1){
                bfs(target);
            }
            else{
                for(int i=0; i<storages.length; i++){
                    for(int j=0; j<storages[i].length; j++){
                        if(storages[i][j]==target){
                            storages[i][j] = '.';
                            answer--;
                        }
                    }
                }
            }
        }
        return answer;
    }
    
    void bfs(char target){
        Queue<Cord> que = new LinkedList<>();
        boolean[][] visited = new boolean[storages.length][storages[0].length];
        
        que.offer(new Cord(0,0,storages[0][0]));
        visited[0][0] = true;
        
        while(!que.isEmpty()){
            Cord cur = que.poll();
            int cy = cur.y; int cx = cur.x; int ce = cur.e;
            for(int i=0; i<4; i++){
                int ny = cy+dy[i]; int nx = cx+dx[i];
                if(ny<0 || nx<0 || ny>=storages.length || nx>=storages[0].length || visited[ny][nx]
                  || (storages[ny][nx]!= '.' && storages[ny][nx]!=target)){
                    continue;
                }
                
                char ne = storages[ny][nx];
                visited[ny][nx]=true;  
                if(ne==target){
                    storages[ny][nx]='.';
                    answer--;
                }
                else{
                    que.offer(new Cord(ny,nx,ne));
                }
            }
        }
    }
    
    void initStorages(String[] storage){
        storages = new char[storage.length+2][storage[0].length()+2];
        
        for(int i=0; i<storage.length; i++){
            for(int j=0; j<storage[i].length(); j++){
                storages[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        for(int i=0; i<storages.length; i++){
            for(int j=0; j<storages[i].length; j++){
                if(!('A'<=storages[i][j] && storages[i][j]<='Z')){
                    storages[i][j]= '.';
                }
            }
        }
    }
}