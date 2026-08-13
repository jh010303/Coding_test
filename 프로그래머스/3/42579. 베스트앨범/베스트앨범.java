import java.util.*;

class Solution {
    class GenreSum{
        String name;
        int sum;
        public GenreSum(String name, int sum){
            this.name = name;
            this.sum = sum;
        }
    }
    
    class Genre{
        int n;
        int genre;
        int play;
        public Genre(int n, int genre, int play){
            this.n = n;
            this.genre = genre;
            this.play = play;
        }
    }
    
    HashMap<String,Integer> genreMap = new HashMap<>();
    HashMap<String,Integer> visited = new HashMap<>();
    int[] genreCnt = new int[100];
    
    List<GenreSum> genreList = new ArrayList<>();
    
    PriorityQueue<Genre> pq = new PriorityQueue<>((a,b)->{
        if(a.genre==b.genre){
            if(a.play==b.play){
                return a.n-b.n;
            }
            return b.play-a.play;
        }
        return a.genre-b.genre;
    });
    
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int visitedIndex = 0;
        for(int i=0; i<genres.length; i++){
            String g = genres[i];
            if(visited.containsKey(g)){
                genreList.get(visited.get(g)).sum+=plays[i];
            }
            else{
                genreList.add(new GenreSum(g,plays[i]));
                visited.put(g,visitedIndex++);
            }
        }
        
        Collections.sort(genreList,(a,b)->{
            return b.sum-a.sum;
        });
        
        // 재생횟수가 가장 높은 장르가 가장 낮은 index를 가짐 -> 우선순위 큐에서 정렬
        for(int i=0; i<genreList.size(); i++){
            genreMap.put(genreList.get(i).name,i);
        }
        
        for(int i=0; i<genres.length; i++){
            int g = genreMap.get(genres[i]); int p = plays[i];
            pq.offer(new Genre(i,g,p));
        }
        
        while(!pq.isEmpty()){
            Genre g = pq.poll();
            if(genreCnt[g.genre]<2){
                answer.add(g.n);
                genreCnt[g.genre]++;
            }
        }
        
        return answer;
    }
}

// 장르 고유 번호 필요 -> map 사용
// 고유 번호 사용하되, plays 횟수가 가장 많은것부터 등록
// 